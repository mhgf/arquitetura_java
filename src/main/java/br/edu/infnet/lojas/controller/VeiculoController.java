package br.edu.infnet.lojas.controller;

import br.edu.infnet.lojas.Constantes;
import br.edu.infnet.lojas.model.domain.Veiculo;
import br.edu.infnet.lojas.model.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private final VeiculoService veiculoService;


    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping(value = "lista")
    public ResponseEntity<Collection<Veiculo>> listaVeiculo() {
        var lista = veiculoService.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/filtrarPorPreco")
    public ResponseEntity<List<Veiculo>> filtrarPorPreco(@RequestParam float min, @RequestParam float max) {
        if (min < 0 || max < 0 || min > max) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        var veiculos = this.veiculoService.obterListaPorPreco(min, max);

        if (veiculos.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(veiculos);

        return ResponseEntity.ok(veiculos);
    }

    @PostMapping(value = "/incluir")
    public ResponseEntity<String> incluir(@Valid @RequestBody Veiculo veiculo) {

        veiculoService.incluir(veiculo);

        return ResponseEntity.ok(Constantes.MSG_INCLUSAO_SUCESSO);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {

        veiculoService.excluir(id);

        return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Veiculo> obterPorId(@PathVariable Integer id) {

        var veiculo = veiculoService.obterPorId(id);
        return ResponseEntity.ok(veiculo);
    }

    @PatchMapping(value = "/alterar")
    public ResponseEntity<Veiculo> alterar(@RequestParam Integer id, @RequestParam float preco) {
        var veiculoAlterado = veiculoService.alterar(id, preco);

        return ResponseEntity.ok(veiculoAlterado);
    }
}
