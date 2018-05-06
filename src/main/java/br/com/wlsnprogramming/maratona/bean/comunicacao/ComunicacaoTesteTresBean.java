package br.com.wlsnprogramming.maratona.bean.comunicacao;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class ComunicacaoTesteTresBean implements Serializable {

    private String nome;
    private String sobrenome;
    private Date data;

    //@PostConstruct
    public void init(){
        //if(!FacesContext.getCurrentInstance().isPostback()) {
            System.out.println("Criou comunicação tres");
            System.out.println(nome);
            System.out.println(sobrenome);
        //}
    }

    public String save(){
        return "resultado?faces-redirect=true&includeViewParams=true";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
