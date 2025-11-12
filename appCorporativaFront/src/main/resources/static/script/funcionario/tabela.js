document.addEventListener("DOMContentLoaded", async function () {
    let parametros = {
        idTabela: 'tabelaFuncionario',
        url: 'http://localhost:8080/hotelaria/funcionarios', 
        colunas: [
            { titulo: 'ID', dado: 'id' },
            { titulo: 'Nome', dado: 'nome' },
            { titulo: 'CPF', dado: 'cpf' },
            { titulo: 'Telefone', dado: 'telefone' },
            { titulo: 'Cargo', dado: 'cargo' },
            { titulo: 'Salário', dado: 'salario' },
            { titulo: 'Login', dado: 'login' }
        ],
        exibeEditar: true,
        idEnvio: 'id',
        exibeRemover: true,
        urlRemover: 'http://localhost:8080/hotelaria/funcionarios',
        urlEditar: 'formulario.html?id='
    };

    await appCorporativa.criarTabela(parametros);
});
