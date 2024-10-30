package br.edu.infnet.lojas.model.repositoy;

import br.edu.infnet.lojas.model.domain.Loja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LojaRepository extends CrudRepository<Loja, Integer> {
    List<Loja> findByNomeContaining(String nome);
}
