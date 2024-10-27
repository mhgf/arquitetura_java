package br.edu.infnet.lojas.model.service;

import br.edu.infnet.lojas.model.domain.Veiculo;
import br.edu.infnet.lojas.model.repositoy.VeiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo incluir(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
}
