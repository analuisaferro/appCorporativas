package br.cefetrj.to.input;

import br.cefetrj.model.Quarto;
import br.cefetrj.model.TipoQuarto;

public class QuartoTOInput {

    private Long id;
    private Integer numero;
    private String tipo;
    private double precoNoite;
    private boolean status;
    private Long idHotel;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Quarto build() {
        var quarto = new Quarto();
        quarto.setId(id);
        quarto.setNumero(numero);
        quarto.setPrecoNoite(precoNoite);
        quarto.setStatus(status);

        if (tipo != null) {
            try {
                quarto.setTipo(TipoQuarto.valueOf(tipo.toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Tipo de quarto inválido: " + tipo);
            }
        }

        return quarto;
    }
}
