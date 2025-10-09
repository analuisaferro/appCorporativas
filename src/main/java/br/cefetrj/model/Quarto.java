package br.cefetrj.model;

public class Quarto {
    private Integer numero;
    private TipoQuarto tipo;
    private double precoNoite;
    private boolean status; // true = ocupado, false = livre

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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}