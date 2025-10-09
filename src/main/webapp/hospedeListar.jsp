<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Hospede" %>
<html>
<head>
    <link rel="stylesheet" href="static/style.css">
    <title>Lista de Hóspedes</title>
</head>
<body>
    <h1>Hóspedes cadastrados</h1>

    <%
        List<Hospede> hospedes = (List<Hospede>) request.getSession().getAttribute("hospedes");
        if (hospedes == null || hospedes.isEmpty()) {
    %>
        <p>Nenhum hóspede cadastrado.</p>
    <%
        } else {
    %>
        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <th>Nome</th>
                <th>CPF</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Telefone de Emergência</th>
            </tr>
            <%
                for (Hospede h : hospedes) {
            %>
                <tr>
                    <td><%= h.getNome() %></td>
                    <td><%= h.getCpf() %></td>
                    <td><%= h.getTelefone() %></td>
                    <td><%= h.getEmail() %></td>
                    <td><%= h.getTelefoneEmergencia() %></td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>

    <br>
    <a href="hospedeCadastrar.jsp">Cadastrar novo hóspede</a>
</body>
</html>
