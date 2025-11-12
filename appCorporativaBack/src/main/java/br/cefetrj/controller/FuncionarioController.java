package br.cefetrj.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import br.cefetrj.model.Funcionario;
import br.cefetrj.service.FuncionarioService;
import br.cefetrj.to.input.FuncionarioTOInput;
import br.cefetrj.to.output.FuncionarioTOOutput;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/funcionarios", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Funcionários", description = "Endpoints para gerenciamento de funcionários")
@CrossOrigin(origins = "*")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    @Operation(summary = "Salvar funcionário", description = "Cadastra um novo funcionário no banco de dados")
    public ResponseEntity<FuncionarioTOOutput> save(@RequestBody FuncionarioTOInput input) {
        Funcionario funcionario = input.build();
        Funcionario created = funcionarioService.save(funcionario);
        return new ResponseEntity<>(new FuncionarioTOOutput(created), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna um funcionário pelo seu ID")
    public ResponseEntity<FuncionarioTOOutput> findById(@PathVariable("id") Long id) {
        return funcionarioService.findById(id)
                .map(func -> ResponseEntity.ok(new FuncionarioTOOutput(func)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar todos", description = "Retorna todos os funcionários cadastrados")
    public ResponseEntity<List<FuncionarioTOOutput>> findAll() {
        List<FuncionarioTOOutput> funcionarios = funcionarioService.findAll()
                .stream()
                .map(FuncionarioTOOutput::new)
                .toList();
        return ResponseEntity.ok(funcionarios);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar funcionário", description = "Atualiza os dados de um funcionário existente")
    public ResponseEntity<FuncionarioTOOutput> update(
            @PathVariable("id") Long id,
            @RequestBody FuncionarioTOInput input) {

        return funcionarioService.findById(id)
                .map(existing -> {
                    existing.setNome(input.getNome());
                    existing.setCpf(input.getCpf());
                    existing.setTelefone(input.getTelefone());
                    existing.setCargo(input.getCargo());
                    existing.setSalario(input.getSalario());
                    existing.setLogin(input.getLogin());
                    existing.setSenha(input.getSenha());
                    Funcionario updated = funcionarioService.save(existing);
                    return ResponseEntity.ok(new FuncionarioTOOutput(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir funcionário", description = "Remove um funcionário do banco de dados pelo seu ID")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
