<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Funcionario" %>
<html>
<head>
    <link rel="stylesheet" href="static/style.css">
    <title>Lista de Funcionários</title>
</head>
<body>
    <h1>Funcionários Cadastrados</h1>

    <%
        List<Funcionario> funcionarios = (List<Funcionario>) request.getAttribute("funcionarios");

        if (funcionarios == null || funcionarios.isEmpty()) {
    %>
        <p>Nenhum funcionário cadastrado.</p>
    <%
        } else {
    %>
        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <th>Nome</th>
                <th>CPF</th>
                <th>Telefone</th>
                <th>Cargo</th>
                <th>Salário</th>
                <th>Login</th>
                <th>Ações</th>
            </tr>
            <%
                for (Funcionario f : funcionarios) {
            %>
                <tr>
                    <td><%= f.getNome() %></td>
                    <td><%= f.getCpf() %></td>
                    <td><%= f.getTelefone() %></td>
                    <td><%= f.getCargo() %></td>
                    <td>R$ <%= f.getSalario() %></td>
                    <td><%= f.getLogin() %></td>
                    <td>
                        <a href="funcionarios?acao=editar&id=<%= f.getId() %>">Editar</a> |
                        <a href="funcionarios?acao=excluir&id=<%= f.getId() %>">Excluir</a>
                    </td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>

    <br>
    <a href="funcionarios?acao=novo">Cadastrar novo funcionário</a>
</body>
</html>
