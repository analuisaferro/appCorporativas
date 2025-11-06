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

import br.cefetrj.model.Hotel;
import br.cefetrj.model.Quarto;
import br.cefetrj.repository.HotelRepository;
import br.cefetrj.repository.QuartoRepository;

@RestController
@RequestMapping("/api/quartos")
@CrossOrigin(origins = "*") // libera o acesso pro front
public class QuartoController {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HotelRepository hotelRepository;

    // GET - listar todos os quartos
    @GetMapping
    public List<Quarto> listarTodos() {
        return quartoRepository.findAll();
    }

    // GET - buscar quarto por id
    @GetMapping("/{id}")
    public ResponseEntity<Quarto> buscarPorId(@PathVariable Long id) {
        Optional<Quarto> quarto = quartoRepository.findById(id);
        return quarto.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // POST - criar quarto
    @PostMapping
    public ResponseEntity<Quarto> criar(@RequestBody Quarto quarto) {
        // garante que o hotel existe antes de salvar o quarto
        if (quarto.getHotel() == null || quarto.getHotel().getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Hotel> hotelOpt = hotelRepository.findById(quarto.getHotel().getId());
        if (hotelOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        quarto.setHotel(hotelOpt.get());
        Quarto novo = quartoRepository.save(quarto);
        return ResponseEntity.ok(novo);
    }

    // PUT - atualizar quarto
    @PutMapping("/{id}")
    public ResponseEntity<Quarto> atualizar(@PathVariable Long id, @RequestBody Quarto quartoAtualizado) {
        return quartoRepository.findById(id)
                .map(quarto -> {
                    quarto.setNumero(quartoAtualizado.getNumero());
                    quarto.setTipo(quartoAtualizado.getTipo());
                    quarto.setPrecoNoite(quartoAtualizado.getPrecoNoite());
                    quarto.setStatus(quartoAtualizado.isStatus());

                    if (quartoAtualizado.getHotel() != null && quartoAtualizado.getHotel().getId() != null) {
                        hotelRepository.findById(quartoAtualizado.getHotel().getId())
                                .ifPresent(quarto::setHotel);
                    }

                    Quarto salvo = quartoRepository.save(quarto);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - remover quarto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (quartoRepository.existsById(id)) {
            quartoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}