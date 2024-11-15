package br.edu.infnet.lojas.controller;

import br.edu.infnet.lojas.Constantes;
import br.edu.infnet.lojas.model.domain.Loja;
import br.edu.infnet.lojas.model.service.LojaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/lojas")
public class LojaController {
    private final LojaService lojaService;


    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @Operation(summary = "Recupera todos as lojas.")
    @GetMapping
    public ResponseEntity<Collection<Loja>> listar() {
        return ResponseEntity.ok(lojaService.listar());
    }

    @PostMapping(value = "/incluir")
    public ResponseEntity<String> incluir(@Valid @RequestBody Loja loja) {
        lojaService.incluir(loja);
        return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        if (lojaService.excluir(id))
            return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_LOJA_NOT_FOUND);
    }


    @GetMapping(value = "/buscar/{nome}")
    public ResponseEntity<Collection<Loja>> obterPorNome(@PathVariable String nome) {
        var lojas = lojaService.obterPorNome(nome);
        if (lojas.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(lojas);

        return ResponseEntity.ok(lojas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Loja> obterPorNome(@PathVariable Integer id) {
        var loja = lojaService.obterPorId(id);

        if (loja != null) return ResponseEntity.ok(loja);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
}
