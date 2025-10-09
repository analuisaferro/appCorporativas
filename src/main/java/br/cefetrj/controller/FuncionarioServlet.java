package br.cefetrj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.model.Funcionario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/funcionarios")
public class FuncionarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public FuncionarioServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Hugo Marcio", "123.456.789-00", "11999990000", "ana@exemplo.com", "Gerente", 8500.00, "anaferro", "senha123"));
        funcionarios.add(new Funcionario("Bruno Silva", "987.654.321-00", "11988880000", "bruno@exemplo.com", "Recepcionista", 3000.00, "brunos", "senha456"));
        funcionarios.add(new Funcionario("Carla Mendes", "111.222.333-44", "11977770000", "carla@exemplo.com", "Cozinheira", 2800.00, "carlam", "senha789"));
        funcionarios.add(new Funcionario("Daniel Costa", "555.666.777-88", "11966660000", "daniel@exemplo.com", "Camareiro", 2500.00, "danielc", "senha101"));
        funcionarios.add(new Funcionario("Eduardo Lima", "999.888.777-66", "11955550000", "eduardo@exemplo.com", "Supervisor", 5000.00, "edulima", "senha202"));

        request.getSession().setAttribute("funcionarios", funcionarios);

        RequestDispatcher rd = request.getRequestDispatcher("funcionarioListar.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");
        Double salario = Double.parseDouble(request.getParameter("salario"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Funcionario funcionario = new Funcionario(nome, cpf, telefone, email, cargo, salario, login, senha);

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
