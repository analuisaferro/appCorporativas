package br.cefetrj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cefetrj.model.Hospede;
import br.cefetrj.repository.HospedeRepository;

@RestController
@RequestMapping("/hospedes")
@CrossOrigin(origins = "*")
public class HospedeController {

    @Autowired
    private HospedeRepository hospedeRepository;

    @GetMapping
    public List<Hospede> listarTodos() {
        return hospedeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> buscarPorId(@PathVariable Long id) {
        Optional<Hospede> hospede = hospedeRepository.findById(id);
        return hospede.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Hospede criar(@RequestBody Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospede> atualizar(@PathVariable Long id, @RequestBody Hospede hospedeAtualizado) {
        return hospedeRepository.findById(id)
                .map(hospede -> {
                    hospede.setNome(hospedeAtualizado.getNome());
                    hospede.setCpf(hospedeAtualizado.getCpf());
                    hospede.setTelefone(hospedeAtualizado.getTelefone());
                    hospede.setEmail(hospedeAtualizado.getEmail());
                    hospede.setTelefoneEmergencia(hospedeAtualizado.getTelefoneEmergencia());
                    Hospede atualizado = hospedeRepository.save(hospede);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return hospedeRepository.findById(id)
                .map(hospede -> {
                    hospedeRepository.delete(hospede);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
