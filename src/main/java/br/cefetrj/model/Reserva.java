package br.cefetrj.model;

public class Reserva {
    private Integer id;
    private Hospede hospede;
    private boolean status = false;

    public Reserva(int id, Hospede hospede, boolean status) {
        this.id = id;
        this.hospede = hospede;
        this.status = status;
    }

    public void confirmar() {
        this.status = true;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
}