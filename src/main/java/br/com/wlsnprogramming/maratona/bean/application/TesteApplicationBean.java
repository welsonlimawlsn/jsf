package br.com.wlsnprogramming.maratona.bean.application;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable {

    private List<String> categoriaList;
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @PostConstruct
    public void init(){
        System.out.println("Entrou no PostConstruct do ApplicationScoped.");
        categoriaList = new ArrayList<>();
        //"RPG", "SCI-FI", "Terror"
        categoriaList.add("RPG");
        categoriaList.add("SCI-FI");
        categoriaList.add("Terror");
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public void addCategory(){
        categoriaList.add(categoria);
    }
}
