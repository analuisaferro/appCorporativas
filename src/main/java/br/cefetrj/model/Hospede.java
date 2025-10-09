package br.cefetrj.model;

public class Hospede extends Pessoa {
    private String telefoneEmergencia;

    public Hospede(String nome, String cpf, String telefone, String email, String telefoneEmergencia) {

        super(nome, cpf, telefone, email);
        this.telefoneEmergencia = telefoneEmergencia;
    }
    public String getTelefoneEmergencia() {
        return telefoneEmergencia;
    }

    public void setTelefoneEmergencia(String telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }

}