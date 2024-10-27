package br.edu.infnet.lojas.model.repositoy;

import br.edu.infnet.lojas.model.domain.Veiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {
}
