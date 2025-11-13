document.addEventListener("DOMContentLoaded", async function () {
    let parametros = {
        idFormulario: 'formFuncionario',
        colunas: [
            { titulo: 'ID', dado: 'id', tipo: 'oculto' },
            { titulo: 'Nome', dado: 'nome', tipo: 'textoCurto', obrigatorio: true },
            { titulo: 'CPF', dado: 'cpf', tipo: 'textoCurto', obrigatorio: true },
            { titulo: 'Telefone', dado: 'telefone', tipo: 'textoCurto', obrigatorio: true },
            { titulo: 'Cargo', dado: 'cargo', tipo: 'textoCurto', obrigatorio: true },
            { titulo: 'Salário', dado: 'salario', tipo: 'numero', obrigatorio: true },
            { titulo: 'Login', dado: 'login', tipo: 'textoCurto', obrigatorio: true },
            { titulo: 'Senha', dado: 'senha', tipo: 'senha', obrigatorio: true }
        ],
        idObjeto: 'id', 
        urlCadastrar: 'http://localhost:8080/funcionario',
        urlEditar: 'http://localhost:8080/funcionario',
        urlCargaDados: 'http://localhost:8080/funcionario/id=' 
    };

    await appCorporativa.criarFormulario(parametros);
});
