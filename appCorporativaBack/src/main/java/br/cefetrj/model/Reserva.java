package br.cefetrj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hospede_id", nullable = false)
    private Hospede hospede;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "quarto_id", nullable = false)
    private Quarto quarto;

    private java.time.LocalDate dataCheckin;
    private java.time.LocalDate dataCheckout;

    @Column(nullable = false)
    private boolean status = false;

    public Reserva() {
    }

    public Reserva(Hospede hospede, Quarto quarto, java.time.LocalDate dataCheckin, java.time.LocalDate dataCheckout, boolean status) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.status = status;
    }

    public void confirmar() {
        this.status = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
    
    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public java.time.LocalDate getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(java.time.LocalDate dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public java.time.LocalDate getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(java.time.LocalDate dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}