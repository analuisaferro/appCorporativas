package br.cefetrj.model;

import java.time.*;
import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDate dataCriacao;
    private LocalDate dataUltimaAlteracao;
    private Funcionario criadoPor;
    private Funcionario alteradoPor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(LocalDate dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Funcionario getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(Funcionario criadoPor) {
        this.criadoPor = criadoPor;
    }

    public Funcionario getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(Funcionario alteradoPor) {
        this.alteradoPor = alteradoPor;
    }
}