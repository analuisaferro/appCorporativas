<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="static/style.css">
    <title>Cadastrar Funcionário</title>
</head>
<body>
    <h1>Cadastrar novo funcionário</h1>

    <form action="funcionarios" method="post">
        <h3>Dados Pessoais</h3>
        <label>Nome:</label><br>
        <input type="text" name="nome" required><br><br>

        <label>CPF:</label><br>
        <input type="text" name="cpf" required><br><br>

        <label>Telefone:</label><br>
        <input type="text" name="telefone"><br><br>

        <label>Email:</label><br>
        <input type="email" name="email"><br><br>

        <h3>Dados Profissionais</h3>
        <label>Cargo:</label><br>
        <input type="text" name="cargo" required><br><br>

        <label>Salário:</label><br>
        <input type="number" name="salario" step="0.01" required><br><br>

        <h3>Acesso</h3>
        <label>Login:</label><br>
        <input type="text" name="login" required><br><br>

        <label>Senha:</label><br>
        <input type="password" name="senha" required><br><br>

        <input type="submit" value="Cadastrar Funcionário">
    </form>

    <br>
    <a href="funcionariosListar.jsp">Ver lista de funcionários</a>
</body>
</html>