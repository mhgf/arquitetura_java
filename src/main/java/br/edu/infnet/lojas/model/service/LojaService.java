package br.edu.infnet.lojas.model.service;

import br.edu.infnet.lojas.model.domain.Loja;
import br.edu.infnet.lojas.model.repositoy.LojaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class LojaService {
    private final LojaRepository lojaRepository;
    private final LocalizadorService localizadorService;

    public LojaService(LojaRepository lojaRepository, LocalizadorService localizadorService) {
        this.lojaRepository = lojaRepository;
        this.localizadorService = localizadorService;
    }

    public Loja incluir(Loja loja) {

        var cep = loja.getEndereco().getCep();

        var endereco = localizadorService.findByCep(cep);

        loja.setEndereco(endereco);

        return lojaRepository.save(loja);
    }

    public Collection<Loja> listar() {
        return (Collection<Loja>) this.lojaRepository.findAll(Sort.by(Sort.Order.asc("nome")));
    }

    public boolean excluir(Integer id) {
        this.lojaRepository.deleteById(id);
        return true;
    }

    public List<Loja> obterPorNome(String nome) {
        return this.lojaRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
    }

    public Loja obterPorId(Integer id) {
        return this.lojaRepository.findById(id).orElse(null);
    }


    public long obterQtde() {
        return lojaRepository.count();
    }

}
