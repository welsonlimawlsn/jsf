package br.com.wlsnprogramming.maratona.bean.request;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@RequestScoped
public class TesteRequestBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();

    @PostConstruct
    public void init(){
        System.out.println("Entrou no PostConstruct do RequestScoped");
        personagens = Arrays.asList("Yusuke", "Hiei", "Kurama");
    }

    public void selecionarPesonagem(){
        int index = ThreadLocalRandom.current().nextInt(personagens.size());
        personagemSelecionado.add(personagens.get(index));
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
}
