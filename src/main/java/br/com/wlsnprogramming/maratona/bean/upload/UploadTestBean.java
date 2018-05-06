package br.com.wlsnprogramming.maratona.bean.upload;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;

@Named
@ViewScoped
public class UploadTestBean implements Serializable {

    private Part file;

    public void upload(){
        if(file == null)
            return;
        try(InputStream inputStream = file.getInputStream()){
            System.out.println("SubmittedFileName: " + file.getSubmittedFileName());
            System.out.println("Name: " + file.getName());
            System.out.println("Size: " + (file.getSize() / 1024.0) + "KB");
            System.out.println("ContentType: " + file.getContentType());
            System.out.println("HeaderNames: " + file.getHeaderNames());
            System.out.println("Content-Disposition: " + file.getHeader("Content-Disposition"));
            System.out.println("Content-Type: " + file.getHeader("Content-Type"));

            Files.copy(
                    inputStream,
                    new File(
                            "C:\\Users\\welso\\IdeaProjects\\maratona-jsf",
                            file.getSubmittedFileName()).toPath());

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Arquivo enviado com sucesso!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }catch (FileAlreadyExistsException e){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "O arquivo já existe no servidor!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}
