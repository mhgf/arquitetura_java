package br.edu.infnet.lojas.client;

import br.edu.infnet.lojas.model.domain.Estado;
import br.edu.infnet.lojas.model.domain.Municipio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/docs/localidades", name = "ibgeClient")
public interface LocalidadeClient {

    @GetMapping(value = "/estados")
    public Collection<Estado> obterEstados();

    @GetMapping("/estados/{uf}/municipios")
    public Collection<Municipio> obterMunicipios(@PathVariable Integer uf);
}
