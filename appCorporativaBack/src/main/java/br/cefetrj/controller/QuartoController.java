package br.cefetrj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import br.cefetrj.model.Quarto;
import br.cefetrj.service.HotelService;
import br.cefetrj.service.QuartoService;
import br.cefetrj.to.input.QuartoTOInput;
import br.cefetrj.to.output.QuartoTOOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/quartos", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
@Tag(name = "Quartos", description = "Endpoints para gerenciamento de quartos")
public class QuartoController {

    private final QuartoService quartoService;
    private final HotelService hotelService;

    @Autowired
    public QuartoController(QuartoService quartoService, HotelService hotelService) {
        this.quartoService = quartoService;
        this.hotelService = hotelService;
    }

    @PostMapping
    @Operation(summary = "Cadastrar quarto", description = "Salva um novo quarto vinculado a um hotel existente")
    public ResponseEntity<?> save(@RequestBody QuartoTOInput input) {
        if (input.getIdHotel() == null) {
            return ResponseEntity.badRequest().body("O quarto deve estar vinculado a um hotel existente.");
        }

        var hotelOpt = hotelService.findById(input.getIdHotel());
        if (hotelOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Hotel não encontrado.");
        }

        Quarto quarto = input.build();
        quarto.setHotel(hotelOpt.get());
        Quarto created = quartoService.save(quarto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new QuartoTOOutput(created));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna um quarto pelo seu ID")
    public ResponseEntity<QuartoTOOutput> findById(@PathVariable("id") Long id) {
        return quartoService.findById(id)
                .map(quarto -> ResponseEntity.ok(new QuartoTOOutput(quarto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar todos", description = "Retorna todos os quartos cadastrados")
    public ResponseEntity<List<QuartoTOOutput>> findAll() {
        List<QuartoTOOutput> quartos = quartoService.findAll()
                .stream()
                .map(QuartoTOOutput::new)
                .toList();
        return ResponseEntity.ok(quartos);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar quarto", description = "Atualiza os dados de um quarto existente")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody QuartoTOInput input) {
        return quartoService.findById(id)
                .map(existing -> {
                    existing.setNumero(input.getNumero());
                    if (input.getTipo() != null) {
                        try {
                            existing.setTipo(br.cefetrj.model.TipoQuarto.valueOf(input.getTipo().toUpperCase()));
                        } catch (IllegalArgumentException e) {
                            return ResponseEntity.badRequest().body("Tipo de quarto inválido: " + input.getTipo());
                        }
                    }
                    existing.setPrecoNoite(input.getPrecoNoite());
                    existing.setStatus(input.isStatus());

                    if (input.getIdHotel() != null) {
                        hotelService.findById(input.getIdHotel()).ifPresent(existing::setHotel);
                    }

                    Quarto atualizado = quartoService.save(existing);
                    return ResponseEntity.ok(new QuartoTOOutput(atualizado));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir quarto", description = "Remove um quarto do banco de dados pelo seu ID")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        quartoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
