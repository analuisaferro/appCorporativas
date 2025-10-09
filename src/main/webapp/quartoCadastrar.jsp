<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.cefetrj.model.TipoQuarto" %>
<html>
<head>
    <link rel="stylesheet" href="static/style.css">
    <title>Cadastrar Quarto</title>
</head>
<body>
    <h1>Cadastrar novo quarto</h1>

    <form action="quartos" method="post">
        <label>Número do Quarto:</label><br>
        <input type="number" name="numero" required><br><br>

        <label>Tipo de Quarto:</label><br>
        <select name="tipo" required>
            <%
                for (TipoQuarto tipo : TipoQuarto.values()) {
            %>
                <option value="<%= tipo.name() %>"><%= tipo.name() %></option>
            <%
                }
            %>
        </select><br><br>

        <label>Preço por Noite:</label><br>
        <input type="number" name="precoNoite" step="0.01" required><br><br>

        <label>Status:</label><br>
        <select name="status" required>
            <option value="false" selected>Livre</option>
            <option value="true">Ocupado</option>
        </select><br><br>

        <input type="submit" value="Cadastrar Quarto">
    </form>

    <br>
    <a href="quartos">Ver lista de quartos</a>
</body>
</html>
