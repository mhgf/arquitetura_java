package br.edu.infnet.lojas.client;

import br.edu.infnet.lojas.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface EnderecoClient {
    @GetMapping(value = "/{cep}/json")
    Endereco findByCep(@PathVariable String cep);
}
