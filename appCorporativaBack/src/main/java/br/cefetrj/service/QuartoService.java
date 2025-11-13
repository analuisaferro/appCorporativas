package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Quarto;
import br.cefetrj.repository.QuartoRepository;

@Service
public class QuartoService {

    protected QuartoRepository repository;

    public QuartoService(QuartoRepository repository) {
        this.repository = repository;
    }

    public Quarto save(Quarto entity) {
        return repository.save(entity);
    }

    public Quarto update(Quarto entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Quarto> findById(Long id) {
        return repository.findById(id);
    }

    public List<Quarto> findAll() {
        return repository.findAll();
    }
}
