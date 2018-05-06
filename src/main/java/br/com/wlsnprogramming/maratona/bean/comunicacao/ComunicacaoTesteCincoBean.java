package br.com.wlsnprogramming.maratona.bean.comunicacao;

import br.com.wlsnprogramming.maratona.model.Estudante;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ComunicacaoTesteCincoBean implements Serializable {

    private String nome;
    private String sobrenome;
    private Estudante estudante = new Estudante();
    private Estudante estudante2;

    public void execute(){
        System.out.println("Método execute: " + nome);
        System.out.println("Método execute: " + sobrenome);
        System.out.println("Método execute: " + estudante2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        System.out.println("Veio do setPropertyActionListener: " + nome);
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        System.out.println("Veio do setPropertyActionListener: " + sobrenome);
        this.sobrenome = sobrenome;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Estudante getEstudante2() {
        return estudante2;
    }

    public void setEstudante2(Estudante estudante2) {
        this.estudante2 = estudante2;
    }
}
