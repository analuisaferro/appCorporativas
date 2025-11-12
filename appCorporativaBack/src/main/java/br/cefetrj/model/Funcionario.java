package br.cefetrj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {

    private String cargo;
    private double salario;
    
    private String login;
    private String senha; 

    public Funcionario() {
        super();
    }

    public Funcionario(String nome, String cpf, String telefone, String cargo, double salario, String login, String senha) {
        super(nome, cpf, telefone);
        this.cargo = cargo;
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}