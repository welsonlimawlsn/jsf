package br.com.wlsnprogramming.maratona.bean.session;

import br.com.wlsnprogramming.maratona.model.Estudante;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@SessionScoped
public class TesteSessionBean implements Serializable {

    private List<String> personagens;
    private List<String> personagensSelecionados = new ArrayList<>();
    private Estudante estudante;

    @PostConstruct
    public void init(){
        System.out.println("Entrou no PostConstruct do SessionScoped");
        personagens = Arrays.asList("Naruto", "Sasuke", "Sakura");
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "seesion?faces-redirect=true";
    }

    public void logar(){
        //verificou
        estudante = new Estudante();
    }

    public void selecionarPersonagem(){
        int index = (int)ThreadLocalRandom.current().nextInt(personagens.size());
        personagensSelecionados.add(personagens.get(index));
    }

    public List<String> getPersonagensSelecionados() {
        return personagensSelecionados;
    }

    public void setPersonagensSelecionados(List<String> personagensSelecionados) {
        this.personagensSelecionados = personagensSelecionados;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
