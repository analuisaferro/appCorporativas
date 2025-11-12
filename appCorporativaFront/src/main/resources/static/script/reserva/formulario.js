document.addEventListener("DOMContentLoaded", async function () {
    let respostaHospedes = await fetch('http://localhost:8080/hotelaria/hospedes');
    let listaHospedes = await respostaHospedes.json();

    let respostaQuartos = await fetch('http://localhost:8080/hotelaria/quartos');
    let listaQuartos = await respostaQuartos.json();

    let parametros = {
        idFormulario: 'formReserva',
        colunas: [
            { titulo: 'ID', dado: 'id', tipo: 'oculto' },
            { titulo: 'Hóspede', dado: 'hospede', tipo: 'select', obrigatorio: true, 
              opcoes: listaHospedes.map(h => ({ valor: h.id, texto: h.nome })) },
            { titulo: 'Quarto', dado: 'quarto', tipo: 'select', obrigatorio: true, 
              opcoes: listaQuartos.map(q => ({ valor: q.id, texto: `Quarto ${q.numero} - ${q.tipo}` })) },
            { titulo: 'Check-in', dado: 'dataCheckin', tipo: 'data', obrigatorio: true },
            { titulo: 'Check-out', dado: 'dataCheckout', tipo: 'data', obrigatorio: true },
            { titulo: 'Status', dado: 'status', tipo: 'checkbox', obrigatorio: false }
        ],
        idObjeto: 'id',
        urlCadastrar: 'http://localhost:8080/hotelaria/reservas',
        urlEditar: 'http://localhost:8080/hotelaria/reservas',
        urlCargaDados: 'http://localhost:8080/hotelaria/reservas/id='
    };

    await appCorporativa.criarFormulario(parametros);
});
