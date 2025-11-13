package br.cefetrj.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.cefetrj.model.Hospede;
import br.cefetrj.model.Quarto;
import br.cefetrj.model.Reserva;
import br.cefetrj.service.ReservaService;
import br.cefetrj.service.HospedeService;
import br.cefetrj.service.QuartoService;
import br.cefetrj.to.input.ReservaTOInput;
import br.cefetrj.to.output.ReservaTOOutput;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/reservas", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Reservas", description = "Gerenciamento de reservas de hotel")
@CrossOrigin(origins = "*")
public class ReservaController {

    private final ReservaService reservaService;
    private final HospedeService hospedeService;
    private final QuartoService quartoService;

    @Autowired
    public ReservaController(ReservaService reservaService, HospedeService hospedeService, QuartoService quartoService) {
        this.reservaService = reservaService;
        this.hospedeService = hospedeService;
        this.quartoService = quartoService;
    }

    @PostMapping
    @Operation(summary = "Criar reserva", description = "Cria uma nova reserva vinculada a um hóspede e quarto existentes")
    public ResponseEntity<?> save(@RequestBody ReservaTOInput input) {
        if (input.getHospedeId() == null || input.getQuartoId() == null) {
            return ResponseEntity.badRequest().body("IDs de hóspede e quarto são obrigatórios.");
        }

        var hospedeOpt = hospedeService.findById(input.getHospedeId());
        var quartoOpt = quartoService.findById(input.getQuartoId());

        if (hospedeOpt.isEmpty() || quartoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Hóspede ou quarto não encontrados.");
        }

        Hospede hospede = hospedeOpt.get();
        Quarto quarto = quartoOpt.get();

        if (quarto.isStatus()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O quarto já está ocupado.");
        }

        Reserva reserva = input.build();
        Reserva novaReserva = reservaService.save(reserva);

        quarto.setStatus(true);
        quartoService.save(quarto);

        return new ResponseEntity<>(new ReservaTOOutput(novaReserva), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna uma reserva pelo seu ID")
    public ResponseEntity<ReservaTOOutput> findById(@PathVariable("id") Long id) {
        return reservaService.findById(id)
                .map(reserva -> ResponseEntity.ok(new ReservaTOOutput(reserva)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar todas", description = "Retorna todas as reservas cadastradas")
    public ResponseEntity<List<ReservaTOOutput>> findAll() {
        List<ReservaTOOutput> reservas = reservaService.findAll()
                .stream()
                .map(ReservaTOOutput::new)
                .toList();
        return ResponseEntity.ok(reservas);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar reserva", description = "Atualiza os dados de uma reserva existente")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ReservaTOInput input) {
        return reservaService.findById(id)
                .map(existing -> {
                    if (input.getHospedeId() != null) {
                        hospedeService.findById(input.getHospedeId()).ifPresent(existing::setHospede);
                    }
                    if (input.getQuartoId() != null) {
                        quartoService.findById(input.getQuartoId()).ifPresent(existing::setQuarto);
                    }

                    existing.setDataCheckin(input.getDataCheckin());
                    existing.setDataCheckout(input.getDataCheckout());
                    existing.setStatus(input.isStatus());

                    Reserva atualizado = reservaService.save(existing);
                    return ResponseEntity.ok(new ReservaTOOutput(atualizado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir reserva", description = "Remove uma reserva pelo seu ID")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}