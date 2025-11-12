package br.cefetrj.to.output;

import br.cefetrj.model.Quarto;

public class QuartoTOOutput {

    private Long id;
    private Integer numero;
    private String tipo;
    private double precoNoite;
    private boolean status;
    private Long idHotel;

    public QuartoTOOutput(Quarto quarto) {
        this.id = quarto.getId();
        this.numero = quarto.getNumero();
        this.tipo = quarto.getTipo() != null ? quarto.getTipo().name() : null;
        this.precoNoite = quarto.getPrecoNoite();
        this.status = quarto.isStatus();
        this.idHotel = quarto.getHotel() != null ? quarto.getHotel().getId() : null;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoNoite() {
        return precoNoite;
    }

    public boolean isStatus() {
        return status;
    }

    public Long getIdHotel() {
        return idHotel;
    }
}
