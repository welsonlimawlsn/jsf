package br.com.wlsnprogramming.maratona.bean.comunicacao;

import br.com.wlsnprogramming.maratona.model.Estudante;
import br.com.wlsnprogramming.maratona.util.ApplicationMapUtil;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ComunicacaoTesteNoveBean implements Serializable {
    private List<Estudante> estudanteList = Estudante.estudanteList();

    public String editar(Estudante estudante){
        ApplicationMapUtil.setValueInApplicationValue("estudante", estudante);
        return "comunicacao9-2?faces-redirect=true";
    }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }
}
