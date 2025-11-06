package br.cefetrj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.cefetrj.model.Hospede;
import br.cefetrj.model.Quarto;
import br.cefetrj.model.Reserva;
import br.cefetrj.repository.HospedeRepository;
import br.cefetrj.repository.QuartoRepository;
import br.cefetrj.repository.ReservaRepository;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    // GET - listar todas as reservas
    @GetMapping
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    // GET - buscar reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        return reserva.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // POST - criar nova reserva
    @PostMapping
    public ResponseEntity<Reserva> criar(@RequestBody Reserva reserva) {
        if (reserva.getHospede() == null || reserva.getHospede().getId() == null ||
            reserva.getQuarto() == null || reserva.getQuarto().getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Hospede> hospedeOpt = hospedeRepository.findById(reserva.getHospede().getId());
        Optional<Quarto> quartoOpt = quartoRepository.findById(reserva.getQuarto().getId());

        if (hospedeOpt.isEmpty() || quartoOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        reserva.setHospede(hospedeOpt.get());
        reserva.setQuarto(quartoOpt.get());
        Reserva novaReserva = reservaRepository.save(reserva);

        // opcional: marcar quarto como ocupado
        Quarto quarto = quartoOpt.get();
        quarto.setStatus(true);
        quartoRepository.save(quarto);

        return ResponseEntity.ok(novaReserva);
    }

    // PUT - atualizar reserva
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizar(@PathVariable Long id, @RequestBody Reserva reservaAtualizada) {
        return reservaRepository.findById(id)
                .map(reserva -> {
                    if (reservaAtualizada.getHospede() != null && reservaAtualizada.getHospede().getId() != null) {
                        hospedeRepository.findById(reservaAtualizada.getHospede().getId())
                                .ifPresent(reserva::setHospede);
                    }

                    if (reservaAtualizada.getQuarto() != null && reservaAtualizada.getQuarto().getId() != null) {
                        quartoRepository.findById(reservaAtualizada.getQuarto().getId())
                                .ifPresent(reserva::setQuarto);
                    }

                    reserva.setDataCheckin(reservaAtualizada.getDataCheckin());
                    reserva.setDataCheckout(reservaAtualizada.getDataCheckout());
                    reserva.setStatus(reservaAtualizada.isStatus());

                    Reserva salva = reservaRepository.save(reserva);
                    return ResponseEntity.ok(salva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - remover reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
