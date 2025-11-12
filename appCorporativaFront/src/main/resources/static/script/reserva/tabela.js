document.addEventListener("DOMContentLoaded", async function () {
    let parametros = {
        idTabela: 'tabelaReserva',
        url: 'http://localhost:8080/hotelaria/reservas',
        colunas: [
            { titulo: 'ID', dado: 'id' },
            { titulo: 'Hóspede', dado: 'hospede.nome' },
            { titulo: 'Quarto', dado: 'quarto.numero' },
            { titulo: 'Check-in', dado: 'dataCheckin' },
            { titulo: 'Check-out', dado: 'dataCheckout' },
            { titulo: 'Status', dado: 'status', formatar: (valor) => valor ? 'Confirmada' : 'Pendente' }
        ],
        exibeEditar: true,
        idEnvio: 'id',
        exibeRemover: true,
        urlRemover: 'http://localhost:8080/hotelaria/reservas',
        urlEditar: 'formulario.html?id='
    };

    await appCorporativa.criarTabela(parametros);
});
