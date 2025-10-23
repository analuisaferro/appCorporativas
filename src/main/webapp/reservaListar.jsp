<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Reserva" %>
<%@ page import="br.cefetrj.model.Hospede" %>
<html>
<head>
    <link rel="stylesheet" href="static/style.css">
    <title>Lista de Reservas</title>
</head>
<body>
    <h1>Reservas</h1>

    <%
        List<Reserva> reservas = (List<Reserva>) request.getAttribute("reservas");
        if (reservas == null || reservas.isEmpty()) {
    %>
        <p>Nenhuma reserva cadastrada.</p>
    <%
        } else {
    %>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Hóspede</th>
                    <th>CPF</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>Status</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
            <%
                for (Reserva r : reservas) {
                    Hospede h = r.getHospede();
            %>
                <tr>
                    <td><%= r.getId() %></td>
                    <td><%= h.getNome() %></td>
                    <td><%= h.getCpf() %></td>
                    <td><%= h.getTelefone() %></td>
                    <td><%= h.getEmail() %></td>
                    <td><%= r.isStatus() ? "Confirmada" : "Pendente" %></td>
                    <td>
                        <a href="reservas?acao=editar&id=<%= r.getId() %>">Editar</a> |
                        <a href="reservas?acao=excluir&id=<%= r.getId() %>">Excluir</a>
                    </td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    <%
        }
    %>
    <br>
    <a href="reservas?acao=novo">Cadastrar nova reserva</a>
</body>
</html>
