package br.edu.infnet.lojas.model.service;

import br.edu.infnet.lojas.model.domain.Loja;
import br.edu.infnet.lojas.model.repositoy.LojaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LojaService {
    private final LojaRepository lojaRepository;
    private final LocalizadorService localizadorService;

    public LojaService(LojaRepository lojaRepository, LocalizadorService localizadorService) {
        this.lojaRepository = lojaRepository;
        this.localizadorService = localizadorService;
    }

    private Map<String, Loja> lojaMap = new HashMap<>();

    public Loja incluir(Loja loja) {

        var cep = loja.getEndereco().getCep();

        var endereco = localizadorService.findByCep(cep);

        loja.setEndereco(endereco);

        lojaMap.put(loja.getNome(), loja);

        return lojaRepository.save(loja);
    }

    public Collection<Loja> listar() {
        return this.lojaMap.values();
    }
}
