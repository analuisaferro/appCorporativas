package br.cefetrj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.cefetrj.model.Hospede;
import br.cefetrj.service.HospedeService;
import br.cefetrj.to.input.HospedeTOInput;
import br.cefetrj.to.output.HospedeTOOutput;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/hospedes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Hóspedes", description = "Endpoints para gerenciamento de hóspedes")
@CrossOrigin(origins = "*")
public class HospedeController {

    private final HospedeService hospedeService;

    @Autowired
    public HospedeController(HospedeService hospedeService) {
        this.hospedeService = hospedeService;
    }

    @PostMapping
    @Operation(summary = "Salvar hóspede", description = "Cadastra um novo hóspede no banco de dados")
    public ResponseEntity<HospedeTOOutput> save(@RequestBody HospedeTOInput input) {
        Hospede hospede = input.build();
        Hospede created = hospedeService.save(hospede);
        return new ResponseEntity<>(new HospedeTOOutput(created), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna um hóspede pelo seu ID")
    public ResponseEntity<HospedeTOOutput> findById(@PathVariable("id") Long id) {
        return hospedeService.findById(id)
                .map(hospede -> ResponseEntity.ok(new HospedeTOOutput(hospede)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar todos", description = "Retorna todos os hóspedes cadastrados")
    public ResponseEntity<List<HospedeTOOutput>> findAll() {
        List<HospedeTOOutput> hospedes = hospedeService.findAll()
                .stream()
                .map(HospedeTOOutput::new)
                .toList();
        return ResponseEntity.ok(hospedes);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar hóspede", description = "Atualiza os dados de um hóspede existente")
    public ResponseEntity<HospedeTOOutput> update(
            @PathVariable("id") Long id,
            @RequestBody HospedeTOInput input) {

        return hospedeService.findById(id)
                .map(existing -> {
                    existing.setNome(input.getNome());
                    existing.setCpf(input.getCpf());
                    existing.setTelefone(input.getTelefone());
                    existing.setEmail(input.getEmail());
                    existing.setTelefoneEmergencia(input.getTelefoneEmergencia());
                    Hospede atualizado = hospedeService.save(existing);
                    return ResponseEntity.ok(new HospedeTOOutput(atualizado));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir hóspede", description = "Remove um hóspede do banco de dados pelo seu ID")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        hospedeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
