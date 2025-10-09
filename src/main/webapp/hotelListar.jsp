<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Hotel" %>
<html>
<head>
    <link rel="stylesheet" href="static/style.css">
    <title>Lista de Hotéis</title>
</head>
<body>
    <h1>Hotéis cadastrados</h1>

    <%
        List<Hotel> hoteis = (List<Hotel>) request.getSession().getAttribute("hoteis");
        if (hoteis == null || hoteis.isEmpty()) {
    %>
        <p>Nenhum hotel cadastrado.</p>
    <%
        } else {
    %>
        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <th>Nome</th>
                <th>Endereço</th>
                <th>Telefone</th>
            </tr>
            <%
                for (Hotel h : hoteis) {
            %>
                <tr>
                    <td><%= h.getNome() %></td>
                    <td><%= h.getEndereco() %></td>
                    <td><%= h.getTelefone() %></td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>

    <br>
    <a href="hotelCadastrar.jsp">Cadastrar novo hotel</a>
</body>
</html>
