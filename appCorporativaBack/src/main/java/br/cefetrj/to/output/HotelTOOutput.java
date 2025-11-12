package br.cefetrj.to.output;

import java.util.ArrayList;
import java.util.List;

import br.cefetrj.model.Hotel;

public class HotelTOOutput {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private List<QuartoTOOutput> listaDeQuartos = new ArrayList<>();

    public HotelTOOutput(Hotel hotel) {
        this.id = hotel.getId();
        this.nome = hotel.getNome();
        this.endereco = hotel.getEndereco();
        this.telefone = hotel.getTelefone();

        if (hotel.getListaDeQuartos() != null) {
            hotel.getListaDeQuartos().forEach(quarto -> 
                listaDeQuartos.add(new QuartoTOOutput(quarto))
            );
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<QuartoTOOutput> getListaDeQuartos() {
        return listaDeQuartos;
    }
}