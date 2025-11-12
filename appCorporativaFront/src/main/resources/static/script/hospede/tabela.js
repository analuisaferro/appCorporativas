document.addEventListener("DOMContentLoaded", async function () {
    let parametros = {
        idTabela: 'tabelaHospede', 
        url: 'http://localhost:8080/hotelaria/hospedes',
        colunas: [
            { titulo: 'ID', dado: 'id' },
            { titulo: 'Nome', dado: 'nome' },
            { titulo: 'CPF', dado: 'cpf' },
            { titulo: 'Telefone', dado: 'telefone' },
            { titulo: 'Email', dado: 'email' },
            { titulo: 'Telefone Emergência', dado: 'telefoneEmergencia' }
        ],
        exibeEditar: true,
        idEnvio: 'id',
        exibeRemover: true,
        urlRemover: 'http://localhost:8080/hotelaria/hospedes',
        urlEditar: 'formulario.html?id='
    };

    await appCorporativa.criarTabela(parametros);
});
