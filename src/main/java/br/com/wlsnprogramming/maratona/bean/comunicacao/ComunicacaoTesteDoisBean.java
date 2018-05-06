package br.com.wlsnprogramming.maratona.bean.comunicacao;

import org.omnifaces.cdi.Param;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@Named
@ViewScoped
public class ComunicacaoTesteDoisBean implements Serializable {

    @Inject @Param(name = "nome2")
    private String nome;
    @Inject @Param(name = "sobrenome2")
    private String sobrenome;

    @PostConstruct
    public void init(){
        Map<String, String> paramsMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        //nome = paramsMap.get("nome");
        //sobrenome = paramsMap.get("sobrenome");
        System.out.println(nome);
        System.out.println(sobrenome);
        System.out.println(paramsMap.get("nome2"));
        System.out.println(paramsMap.get("sobrenome2"));
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
}
