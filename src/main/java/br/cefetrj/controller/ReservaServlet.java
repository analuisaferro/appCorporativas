package br.cefetrj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.model.Hospede;
import br.cefetrj.model.Reserva;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reservas")
public class ReservaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReservaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Reserva> reservas = new ArrayList<>();

        // Criando hóspedes falsos
        Hospede h1 = new Hospede("Ana Ferro", "123.456.789-00", "11999990000", "ana@exemplo.com", "11999990001");
        Hospede h2 = new Hospede("Bruno Silva", "987.654.321-00", "11988880000", "bruno@exemplo.com", "11988880001");
        Hospede h3 = new Hospede("Carla Mendes", "111.222.333-44", "11977770000", "carla@exemplo.com", "11977770001");

        // Criando reservas falsas
        reservas.add(new Reserva(1, h1, true));
        reservas.add(new Reserva(2, h2, false));
        reservas.add(new Reserva(3, h3, true));

        request.getSession().setAttribute("reservas", reservas);
        RequestDispatcher rd = request.getRequestDispatcher("reservaListar.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String telefoneEmergencia = request.getParameter("telefoneEmergencia");


        Hospede hospede = new Hospede(nome, cpf, telefone, email, telefoneEmergencia);

        Integer id = Integer.parseInt(request.getParameter("id"));

        String status = request.getParameter("status");
        boolean disponivel = Boolean.parseBoolean(status);

        Reserva reserva = new Reserva(id, hospede, disponivel);

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
