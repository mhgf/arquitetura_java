package br.edu.infnet.lojas.model.service;

import br.edu.infnet.lojas.Constantes;
import br.edu.infnet.lojas.exceptions.VeiculoNaoEncontradoException;
import br.edu.infnet.lojas.model.domain.Carro;
import br.edu.infnet.lojas.model.repositoy.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarroService {
    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public Collection<Carro> obterLista() {
        return (Collection<Carro>) carroRepository.findAll();
    }

    public void incluir(Carro carro) {
        carroRepository.save(carro);
    }

    public long obterQtde() {
        return carroRepository.count();
    }

    public Carro alterar(Carro carro) {

        if (!carroRepository.existsById(carro.getId())) {
            throw new VeiculoNaoEncontradoException(Constantes.MSG_VEICULO_NOT_FOUND);
        }

        return carroRepository.save(carro);
    }
}
