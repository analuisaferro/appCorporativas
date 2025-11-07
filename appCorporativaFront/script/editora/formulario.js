document.addEventListener("DOMContentLoaded", async function() {
    let parametros = {
        idFormulario: 'formEditora',
        campos: [
            { titulo: 'ID', dado: 'id', tipo: 'oculto', obrigatorio: false },
            { titulo: 'Nome', dado: 'nome', tipo: 'textoCurto', obrigatorio: true },
        ],
        urlCadastrar: 'http://localhost:8080/sisHotelaria/editoras',
        urlEditar: 'http://localhost:8080/sisHotelaria/editoras',
        urlCargaDados: 'http://localhost:8080/sisHotelaria/editoras/id=',
        token: localStorage.getItem("tokenAppCorporativa"),
    };
    appCorporativa.criarFormulario(
        parametros
    );

});
