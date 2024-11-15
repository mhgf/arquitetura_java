package br.edu.infnet.lojas.model.service;

import br.edu.infnet.lojas.Constantes;
import br.edu.infnet.lojas.exceptions.VeiculoNaoEncontradoException;
import br.edu.infnet.lojas.model.domain.Veiculo;
import br.edu.infnet.lojas.model.repositoy.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Collection<Veiculo> listar() {
        return (Collection<Veiculo>) veiculoRepository.findAll();
    }

    public Veiculo incluir(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> obterListaPorPreco(float precoInicial, float precoFinal) {
        return this.veiculoRepository.findByPrecoBetween(precoInicial, precoFinal);
    }

    public long obterQtde() {
        return veiculoRepository.count();
    }

    public void excluir(Integer id) {
        veiculoRepository.deleteById(id);
    }


    public Veiculo obterPorId(Integer id) {
        return veiculoRepository.findById(id).orElseThrow(() -> new VeiculoNaoEncontradoException(Constantes.MSG_VEICULO_NOT_FOUND));
    }

    public Veiculo alterar(Integer id, float preco) {
        var veiculo = veiculoRepository.findById(id).orElseThrow(() -> new VeiculoNaoEncontradoException(Constantes.MSG_VEICULO_NOT_FOUND));
        veiculo.setPreco(preco);

        return veiculoRepository.save(veiculo);
    }
}
