package br.cefetrj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.model.Quarto;
import br.cefetrj.model.TipoQuarto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/quartos")
public class QuartoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QuartoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Quarto> quartos = new ArrayList<>();

        quartos.add(new Quarto(101, TipoQuarto.SIMPLES, 120.0, false));
        quartos.add(new Quarto(102, TipoQuarto.SIMPLES, 120.0, true));
        quartos.add(new Quarto(201, TipoQuarto.DUPLO, 180.0, false));
        quartos.add(new Quarto(202, TipoQuarto.DUPLO, 190.0, true));
        quartos.add(new Quarto(301, TipoQuarto.SUITE, 350.0, false));
        quartos.add(new Quarto(302, TipoQuarto.SUITE, 380.0, true));
        quartos.add(new Quarto(401, TipoQuarto.SIMPLES, 110.0, false));
        quartos.add(new Quarto(402, TipoQuarto.DUPLO, 200.0, false));
        quartos.add(new Quarto(501, TipoQuarto.SUITE, 420.0, true));
        quartos.add(new Quarto(502, TipoQuarto.DUPLO, 210.0, false));

        request.getSession().setAttribute("quartos", quartos);
        RequestDispatcher rd = request.getRequestDispatcher("quartoListar.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer numero = Integer.parseInt(request.getParameter("numero"));
        double precoNoite = Double.parseDouble(request.getParameter("precoNoite"));

        String status = request.getParameter("status");
        boolean disponivel = Boolean.parseBoolean(status);

        try {
            TipoQuarto tipo = TipoQuarto.valueOf(request.getParameter("tipo").toUpperCase());
            Quarto quarto = new Quarto(numero, tipo, precoNoite, disponivel);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de quarto inválido!");
        }


    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
