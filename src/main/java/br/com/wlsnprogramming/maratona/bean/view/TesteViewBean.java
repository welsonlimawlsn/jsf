package br.com.wlsnprogramming.maratona.bean.view;

import br.com.wlsnprogramming.maratona.bean.dependent.TesteDependentBean;
import br.com.wlsnprogramming.maratona.bean.session.TesteSessionBean;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@ViewScoped
public class TesteViewBean implements Serializable {

    private List<String> personagens;
    private List<String> personagensSelecionados = new ArrayList<>();
    private final TesteDependentBean dependentBean;
    private final TesteSessionBean sessionBean;

    @Inject
    public TesteViewBean(TesteDependentBean dependentBean, TesteSessionBean sessionBean) {
        this.dependentBean = dependentBean;
        this.sessionBean = sessionBean;
    }


    @PostConstruct
    public void init(){
        System.out.println("Entrou no PostConstruct do ViewScoped");
        personagens = Arrays.asList("Goku", "Vegeta", "Gohan");
    }

    public void selecionarPersonagem(){
        int index = (int)ThreadLocalRandom.current().nextInt(personagens.size());
        personagensSelecionados.add(personagens.get(index));
        dependentBean.getPersonagensSelecionados().add(personagens.get(index));
    }

    public List<String> getPersonagensSelecionados() {
        return personagensSelecionados;
    }

    public void setPersonagensSelecionados(List<String> personagensSelecionados) {
        this.personagensSelecionados = personagensSelecionados;
    }

    public TesteDependentBean getDependentBean() {
        return dependentBean;
    }

    public TesteSessionBean getSessionBean() {
        return sessionBean;
    }
}
