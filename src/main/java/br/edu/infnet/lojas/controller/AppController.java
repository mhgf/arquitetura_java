package br.edu.infnet.lojas.controller;

import br.edu.infnet.lojas.model.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.edu.infnet.lojas.model.service.LojaService;

@Controller
public class AppController {

    @Autowired
    private  LojaService lojaService;
    @Autowired
    private  VeiculoService veiculoService;

//    public AppController(VeiculoService veiculoService, LojaService lojaService) {
//        this.lojaService = lojaService;
//        this.veiculoService = veiculoService;
//    }

    @GetMapping(value = "/")
    public String telaHome(Model model) {

        model.addAttribute("qtdeVendedor", lojaService.obterQtde());
        model.addAttribute("qtdeProduto", veiculoService.obterQtde());
        model.addAttribute("qtdeAlimenticio", 123);
        model.addAttribute("qtdeEletronico", 234);

        return "home";
    }

    @GetMapping(value = "/loja/listagem")
    public String vendedorLista(Model model) {

        model.addAttribute("titulo", "Listagem de vendedores");
        model.addAttribute("listagem", lojaService.listar());

        return telaHome(model);
    }

    @GetMapping(value = "/veiculo/listagem")
    public String produtoLista(Model model) {

        model.addAttribute("titulo", "Listagem de produtos");
        model.addAttribute("listagem", veiculoService.listar());

        return telaHome(model);
    }

    @GetMapping(value = "/carro/listagem")
    public String eletronicoLista(Model model) {

        model.addAttribute("titulo", "Listagem de produtos eletrônicos");
        model.addAttribute("listagem", veiculoService.listar());

        return telaHome(model);
    }

    @GetMapping(value = "/bicicleta/listagem")
    public String alimenticioLista(Model model) {

        model.addAttribute("titulo", "Listagem de produtos alimenticios");
        model.addAttribute("listagem", veiculoService.listar());

        return telaHome(model);
    }
}
