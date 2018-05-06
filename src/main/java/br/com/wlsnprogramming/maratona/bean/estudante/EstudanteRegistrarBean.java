package br.com.wlsnprogramming.maratona.bean.estudante;

import br.com.wlsnprogramming.maratona.model.Estudante;

import javax.el.LambdaExpression;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named//("umNomeMaluco")
@ViewScoped
public class EstudanteRegistrarBean implements Serializable {

    private Estudante estudante = new Estudante();
    private String[] nomesArray = {"Welson", "Wilson", "Iraldo", "Maria", "Miguel", "Leticia", "Gabriel", "Mariana"};
    private List<String> nomesList = Arrays.asList("Welson", "Wilson", "Iraldo", "Maria", "Miguel", "Leticia", "Gabriel", "Mariana");
    private Set<String> nomesSet = new HashSet<>(Arrays.asList("Welson", "Wilson", "Iraldo", "Maria", "Miguel", "Leticia", "Gabriel", "Mariana"));
    private Map<String, String> nomesMap = new HashMap<>();
    private boolean mostrarNotas = false;
    private boolean mostrarLink = false;

    public void calcularCubo(LambdaExpression le, long value){
        long result = (long) le.invoke(FacesContext.getCurrentInstance().getELContext(), value);
        System.out.println(result);
    }

    public void exibirLink(){
        if(mostrarLink)
            mostrarLink = false;
        else
            mostrarLink = true;
    }
    public boolean isMostrarLink() {
        return mostrarLink;
    }

    public void setMostrarLink(boolean mostrarLink) {
        this.mostrarLink = mostrarLink;
    }

    public void mostrarNotasAluno(){
        if(mostrarNotas)
            mostrarNotas = false;
        else
            mostrarNotas = true;
    }
    public boolean isMostrarNotas() {
        return mostrarNotas;
    }

    public void setMostrarNotas(boolean mostrarNotas) {
        this.mostrarNotas = mostrarNotas;
    }

    public Map<String, String> getNomesMap() {
        return nomesMap;
    }

    public void setNomesMap(Map<String, String> nomesMap) {
        this.nomesMap = nomesMap;
    }

    {
        nomesMap.put("Goku", "O mais forte");
        nomesMap.put("One Piece", "O main longo");
        nomesMap.put("Naruto", "O com mais lenga, lenga");

        for(Map.Entry<String, String> entry : nomesMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public Set<String> getNomesSet() {
        return nomesSet;
    }

    public void setNomesSet(Set<String> nomesSet) {
        this.nomesSet = nomesSet;
    }


    public List<String> getNomesList() {
        return nomesList;
    }

    public void setNomesList(List<String> nomesList) {
        this.nomesList = nomesList;
    }

    public String[] getNomesArray() {
        return nomesArray;
    }

    public void setNomesArray(String[] nomesArray) {
        this.nomesArray = nomesArray;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public void executar( String param){
        System.out.println("Fazendo uma busca com " + param);
        System.out.println("Processando dados");
        System.out.println("Mostrando resultados");
    }

    public String executarRetorno(String param){
        return "Quem é o bonitão? " + param;
    }
    public String irParaIndex2(){
        System.out.println("=====================================================");
        System.out.println("Clicou no botao");
        System.out.println("======================================================");
        System.out.println("Clicou no botao");
        return "index2?faces-redirect=true";
    }
}
