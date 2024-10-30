package br.edu.infnet.lojas.model.repositoy;

import br.edu.infnet.lojas.model.domain.Veiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {
    List<Veiculo> findByPrecoBetween(float precoInicial, float precoFinal);

}
