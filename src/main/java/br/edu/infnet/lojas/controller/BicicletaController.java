package br.edu.infnet.lojas.controller;

import br.edu.infnet.lojas.Constantes;
import br.edu.infnet.lojas.model.domain.Bicicleta;
import br.edu.infnet.lojas.model.service.BicicletaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {
    private final BicicletaService bicicletaService;

    public BicicletaController(BicicletaService bicicletaService) {
        this.bicicletaService = bicicletaService;
    }

    @GetMapping(value = "/lista")
    public ResponseEntity<Collection<Bicicleta>> listaBicicleta() {
        var lista = bicicletaService.obterLista();
        return ResponseEntity.ok(lista);
    }

    @PostMapping(value = "/incluir")
    public ResponseEntity<String> incluir(@Valid @RequestBody Bicicleta bicicleta) {
        bicicletaService.incluir(bicicleta);

        return ResponseEntity.ok(Constantes.MSG_INCLUSAO_SUCESSO);
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<Bicicleta> alterar(@Valid @RequestBody Bicicleta bicicleta) {
        var bicicletaAlterado = bicicletaService.alterar(bicicleta);

        return ResponseEntity.ok(bicicletaAlterado);
    }
}
