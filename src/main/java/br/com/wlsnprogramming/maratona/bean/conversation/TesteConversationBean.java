package br.com.wlsnprogramming.maratona.bean.conversation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@ConversationScoped
public class TesteConversationBean implements Serializable {

    private List<String> personagens;
    private List<String> personagensSelecionados = new ArrayList<>();

    @Inject
    private Conversation conversation;

    public void init() {
        System.out.println("Entrou no PostConstruct do ConversationScoped");
        personagens = Arrays.asList("Luffy", "Zoro", "Sanji");
        if(conversation.isTransient()){
            conversation.begin();
            System.out.println("Iniciando ConversationScoped, ID: " + conversation.getId());
        }
    }

    public String endConversation(){
        if(!conversation.isTransient()){
            conversation.end();
            System.out.println("ConversationScoped finalizado");
        }
        return "conversation?faces-redirect=true";
    }

    public void selecionarPersonagem(){
        int index = ThreadLocalRandom.current().nextInt(personagens.size());
        personagensSelecionados.add(personagens.get(index));
    }

    public List<String> getPersonagensSelecionados() {
        return personagensSelecionados;
    }

    public void setPersonagensSelecionados(List<String> personagensSelecionados) {
        this.personagensSelecionados = personagensSelecionados;
    }

    public Conversation getConversation() {
        return conversation;
    }
}
