package br.edu.infnet.lojas.controller;

import br.edu.infnet.lojas.model.domain.Loja;
import br.edu.infnet.lojas.model.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/loja/buscar/{nome}")
    public Collection<Loja> obterPorNome(@PathVariable String nome) {
        return lojaService.obterPorNome(nome);
    }
}
