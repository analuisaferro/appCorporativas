<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="static/style.css">
    <title>Cadastrar Hotel</title>
</head>
<body>
    <h1>Cadastrar novo hotel</h1>

    <form action="hoteis" method="post">
        <label>Nome:</label><br>
        <input type="text" name="nome" required><br><br>

        <label>Endereço:</label><br>
        <input type="text" name="endereco" required><br><br>

        <label>Telefone:</label><br>
        <input type="text" name="telefone" required><br><br>

        <input type="submit" value="Cadastrar Hotel">
    </form>

    <br>
    <a href="hotelListar.jsp">Ver lista de hotéis</a>
</body>
</html>
