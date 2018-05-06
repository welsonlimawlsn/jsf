package br.com.wlsnprogramming.maratona.bean.ajax;

import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.asList;

@Named
@ViewScoped
public class AjaxTestBean implements Serializable {

    private String nome;
    private String sobrenome;
    private String email;
    private List<String> personagens;
    private String animeSelecionado;
    private String personagemSelecionado;
    private Map<String, List<String>> animePersonagensMap;

    public void init() {
        //if(!FacesContext.getCurrentInstance().isPostback()) {
            System.out.println("Entrou");
            animePersonagensMap = new TreeMap<>();
            animePersonagensMap.put("Hellsing", asList("Alucard", "Seras", "Alexarder"));
            animePersonagensMap.put("Attack on Titan", asList("Eren", "Mikasa", "Arumin"));
            animePersonagensMap.put("Berserk", asList("Guts", "Casca", "Griffith"));
        //}
    }

    public void toUpperCase(AjaxBehaviorEvent event){
        nome = nome.toUpperCase();
        sobrenome = sobrenome.toUpperCase();
    }

    public void toUpperCaseNome(){
        nome = nome.toUpperCase();
    }

    public void onSelectAnime(){
        if(animeSelecionado == null){
            personagens = null;
        } else {
            personagens = animePersonagensMap.get(animeSelecionado);
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<String> personagens) {
        this.personagens = personagens;
    }

    public String getAnimeSelecionado() {
        return animeSelecionado;
    }

    public void setAnimeSelecionado(String animeSelecionado) {
        this.animeSelecionado = animeSelecionado;
    }

    public String getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(String personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }

    public Map<String, List<String>> getAnimePersonagensMap() {
        return animePersonagensMap;
    }

    public void setAnimePersonagensMap(Map<String, List<String>> animePersonagensMap) {
        this.animePersonagensMap = animePersonagensMap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
