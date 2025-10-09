package br.cefetrj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public HospedeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Hospede> hospedes = new ArrayList<>();
        
        hospedes.add(new Hospede("Ana Ferro", "123.456.789-00", "11999990000", "ana@exemplo.com", "11999990001"));
        hospedes.add(new Hospede("Bruno Silva", "987.654.321-00", "11988880000", "bruno@exemplo.com", "11988880001"));
        hospedes.add(new Hospede("Carla Mendes", "111.222.333-44", "11977770000", "carla@exemplo.com", "11977770001"));
        hospedes.add(new Hospede("Daniel Costa", "555.666.777-88", "11966660000", "daniel@exemplo.com", "11966660001"));
        hospedes.add(new Hospede("Eduardo Lima", "999.888.777-66", "11955550000", "eduardo@exemplo.com", "11955550001"));

        request.getSession().setAttribute("hospedes", hospedes);
        RequestDispatcher rd = request.getRequestDispatcher("hospedeListar.jsp");
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

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
