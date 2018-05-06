package br.com.wlsnprogramming.maratona.bean.beanvalidation;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.*;
import java.io.Serializable;

@Named
@ViewScoped
public class BeanValidationTestBean implements Serializable {

    @Size(min = 3, max = 10, message = "O nome tem que ter entre 3 e 10 caracteres.")
    @NotNull(message = "O nome é obrigatorio!")
    private String nome;

    @Pattern(regexp = "^([a-zA-Z0-9\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})", message = "Digite um email valido")
    @NotNull(message = "O email é obrigatório")
    private String email;

    @DecimalMax(value = "30.50", message = "O valor decimal não pode ser maior que 30.50")
    @DecimalMin(value = "5.00", message = "O valor decimal não pode ser maior que 5.00")
    private double decimal;

    @Digits(integer = 3, fraction = 2, message = "O valor inteiro não pode ser maior que 999 e a casa decimal não pode conter mais de 2 digitos")
    private double numero;

    public void salvar() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }
}
