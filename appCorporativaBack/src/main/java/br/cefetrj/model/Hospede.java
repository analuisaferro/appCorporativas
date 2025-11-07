package br.cefetrj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "hospede")
public class Hospede extends Pessoa {

    private String telefoneEmergencia;
    private String email;

    public Hospede() {
        super();
    }

    public Hospede(String nome, String cpf, String telefone, String email, String telefoneEmergencia) {
        super(nome, cpf, telefone);
        this.email = email;
        this.telefoneEmergencia = telefoneEmergencia;
    }

    public String getTelefoneEmergencia() {
        return telefoneEmergencia;
    }

    public void setTelefoneEmergencia(String telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
