package br.cefetrj.controller;

import java.io.IOException;
import java.util.List;

import br.cefetrj.dao.HospedeDAO;
import br.cefetrj.dao.ReservaDAO;
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
    private ReservaDAO reservaDAO;
    private HospedeDAO hospedeDAO;

    public ReservaServlet() {
        super();
        reservaDAO = new ReservaDAO();
        hospedeDAO = new HospedeDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        if (acao == null) acao = "listar";

        switch (acao) {
            case "listar":
                listarReservas(request, response);
                break;
            case "novo":
                request.setAttribute("hospedes", hospedeDAO.listarTodos());
                request.getRequestDispatcher("reservaCadastrar.jsp").forward(request, response);
                break;
            case "editar":
                editarReserva(request, response);
                break;
            case "excluir":
                excluirReserva(request, response);
                break;
            default:
                listarReservas(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        Integer hospedeId = Integer.parseInt(request.getParameter("hospedeId"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));

        Hospede hospede = hospedeDAO.buscarPorId(hospedeId);
        Reserva reserva;

        if (idStr == null || idStr.isEmpty()) {
            reserva = new Reserva(hospede, status);
            reservaDAO.salvar(reserva);
        } else {
            Integer id = Integer.parseInt(idStr);
            reserva = reservaDAO.buscarPorId(id);
            if (reserva != null) {
                reserva.setHospede(hospede);
                reserva.setStatus(status);
                reservaDAO.atualizar(reserva);
            }
        }

        response.sendRedirect(request.getContextPath() + "/reservas");
    }

    private void listarReservas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Reserva> reservas = reservaDAO.listarTodos();
        request.setAttribute("reservas", reservas);
        RequestDispatcher rd = request.getRequestDispatcher("reservaLista.jsp");
        rd.forward(request, response);
    }

    private void editarReserva(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Reserva reserva = reservaDAO.buscarPorId(id);
        request.setAttribute("reserva", reserva);
        request.setAttribute("hospedes", hospedeDAO.listarTodos());
        RequestDispatcher rd = request.getRequestDispatcher("reservaCadastrar.jsp");
        rd.forward(request, response);
    }

    private void excluirReserva(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        reservaDAO.deletar(id);
        response.sendRedirect(request.getContextPath() + "/reservas");
    }
}
