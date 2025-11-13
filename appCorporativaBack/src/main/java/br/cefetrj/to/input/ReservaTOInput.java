package br.cefetrj.to.input;

import java.time.LocalDate;

import br.cefetrj.model.Hospede;
import br.cefetrj.model.Quarto;
import br.cefetrj.model.Reserva;

public class ReservaTOInput {

    private Long id;
    private Long hospedeId;
    private Long quartoId;
    private LocalDate dataCheckin;
    private LocalDate dataCheckout;
    private boolean status;

    public ReservaTOInput() {
    }

    public Reserva build() {
        Reserva reserva = new Reserva();
        reserva.setId(this.id);
        reserva.setDataCheckin(this.dataCheckin);
        reserva.setDataCheckout(this.dataCheckout);
        reserva.setStatus(this.status);

        if (hospedeId != null) {
            Hospede hospede = new Hospede();
            hospede.setId(hospedeId);
            reserva.setHospede(hospede);
        }

        if (quartoId != null) {
            Quarto quarto = new Quarto();
            quarto.setId(quartoId);
            reserva.setQuarto(quarto);
        }

        return reserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHospedeId() {
        return hospedeId;
    }

    public void setHospedeId(Long hospedeId) {
        this.hospedeId = hospedeId;
    }

    public Long getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(Long quartoId) {
        this.quartoId = quartoId;
    }

    public LocalDate getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(LocalDate dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public LocalDate getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(LocalDate dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
