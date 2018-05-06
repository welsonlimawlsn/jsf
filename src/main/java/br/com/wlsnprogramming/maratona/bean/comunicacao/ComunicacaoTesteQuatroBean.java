package br.com.wlsnprogramming.maratona.bean.comunicacao;

import br.com.wlsnprogramming.maratona.model.Estudante;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ComunicacaoTesteQuatroBean implements Serializable {

    private String buttonName = "Nome do botao do bean";
    private Estudante estudante = new Estudante();

    public void execute(ActionEvent event){
        String nome = (String)event.getComponent().getAttributes().get("nome");
        String adjetivo = (String) event.getComponent().getAttributes().get("adjetivo");
        Estudante estudante = (Estudante) event.getComponent().getAttributes().get("estudante");
        String teste = (String) event.getComponent().getAttributes().get("teste");
        System.out.println(nome);
        System.out.println(adjetivo);
        System.out.println(estudante);
        System.out.println(teste);
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
