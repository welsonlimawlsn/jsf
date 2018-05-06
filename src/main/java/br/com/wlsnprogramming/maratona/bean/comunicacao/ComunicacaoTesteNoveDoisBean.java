package br.com.wlsnprogramming.maratona.bean.comunicacao;

import br.com.wlsnprogramming.maratona.model.Estudante;
import br.com.wlsnprogramming.maratona.util.ApplicationMapUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ComunicacaoTesteNoveDoisBean implements Serializable {

    private Estudante estudante;
    private Estudante estudante2 = new Estudante();

    public void init(){
        estudante = (Estudante) ApplicationMapUtil.getValueFromApplicationMap("estudante");
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
