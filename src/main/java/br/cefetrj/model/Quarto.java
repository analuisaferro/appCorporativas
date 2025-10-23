package br.cefetrj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quarto")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoQuarto tipo;

    @Column(nullable = false)
    private double precoNoite;

    @Column(nullable = false)
    private boolean status; // true = ocupado, false = livre

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    public Quarto() {
    }

    public Quarto(Integer numero, TipoQuarto tipo, double precoNoite, boolean status) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoNoite = precoNoite;
        this.status = status;
    }

    public void ocupar() {
        this.status = true;
    }

    public void liberar() {
        this.status = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoQuarto getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuarto tipo) {
        this.tipo = tipo;
    }

    public double getPrecoNoite() {
        return precoNoite;
    }

    public void setPrecoNoite(double precoNoite) {
        this.precoNoite = precoNoite;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
