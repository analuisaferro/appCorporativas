document.addEventListener("DOMContentLoaded", async function () {
    let parametros = {
        idTabela: 'tabelaHotel', 
        url: 'http://localhost:8080/hoteis',
        colunas: [
            { titulo: 'ID', dado: 'id' },
            { titulo: 'Nome', dado: 'nome' },
            { titulo: 'Endereço', dado: 'endereco' },
            { titulo: 'Telefone', dado: 'telefone' }
        ],
        exibeEditar: true,
        idEnvio: 'id',
        exibeRemover: true,
        urlRemover: 'http://localhost:8080/hoteis',
        urlEditar: 'formulario.html?id='
    };

    await appCorporativa.criarTabela(parametros);
});
