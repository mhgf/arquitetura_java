package br.edu.infnet.lojas.model.service;

import br.edu.infnet.lojas.model.domain.Loja;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LojaService {
    private Map<String, Loja> lojaMap = new HashMap<>();

    public void incluir(Loja loja) {
        lojaMap.put(loja.getNome(), loja);
    }

    public Collection<Loja> listar() {
        return this.lojaMap.values();
    }
}
