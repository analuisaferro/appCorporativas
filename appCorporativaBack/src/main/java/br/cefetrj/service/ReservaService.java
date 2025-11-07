package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Reserva;
import br.cefetrj.repository.ReservaRepository;

@Service
public class ReservaService {

    protected ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public Reserva save(Reserva entity) {
        return repository.save(entity);
    }

    public Reserva update(Reserva entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Reserva> findById(Long id) {
        return repository.findById(id);
    }

    public List<Reserva> findAll() {
        return repository.findAll();
    }
}
