package br.cefetrj.to.output;

import br.cefetrj.model.Hospede;

public class HospedeTOOutput {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String telefoneEmergencia;

    public HospedeTOOutput() {}

    public HospedeTOOutput(Hospede hospede) {
        this.id = hospede.getId();
        this.nome = hospede.getNome();
        this.cpf = hospede.getCpf();
        this.telefone = hospede.getTelefone();
        this.email = hospede.getEmail();
        this.telefoneEmergencia = hospede.getTelefoneEmergencia();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefoneEmergencia() { return telefoneEmergencia; }
    public void setTelefoneEmergencia(String telefoneEmergencia) { this.telefoneEmergencia = telefoneEmergencia; }
}