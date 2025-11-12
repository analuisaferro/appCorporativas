document.addEventListener("DOMContentLoaded", async function () {

    let resposta = await fetch('http://localhost:8080/hotelaria/hotels');
    let listaHoteis = await resposta.json();

    let parametros = {
        idFormulario: 'formQuarto',
        colunas: [
            { titulo: 'ID', dado: 'id', tipo: 'oculto' },
            { titulo: 'Número', dado: 'numero', tipo: 'numero', obrigatorio: true },
            { titulo: 'Tipo', dado: 'tipo', tipo: 'select', obrigatorio: true, opcoes: ['SOLTEIRO','CASAL','LUXO','SUITE_PRESIDENCIAL'] },
            { titulo: 'Preço por Noite', dado: 'precoNoite', tipo: 'numero', obrigatorio: true },
            { titulo: 'Status', dado: 'status', tipo: 'checkbox', obrigatorio: false },
            { titulo: 'Hotel', dado: 'hotel', tipo: 'select', obrigatorio: true, 
                opcoes: listaHoteis.map(hotel => ({ valor: hotel.id, texto: hotel.nome }))
            }
        ],
        idObjeto: 'id',
        urlCadastrar: 'http://localhost:8080/hotelaria/quartos',
        urlEditar: 'http://localhost:8080/hotelaria/quartos',
        urlCargaDados: 'http://localhost:8080/hotelaria/quartos/id='
    };

    await appCorporativa.criarFormulario(parametros);
});
