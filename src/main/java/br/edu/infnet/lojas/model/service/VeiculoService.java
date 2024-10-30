package br.edu.infnet.lojas.model.service;

import br.edu.infnet.lojas.model.domain.Veiculo;
import br.edu.infnet.lojas.model.repositoy.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo incluir(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> obterListaPorPreco(float precoInicial, float precoFinal){
        return this.veiculoRepository.findByPrecoBetween(precoInicial, precoFinal);
    }
}
