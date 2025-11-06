package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Funcionario;
import br.cefetrj.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    protected FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario save(Funcionario entity) {
        return repository.save(entity);
    }

    public Funcionario update(Funcionario entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Funcionario> findById(Long id) {
        return repository.findById(id);
    }

    public List<Funcionario> findAll() {
        return repository.findAll();
    }
}
