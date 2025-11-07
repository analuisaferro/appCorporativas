package br.cefetrj.dao;

import br.cefetrj.model.Funcionario;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
    public FuncionarioDAO() {
        super(Funcionario.class);
    }
}
