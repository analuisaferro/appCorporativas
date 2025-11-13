package br.cefetrj.to.output;

import java.time.LocalDate;

import br.cefetrj.model.Reserva;

public class ReservaTOOutput {

    private Long id;
    private Long idHospede;
    private String nomeHospede;
    private Long idQuarto;
    private Integer numeroQuarto;
    private LocalDate dataCheckin;
    private LocalDate dataCheckout;
    private boolean status;

    public ReservaTOOutput(Reserva reserva) {
        this.id = reserva.getId();
        this.dataCheckin = reserva.getDataCheckin();
        this.dataCheckout = reserva.getDataCheckout();
        this.status = reserva.isStatus();

        if (reserva.getHospede() != null) {
            this.idHospede = reserva.getHospede().getId();
            this.nomeHospede = reserva.getHospede().getNome(); 
        }

        if (reserva.getQuarto() != null) {
            this.idQuarto = reserva.getQuarto().getId();
            this.numeroQuarto = reserva.getQuarto().getNumero();
        }
    }

    public Long getId() {
        return id;
    }

    public Long getIdHospede() {
        return idHospede;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public Long getIdQuarto() {
        return idQuarto;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public LocalDate getDataCheckin() {
        return dataCheckin;
    }

    public LocalDate getDataCheckout() {
        return dataCheckout;
    }

    public boolean isStatus() {
        return status;
    }
}
