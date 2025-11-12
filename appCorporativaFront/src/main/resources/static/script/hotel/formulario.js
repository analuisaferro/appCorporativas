document.addEventListener("DOMContentLoaded", async function () {
    let parametros = {
        idFormulario: 'formHotel', 
        colunas: [
            { titulo: 'ID', dado: 'id', tipo: 'oculto' },
            { titulo: 'Nome', dado: 'nome', tipo: 'textoCurto', obrigatorio: true },
            { titulo: 'Endereço', dado: 'endereco', tipo: 'textoCurto', obrigatorio: true },
            { titulo: 'Telefone', dado: 'telefone', tipo: 'textoCurto', obrigatorio: true }
        ],
        idObjeto: 'id', 
        urlCadastrar: 'http://localhost:8080/hotelaria/hotels', 
        urlEditar: 'http://localhost:8080/hotelaria/hotels',    
        urlCargaDados: 'http://localhost:8080/hotelaria/hotels/id='
    };

    await appCorporativa.criarFormulario(parametros);
});
