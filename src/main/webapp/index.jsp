<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Painel de Controle - Hotelaria</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f6f7fb;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #6c63ff;
            color: white;
            padding: 20px;
            text-align: center;
            font-size: 1.8em;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        main {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            padding: 40px 20px;
            gap: 20px;
        }
        .card {
            background-color: #fff;
            width: 220px;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
            transition: transform 0.2s, box-shadow 0.2s;
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        }
        .card a {
            text-decoration: none;
            color: #333;
            font-weight: 600;
            display: block;
            margin: 10px 0;
        }
        .card a:hover {
            color: #6c63ff;
        }
        footer {
            text-align: center;
            padding: 15px;
            background-color: #f0f0f0;
            margin-top: 40px;
            color: #555;
        }
    </style>
</head>
<body>
    <header>Hotelaria - Painel de Controle</header>
    <main>
        <div class="card">
            <h3>Funcionários</h3>
            <a href="funcionarioCadastrar.jsp">Cadastrar</a>
            <a href="funcionarios">Listar</a>
        </div>
        <div class="card">
            <h3>Hóspedes</h3>
            <a href="hospedeCadastrar.jsp">Cadastrar</a>
            <a href="hospedes">Listar</a>
        </div>
        <div class="card">
            <h3>Hotéis</h3>
            <a href="hotelCadastrar.jsp">Cadastrar</a>
            <a href="hoteis">Listar</a>
        </div>
        <div class="card">
            <h3>Quartos</h3>
            <a href="quartoCadastrar.jsp">Cadastrar</a>
            <a href="quartos">Listar</a>
        </div>
        <div class="card">
            <h3>Reservas</h3>
            <a href="reservaCadastrar.jsp">Cadastrar</a>
            <a href="reservas">Listar</a>
        </div>
    </main>
    <footer>
        &copy; 2025 Hotelaria - Todos os direitos reservados
    </footer>
</body>
</html>
