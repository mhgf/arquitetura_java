package br.edu.infnet.lojas.controller;

import br.edu.infnet.lojas.model.domain.Loja;
import br.edu.infnet.lojas.model.service.LojaService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class LojaController {
    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @GetMapping(value = "/lista/loja")
    public Collection<Loja> listar() {
        return lojaService.listar();
    }

    @PostMapping(value = "/loja/incluir")
    public  String incluir(@RequestBody Loja loja) {
        lojaService.incluir(loja);
        return "Inclusão realizada com sucesso!";
    }

    @DeleteMapping(value = "/loja/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        lojaService.excluir(id);

        return "Exclusão realizada com sucesso!";
    }


    @GetMapping(value = "/loja/buscar/{nome}")
    public Collection<Loja> obterPorNome(@PathVariable String nome) {
        return lojaService.obterPorNome(nome);
    }

    @GetMapping(value = "/loja/{id}")
    public Loja obterPorNome(@PathVariable Integer id) {
        return lojaService.obterPorId(id);
    }
}
