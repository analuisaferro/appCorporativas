<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="static/style.css">
    <title>Cadastrar Reserva</title>
</head>
<body>
    <h1>Cadastrar nova reserva</h1>

    <form action="reservas" method="post">
        <label>ID da Reserva:</label><br>
        <input type="number" name="id" required><br><br>

        <h3>Dados do Hóspede</h3>
        <label>Nome:</label><br>
        <input type="text" name="nome" required><br><br>

        <label>CPF:</label><br>
        <input type="text" name="cpf" required><br><br>

        <label>Telefone:</label><br>
        <input type="text" name="telefone"><br><br>

        <label>Email:</label><br>
        <input type="email" name="email"><br><br>

        <label>Endereço:</label><br>
        <input type="text" name="endereco"><br><br>

        <label>Status da Reserva:</label><br>
        <select name="status">
            <option value="false" selected>Pendente</option>
            <option value="true">Confirmada</option>
        </select><br><br>

        <input type="submit" value="Cadastrar Reserva">
    </form>

    <br>
    <a href="reservaListar.jsp">Ver todas reservas</a>
</body>
</html>
