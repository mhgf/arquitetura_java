package br.edu.infnet.lojas.model.repositoy;

import br.edu.infnet.lojas.model.domain.Carro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Integer> {
}
