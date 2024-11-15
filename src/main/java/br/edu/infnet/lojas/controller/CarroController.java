package br.edu.infnet.lojas.controller;

import br.edu.infnet.lojas.Constantes;
import br.edu.infnet.lojas.model.domain.Carro;
import br.edu.infnet.lojas.model.service.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RestController
@RequestMapping("/carros")
public class CarroController {
    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping(value = "/lista")
    public ResponseEntity<Collection<Carro>> listaCarros() {
        return ResponseEntity.ok(carroService.obterLista());
    }

    @PostMapping(value = "/incluir")
    public ResponseEntity<String> incluir(@Valid @RequestBody Carro carro) {
        carroService.incluir(carro);

        return ResponseEntity.ok(Constantes.MSG_INCLUSAO_SUCESSO);
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<Carro> alterar(@Valid @RequestBody Carro carro) {
        var carroAlterado = carroService.alterar(carro);

        return ResponseEntity.ok(carroAlterado);
    }
}
