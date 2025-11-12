document.addEventListener("DOMContentLoaded", async function () {
    let parametros = {
        idTabela: 'tabelaQuarto',
        url: 'http://localhost:8080/hotelaria/quartos',
        colunas: [
            { titulo: 'ID', dado: 'id' },
            { titulo: 'Número', dado: 'numero' },
            { titulo: 'Tipo', dado: 'tipo' },
            { titulo: 'Preço por Noite', dado: 'precoNoite' },
            { titulo: 'Status', dado: 'status', formatar: (valor) => valor ? 'Ocupado' : 'Livre' },
            { titulo: 'Hotel', dado: 'hotel.nome' }
        ],
        exibeEditar: true,
        idEnvio: 'id',
        exibeRemover: true,
        urlRemover: 'http://localhost:8080/hotelaria/quartos',
        urlEditar: 'formulario.html?id='
    };

    await appCorporativa.criarTabela(parametros);
});
