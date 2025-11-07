package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Pessoa;
import br.cefetrj.repository.PessoaRepository;

@Service
public class PessoaService {

    protected PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Pessoa save(Pessoa entity) {
        return repository.save(entity);
    }

    public Pessoa update(Pessoa entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Pessoa> findById(Long id) {
        return repository.findById(id);
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }
}
