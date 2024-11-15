package br.edu.infnet.lojas.model.service;

import br.edu.infnet.lojas.Constantes;
import br.edu.infnet.lojas.exceptions.VeiculoNaoEncontradoException;
import br.edu.infnet.lojas.model.domain.Bicicleta;
import br.edu.infnet.lojas.model.repositoy.BicicletaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BicicletaService {
    private final BicicletaRepository bicicletaRepository;

    public BicicletaService(BicicletaRepository bicicletaRepository) {
        this.bicicletaRepository = bicicletaRepository;
    }

    public Collection<Bicicleta> obterLista() {
        return (Collection<Bicicleta>) bicicletaRepository.findAll();
    }

    public void incluir(Bicicleta bicicleta) {
        bicicletaRepository.save(bicicleta);
    }

    public long obterQtde() {
        return bicicletaRepository.count();
    }

    public Bicicleta alterar(Bicicleta bicicleta) {

        if (!bicicletaRepository.existsById(bicicleta.getId())) {
            throw new VeiculoNaoEncontradoException(Constantes.MSG_VEICULO_NOT_FOUND);
        }

        return bicicletaRepository.save(bicicleta);
    }
}
