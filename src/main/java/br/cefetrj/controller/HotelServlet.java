package br.cefetrj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.model.Hotel;
import br.cefetrj.model.Quarto;
import br.cefetrj.model.TipoQuarto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hoteis")
public class HotelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HotelServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Hotel> hoteis = new ArrayList<>();

        // Hotel 1
        Hotel hotel1 = new Hotel("Hotel Sol", "Rua das Flores, 123", "11999990000", "");
        hotel1.adicionarQuarto(new Quarto(101, TipoQuarto.SIMPLES, 200.0, false));
        hotel1.adicionarQuarto(new Quarto(102, TipoQuarto.DUPLO, 300.0, true));
        hotel1.adicionarQuarto(new Quarto(103, TipoQuarto.SUITE, 500.0, false));
        hoteis.add(hotel1);

        // Hotel 2
        Hotel hotel2 = new Hotel("Hotel Lua", "Avenida Central, 456", "11988880000", "");
        hotel2.adicionarQuarto(new Quarto(201, TipoQuarto.SIMPLES, 180.0, true));
        hotel2.adicionarQuarto(new Quarto(202, TipoQuarto.DUPLO, 280.0, false));
        hoteis.add(hotel2);

        // Hotel 3
        Hotel hotel3 = new Hotel("Hotel Estrela", "Praça das Estrelas, 789", "11977770000", "");
        hotel3.adicionarQuarto(new Quarto(301, TipoQuarto.SUITE, 550.0, true));
        hotel3.adicionarQuarto(new Quarto(302, TipoQuarto.DUPLO, 320.0, false));
        hoteis.add(hotel3);

        request.getSession().setAttribute("hoteis", hoteis);
        RequestDispatcher rd = request.getRequestDispatcher("hotelListar.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String listaDeQuartos = request.getParameter("listaDeQuartos");

        Hotel hotel = new Hotel(nome, endereco, telefone, listaDeQuartos);

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
