package br.cefetrj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.cefetrj.model.Hotel;
import br.cefetrj.repository.HotelRepository;

@RestController
@RequestMapping("/api/hoteis")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping
    public List<Hotel> listarTodos() {
        return hotelRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> buscarPorId(@PathVariable Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Hotel> criar(@RequestBody Hotel hotel) {
        Hotel novoHotel = hotelRepository.save(hotel);
        return ResponseEntity.ok(novoHotel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> atualizar(@PathVariable Long id, @RequestBody Hotel hotelAtualizado) {
        return hotelRepository.findById(id)
                .map(hotel -> {
                    hotel.setNome(hotelAtualizado.getNome());
                    hotel.setEndereco(hotelAtualizado.getEndereco());
                    hotel.setTelefone(hotelAtualizado.getTelefone());
                    Hotel salvo = hotelRepository.save(hotel);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
