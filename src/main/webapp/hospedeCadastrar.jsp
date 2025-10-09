<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="static/style.css">
    <title>Cadastrar Hóspede</title>
</head>
<body>
    <h1>Cadastrar novo hóspede</h1>

    <form action="hospedes" method="post">
        <label>Nome:</label><br>
        <input type="text" name="nome" required><br><br>

        <label>CPF:</label><br>
        <input type="text" name="cpf" required><br><br>

        <label>Telefone:</label><br>
        <input type="text" name="telefone" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email"><br><br>

        <label>Telefone de Emergência:</label><br>
        <input type="text" name="telefoneEmergencia" required><br><br>

        <input type="submit" value="Cadastrar Hóspede">
    </form>

    <br>
    <a href="hospedes">Ver lista de hóspedes</a>
</body>
</html>
