package br.cefetrj.controller;

import java.io.IOException;
import java.util.List;

import br.cefetrj.dao.HotelDAO;
import br.cefetrj.dao.QuartoDAO;
import br.cefetrj.model.Hotel;
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
    private QuartoDAO quartoDAO;
    private HotelDAO hotelDAO;

    public QuartoServlet() {
        super();
        quartoDAO = new QuartoDAO();
        hotelDAO = new HotelDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        if (acao == null) acao = "listar";

        switch (acao) {
            case "listar":
                listarQuartos(request, response);
                break;
            case "novo":
                request.setAttribute("hoteis", hotelDAO.listarTodos());
                RequestDispatcher rdNovo = request.getRequestDispatcher("quartoCadastrar.jsp");
                rdNovo.forward(request, response);
                break;
            case "editar":
                editarQuarto(request, response);
                break;
            case "excluir":
                excluirQuarto(request, response);
                break;
            default:
                listarQuartos(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        Integer numero = Integer.parseInt(request.getParameter("numero"));
        double precoNoite = Double.parseDouble(request.getParameter("precoNoite"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        TipoQuarto tipo = TipoQuarto.valueOf(request.getParameter("tipo").toUpperCase());
        Integer hotelId = Integer.parseInt(request.getParameter("hotelId"));

        Hotel hotel = hotelDAO.buscarPorId(hotelId);
        Quarto quarto;

        if (idStr == null || idStr.isEmpty()) {
            quarto = new Quarto(numero, tipo, precoNoite, status);
            quarto.setHotel(hotel);
            quartoDAO.salvar(quarto);
        } else {
            Integer id = Integer.parseInt(idStr);
            quarto = quartoDAO.buscarPorId(id);
            if (quarto != null) {
                quarto.setNumero(numero);
                quarto.setPrecoNoite(precoNoite);
                quarto.setStatus(status);
                quarto.setTipo(tipo);
                quarto.setHotel(hotel);
                quartoDAO.atualizar(quarto);
            }
        }

        response.sendRedirect(request.getContextPath() + "/quartos");
    }

    private void listarQuartos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Quarto> quartos = quartoDAO.listarTodos();
        request.setAttribute("quartos", quartos);
        RequestDispatcher rd = request.getRequestDispatcher("quartoListar.jsp");
        rd.forward(request, response);
    }

    private void editarQuarto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Quarto quarto = quartoDAO.buscarPorId(id);
        request.setAttribute("quarto", quarto);
        request.setAttribute("hoteis", hotelDAO.listarTodos());
        RequestDispatcher rd = request.getRequestDispatcher("quartoCadastrar.jsp");
        rd.forward(request, response);
    }

    private void excluirQuarto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        quartoDAO.deletar(id);
        response.sendRedirect(request.getContextPath() + "/quartos");
    }
}
