package br.cefetrj.controller;

import java.io.IOException;
import java.util.List;

import br.cefetrj.dao.HotelDAO;
import br.cefetrj.model.Hotel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hoteis")
public class HotelServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HotelDAO hotelDAO;

    public HotelServlet() {
        super();
        hotelDAO = new HotelDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        if (acao == null) acao = "listar";

        switch (acao) {
            case "listar":
                listarHoteis(request, response);
                break;
            case "novo":
                request.getRequestDispatcher("hotelCadastrar.jsp").forward(request, response);
                break;
            case "editar":
                editarHotel(request, response);
                break;
            case "excluir":
                excluirHotel(request, response);
                break;
            default:
                listarHoteis(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");

        Hotel hotel;

        if (idStr == null || idStr.isEmpty()) {
            hotel = new Hotel(nome, endereco, telefone);
            hotelDAO.salvar(hotel);
        } else {
            Integer id = Integer.parseInt(idStr);
            hotel = hotelDAO.buscarPorId(id);
            if (hotel != null) {
                hotel.setNome(nome);
                hotel.setEndereco(endereco);
                hotel.setTelefone(telefone);
                hotelDAO.atualizar(hotel);
            }
        }

        response.sendRedirect(request.getContextPath() + "/hoteis");
    }

    private void listarHoteis(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Hotel> hoteis = hotelDAO.listarTodos();
        request.setAttribute("hoteis", hoteis);
        RequestDispatcher rd = request.getRequestDispatcher("hotelListar.jsp");
        rd.forward(request, response);
    }

    private void editarHotel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Hotel hotel = hotelDAO.buscarPorId(id);
        request.setAttribute("hotel", hotel);
        RequestDispatcher rd = request.getRequestDispatcher("hotelCadastrar.jsp");
        rd.forward(request, response);
    }

    private void excluirHotel(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        hotelDAO.deletar(id);
        response.sendRedirect(request.getContextPath() + "/hoteis");
    }
}
