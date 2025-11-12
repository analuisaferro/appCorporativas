package br.cefetrj.to.input;

import br.cefetrj.model.Funcionario;

public class FuncionarioTOInput {

    private String nome;
    private String cpf;
    private String telefone;
    private String cargo;
    private double salario;
    private String login;
    private String senha;

    public FuncionarioTOInput() {
    }

    public Funcionario build() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(this.nome);
        funcionario.setCpf(this.cpf);
        funcionario.setTelefone(this.telefone);
        funcionario.setCargo(this.cargo);
        funcionario.setSalario(this.salario);
        funcionario.setLogin(this.login);
        funcionario.setSenha(this.senha);
        return funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
