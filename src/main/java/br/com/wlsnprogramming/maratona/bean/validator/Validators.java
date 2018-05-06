package br.com.wlsnprogramming.maratona.bean.validator;

import br.com.wlsnprogramming.maratona.bean.login.LoginBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class Validators implements Serializable {
    private List<String> emailsDB = Arrays.asList("welsonlimawlsn@gmail.com", "welsonlimawlt@gmail.com");

    @Inject
    private LoginBean loginBean;

    public void validateDuplicatedEmail(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String email = (String) o;
        if(emailsDB.contains(email)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este email já esta cadastrado", "");

            System.out.println(loginBean.getLanguage() + "Alguma coisa");

            throw new ValidatorException(message);
        }
    }

    public void validateFile(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Part file = (Part) o;
        try{
            validateFileName(file);
            validateContentType(file);
            validateFileSize(file);
        } catch (RuntimeException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), "");
            throw new ValidatorException(message);
        }
    }

    private void validateFileName(Part file) throws RuntimeException {
        if(file.getSubmittedFileName().length() > 10) {
            throw new RuntimeException("O nome + extensão não pode ser maior que 10 caracteres");
        }
    }

    private void validateContentType(Part file) throws RuntimeException {
        String contentType = file.getContentType();
        if(!contentType.equals("image/png") && !contentType.equals("image/jpeg")) {
            throw new RuntimeException("Só é permitido aquivo do tipo jpg/jpeg ou png");
        }
    }

    private void validateFileSize(Part file) throws RuntimeException{
        if(file.getSize() > 1048576){
            throw  new RuntimeException("O arqui não pode ser maior que 1MB");
        }
    }
}
