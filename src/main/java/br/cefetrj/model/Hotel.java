package br.cefetrj.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Quarto> listaDeQuartos = new ArrayList<>();

    public Hotel(String nome, String endereco, String telefone, String listaDeQuartos1) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.listaDeQuartos = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        listaDeQuartos.add(quarto);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setListaDeQuartos(List<Quarto> listaDeQuartos) {
        this.listaDeQuartos = listaDeQuartos;
    }

   
}