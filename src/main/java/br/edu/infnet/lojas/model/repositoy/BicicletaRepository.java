package br.edu.infnet.lojas.model.repositoy;

import br.edu.infnet.lojas.model.domain.Bicicleta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicicletaRepository extends CrudRepository<Bicicleta, Integer> {
}
