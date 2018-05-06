package br.com.wlsnprogramming.maratona.bean.dependent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@Dependent
public class TesteDependentBean implements Serializable {

    private List<String> personagens;
    private List<String> personagensSelecionados = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct do Dependent");
        personagens = Arrays.asList("Naruto", "Hinata", "Yondaime");
    }

    public void selecionarPersonagem() {
        int index = ThreadLocalRandom.current().nextInt(personagens.size());
        personagensSelecionados.add(personagens.get(index));
    }

    public List<String> getPersonagensSelecionados() {
        return personagensSelecionados;
    }

    public void setPersonagensSelecionados(List<String> personagensSelecionados) {
        this.personagensSelecionados = personagensSelecionados;
    }


}
