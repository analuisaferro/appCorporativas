document.addEventListener("DOMContentLoaded", async function () {
    let parametros = {
        idFormulario: 'formHospede', 
        colunas: [
            { titulo: 'ID', dado: 'id', tipo: 'oculto' },
            { titulo: 'Nome', dado: 'nome', tipo: 'textoCurto', obrigatorio: true },
            { titulo: 'CPF', dado: 'cpf', tipo: 'textoCurto', obrigatorio: true },
            { titulo: 'Telefone', dado: 'telefone', tipo: 'textoCurto', obrigatorio: true },
            { titulo: 'Email', dado: 'email', tipo: 'textoCurto', obrigatorio: true },
            { titulo: 'Telefone Emergência', dado: 'telefoneEmergencia', tipo: 'textoCurto', obrigatorio: false }
        ],
        idObjeto: 'id', 
        urlCadastrar: 'http://localhost:8080/hotelaria/hospedes', 
        urlEditar: 'http://localhost:8080/hotelaria/hospedes',    
        urlCargaDados: 'http://localhost:8080/hotelaria/hospedes/id=' 
    };

    await appCorporativa.criarFormulario(parametros);
});
