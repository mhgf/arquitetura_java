package br.edu.infnet.lojas.controller;

import br.edu.infnet.lojas.model.domain.Veiculo;
import br.edu.infnet.lojas.model.service.VeiculoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VeiculoController {
    private  final VeiculoService veiculoService;


    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping(value = "/veiculo/filtrarPorPreco/{min}/{max}")
    public List<Veiculo> filtrarPorPreco(@PathVariable float min, @PathVariable float max) {
        return  this.veiculoService.obterListaPorPreco(min, max);
    }
}
