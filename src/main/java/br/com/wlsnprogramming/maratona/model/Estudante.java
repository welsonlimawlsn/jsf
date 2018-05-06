package br.com.wlsnprogramming.maratona.model;

import br.com.wlsnprogramming.maratona.model.enums.Turno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Estudante implements Serializable {

    private Integer id;
    private String nome = "Welson";
    private String sobrenome = "Teles";
    private double nota1 = 10;
    private double nota2 = 10;
    private double nota3 = 10;
    private Turno turno = Turno.MATUTINO;
    private String email;
    private transient boolean editing;

    public Estudante(){

    }

    public Estudante(String nome, String sobrenome, double nota1){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nota1 = nota1;
    }

    public Estudante(Integer id, String nome, String sobrenome, double nota1, String email){
        this(nome, sobrenome, nota1);
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }

    public static List<Estudante> estudanteList(){
        return new ArrayList<Estudante>(Arrays.asList(
                new Estudante(1,"Wilson", "Lima", 8, "wilsonlimawlsn@gmail.com"),
                new Estudante(2,"Maria", "Jesus", 8, "mariajesus@outlook.com"),
                new Estudante(3,"Iraldo", "Menezes", 8, "iradomenezes@yahoo.com")));
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                ", turno=" + turno +
                ", email='" + email + '\'' +
                ", editing=" + editing +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estudante estudante = (Estudante) o;

        return id != null ? id.equals(estudante.id) : estudante.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
