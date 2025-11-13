package br.cefetrj.to.input;

import br.cefetrj.model.Hospede;

public class HospedeTOInput {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String telefoneEmergencia;

    public HospedeTOInput() {
    }

    public Hospede build() {
        Hospede hospede = new Hospede();
        hospede.setNome(this.nome);
        hospede.setCpf(this.cpf);
        hospede.setTelefone(this.telefone);
        hospede.setEmail(this.email);
        hospede.setTelefoneEmergencia(this.telefoneEmergencia);
        return hospede;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneEmergencia() {
        return telefoneEmergencia;
    }

    public void setTelefoneEmergencia(String telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }
}
