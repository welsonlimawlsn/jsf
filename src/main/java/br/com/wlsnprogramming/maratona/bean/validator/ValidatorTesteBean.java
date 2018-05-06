package br.com.wlsnprogramming.maratona.bean.validator;

import br.com.wlsnprogramming.maratona.model.Estudante;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ValidatorTesteBean implements Serializable {
    private Estudante estudante = new Estudante();

    public void save() {
        System.out.println("Salvando estudante");
        System.out.println(estudante.getEmail());
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
