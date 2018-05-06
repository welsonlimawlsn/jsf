package br.com.wlsnprogramming.maratona.bean.datatable;

import br.com.wlsnprogramming.maratona.model.Estudante;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

@Named
@ViewScoped
public class DataTableTestBean implements Serializable {

    private List<Estudante> estudanteList = Estudante.estudanteList();
    private transient boolean buttonSave;

    public void orderByNome(String order) {
        if (order.equals("asc")) {
            estudanteList.sort(Comparator.comparing(Estudante::getNome));
        } else {
            estudanteList.sort(Comparator.comparing(Estudante::getNome).reversed());
        }
    }

    public void orderBySobrenome(String order) {
        if (order.equals("asc")) {
            estudanteList.sort(Comparator.comparing(Estudante::getSobrenome));
        } else {
            estudanteList.sort(Comparator.comparing(Estudante::getSobrenome).reversed());
        }
    }

    public void remove(Estudante estudante) {
        // faz uma chamada para o banco
        estudanteList.remove(estudante);
    }

    public void edit(Estudante estudante) {
        estudante.setEditing(true);
        buttonSave = true;
    }

    public void save() {
        estudanteList.forEach(estudante -> {
            if(estudante.isEditing())
                System.out.println(estudante);
            estudante.setEditing(false);
            buttonSave = false;
        });
    }

    public boolean isButtonSave() {
        return buttonSave;
    }

    public void setButtonSave(boolean buttonSave) {
        this.buttonSave = buttonSave;
    }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }
}
