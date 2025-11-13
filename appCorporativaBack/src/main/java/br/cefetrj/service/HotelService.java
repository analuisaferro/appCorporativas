package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Hotel;
import br.cefetrj.repository.HotelRepository;

@Service
public class HotelService {

    protected HotelRepository repository;

    public HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    public Hotel save(Hotel entity) {
        return repository.save(entity);
    }

    public void update(Hotel entity) {
        repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Hotel> findById(Long id) {
        return repository.findById(id);
    }

    public List<Hotel> findAll() {
        return repository.findAll();
    }
}
