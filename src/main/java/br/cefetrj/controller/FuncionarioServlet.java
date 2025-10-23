package br.cefetrj.controller;

import java.io.IOException;
import java.util.List;

import br.cefetrj.dao.FuncionarioDAO;
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
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioServlet() {
        super();
        funcionarioDAO = new FuncionarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        if (acao == null) acao = "listar";

        switch (acao) {
            case "listar":
                listarFuncionarios(request, response);
                break;
            case "novo":
                request.getRequestDispatcher("funcionarioCadastrar.jsp").forward(request, response);
                break;
            case "editar":
                editarFuncionario(request, response);
                break;
            case "excluir":
                excluirFuncionario(request, response);
                break;
            default:
                listarFuncionarios(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String cargo = request.getParameter("cargo");
        double salario = Double.parseDouble(request.getParameter("salario"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Funcionario funcionario;

        if (idStr == null || idStr.isEmpty()) {
            funcionario = new Funcionario(nome, cpf, telefone, cargo, salario, login, senha);
            funcionarioDAO.salvar(funcionario);
        } else {
            int id = Integer.parseInt(idStr);
            funcionario = funcionarioDAO.buscarPorId(id);
            if (funcionario != null) {
                funcionario.setNome(nome);
                funcionario.setCpf(cpf);
                funcionario.setTelefone(telefone);
                funcionario.setCargo(cargo);
                funcionario.setSalario(salario);
                funcionario.setLogin(login);
                funcionario.setSenha(senha);
                funcionarioDAO.atualizar(funcionario);
            }
        }

        response.sendRedirect(request.getContextPath() + "/funcionarios");
    }

    private void listarFuncionarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Funcionario> funcionarios = funcionarioDAO.listarTodos();
        request.setAttribute("funcionarios", funcionarios);
        RequestDispatcher rd = request.getRequestDispatcher("funcionarioListar.jsp");
        rd.forward(request, response);
    }

    private void editarFuncionario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Funcionario funcionario = funcionarioDAO.buscarPorId(id);
        request.setAttribute("funcionario", funcionario);
        RequestDispatcher rd = request.getRequestDispatcher("funcionarioCadastrar.jsp");
        rd.forward(request, response);
    }

    private void excluirFuncionario(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        funcionarioDAO.deletar(id);
        response.sendRedirect(request.getContextPath() + "/funcionarios");
    }
}
