package br.cefetrj.to.output;

import br.cefetrj.model.Funcionario;

public class FuncionarioTOOutput {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String cargo;
    private double salario;
    private String login;

    public FuncionarioTOOutput() {}

    public FuncionarioTOOutput(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.telefone = funcionario.getTelefone();
        this.cargo = funcionario.getCargo();
        this.salario = funcionario.getSalario();
        this.login = funcionario.getLogin();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
}
