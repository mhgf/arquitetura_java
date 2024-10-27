package br.edu.infnet.lojas.controller;

import br.edu.infnet.lojas.model.domain.Loja;
import br.edu.infnet.lojas.model.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class LojaController {
    @Autowired
    private LojaService lojaService;

    @GetMapping(value = "/lista/loja")
    public Collection<Loja> buscarLojas() {
        return lojaService.listar();
    }
}
