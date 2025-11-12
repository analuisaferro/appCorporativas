package br.cefetrj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.cefetrj.model.Hotel;
import br.cefetrj.service.HotelService;
import br.cefetrj.to.input.HotelTOInput;
import br.cefetrj.to.output.HotelTOOutput;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/hoteis", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Hoteis", description = "Endpoints para gerenciamento de hotéis")
@CrossOrigin(origins = "*")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    @Operation(summary = "Cadastrar hotel", description = "Salva um novo hotel no banco de dados")
    public ResponseEntity<HotelTOOutput> save(@RequestBody HotelTOInput input) {
        Hotel hotel = input.build();
        Hotel created = hotelService.save(hotel);
        return new ResponseEntity<>(new HotelTOOutput(created), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna um hotel pelo seu ID")
    public ResponseEntity<HotelTOOutput> findById(@PathVariable("id") Long id) {
        return hotelService.findById(id)
                .map(hotel -> ResponseEntity.ok(new HotelTOOutput(hotel)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar todos", description = "Retorna todos os hotéis cadastrados")
    public ResponseEntity<List<HotelTOOutput>> findAll() {
        List<HotelTOOutput> hoteis = hotelService.findAll()
                .stream()
                .map(HotelTOOutput::new)
                .toList();
        return ResponseEntity.ok(hoteis);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar hotel", description = "Atualiza as informações de um hotel existente")
    public ResponseEntity<HotelTOOutput> update(
            @PathVariable("id") Long id,
            @RequestBody HotelTOInput input) {

        return hotelService.findById(id)
                .map(existing -> {
                    existing.setNome(input.getNome());
                    existing.setEndereco(input.getEndereco());
                    existing.setTelefone(input.getTelefone());
                    Hotel atualizado = hotelService.save(existing);
                    return ResponseEntity.ok(new HotelTOOutput(atualizado));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir hotel", description = "Remove um hotel do banco de dados pelo seu ID")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        hotelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
