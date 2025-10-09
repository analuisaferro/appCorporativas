<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Quarto" %>
<%@ page import="br.cefetrj.model.TipoQuarto" %>
<html>
<head>
    <link rel="stylesheet" href="static/style.css">
    <title>Lista de Quartos</title>
</head>
<body>
    <h1>Quartos cadastrados</h1>

    <%
        List<Quarto> quartos = (List<Quarto>) request.getSession().getAttribute("quartos");
        if (quartos == null || quartos.isEmpty()) {
    %>
        <p>Nenhum quarto cadastrado.</p>
    <%
        } else {
    %>
        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <th>Número</th>
                <th>Tipo</th>
                <th>Preço por Noite</th>
                <th>Status</th>
            </tr>
            <%
                for (Quarto q : quartos) {
            %>
                <tr>
                    <td><%= q.getNumero() %></td>
                    <td><%= q.getTipo() %></td>
                    <td>R$ <%= q.getPrecoNoite() %></td>
                    <td>
                        <%= q.isStatus() ? "Ocupado" : "Livre" %>
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
    <a href="quartoCadastrar.jsp">Cadastrar novo quarto</a>
</body>
</html>
