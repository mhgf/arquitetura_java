package br.edu.infnet.lojas.model.service;

import br.edu.infnet.lojas.model.domain.Loja;
import br.edu.infnet.lojas.model.repositoy.LojaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
        return (Collection<Loja>) this.lojaRepository.findAll();
    }

    public void excluir(Integer id){
        this.lojaRepository.deleteById(id);
    }

    public List<Loja> obterPorNome(String nome) {
        return  this.lojaRepository.findByNomeContaining(nome);
    }

    public Loja obterPorId(Integer id) {
        return  this.lojaRepository.findById(id).orElse(null);
    }


    public long obterQtde() {
        return lojaRepository.count();
    }

}
