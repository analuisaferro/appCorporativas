package br.cefetrj.controller;

import java.io.IOException;
import java.util.List;

import br.cefetrj.dao.HospedeDAO;
import br.cefetrj.model.Hospede;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hospedes")
public class HospedeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HospedeDAO hospedeDAO;

    public HospedeServlet() {
        super();
        hospedeDAO = new HospedeDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        if (acao == null) acao = "listar";

        switch (acao) {
            case "listar":
                listarHospedes(request, response);
                break;
            case "novo":
                request.getRequestDispatcher("hospedeCadastrar.jsp").forward(request, response);
                break;
            case "editar":
                editarHospede(request, response);
                break;
            case "excluir":
                excluirHospede(request, response);
                break;
            default:
                listarHospedes(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String telefoneEmergencia = request.getParameter("telefoneEmergencia");

        Hospede hospede;

        if (idStr == null || idStr.isEmpty()) {
            hospede = new Hospede(nome, cpf, telefone, email, telefoneEmergencia);
            hospedeDAO.salvar(hospede);
        } else {
            int id = Integer.parseInt(idStr);
            hospede = hospedeDAO.buscarPorId(id);
            if (hospede != null) {
                hospede.setNome(nome);
                hospede.setCpf(cpf);
                hospede.setTelefone(telefone);
                hospede.setEmail(email);
                hospede.setTelefoneEmergencia(telefoneEmergencia);
                hospedeDAO.atualizar(hospede);
            }
        }

        response.sendRedirect(request.getContextPath() + "/hospedes");
    }

    private void listarHospedes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Hospede> hospedes = hospedeDAO.listarTodos();
        request.setAttribute("hospedes", hospedes);
        RequestDispatcher rd = request.getRequestDispatcher("hospedeListar.jsp");
        rd.forward(request, response);
    }

    private void editarHospede(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Hospede hospede = hospedeDAO.buscarPorId(id);
        request.setAttribute("hospede", hospede);
        RequestDispatcher rd = request.getRequestDispatcher("hospedeCadastrar.jsp");
        rd.forward(request, response);
    }

    private void excluirHospede(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        hospedeDAO.deletar(id);
        response.sendRedirect(request.getContextPath() + "/hospedes");
    }
}
