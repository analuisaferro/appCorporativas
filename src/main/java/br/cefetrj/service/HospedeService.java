package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Hospede;
import br.cefetrj.repository.HospedeRepository;

@Service
public class HospedeService {

    protected HospedeRepository repository;

    public HospedeService(HospedeRepository repository) {
        this.repository = repository;
    }

    public Hospede save(Hospede entity) {
        return repository.save(entity);
    }

    public Hospede update(Hospede entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Hospede> findById(Long id) {
        return repository.findById(id);
    }

    public List<Hospede> findAll() {
        return repository.findAll();
    }
}
