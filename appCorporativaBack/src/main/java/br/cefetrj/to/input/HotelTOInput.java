package br.cefetrj.to.input;

import java.util.ArrayList;
import java.util.List;

import br.cefetrj.model.Hotel;
import br.cefetrj.model.Quarto;

public class HotelTOInput {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private List<QuartoTOInput> listaDeQuartos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<QuartoTOInput> getListaDeQuartos() {
        return listaDeQuartos;
    }

    public void setListaDeQuartos(List<QuartoTOInput> listaDeQuartos) {
        this.listaDeQuartos = listaDeQuartos;
    }

    public Hotel build() {
        var hotel = new Hotel();
        hotel.setId(id);
        hotel.setNome(nome);
        hotel.setEndereco(endereco);
        hotel.setTelefone(telefone);

        if (listaDeQuartos != null) {
            List<Quarto> quartos = new ArrayList<>();
            for (QuartoTOInput quartoTO : listaDeQuartos) {
                var quarto = quartoTO.build();
                quarto.setHotel(hotel); 
                quartos.add(quarto);
            }
            hotel.setListaDeQuartos(quartos);
        }

        return hotel;
    }
}
