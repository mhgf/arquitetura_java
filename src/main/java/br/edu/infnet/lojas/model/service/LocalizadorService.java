package br.edu.infnet.lojas.model.service;

import br.edu.infnet.lojas.client.EnderecoClient;
import br.edu.infnet.lojas.client.LocalidadeClient;
import br.edu.infnet.lojas.model.domain.Endereco;
import br.edu.infnet.lojas.model.domain.Estado;
import br.edu.infnet.lojas.model.domain.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class LocalizadorService {
    private final EnderecoClient enderecoClient;
    private final LocalidadeClient localidadeClient;

    public LocalizadorService(EnderecoClient enderecoClient, LocalidadeClient localidadeClient) {
        this.enderecoClient = enderecoClient;
        this.localidadeClient = localidadeClient;
    }

    public Endereco findByCep(String cep) {
        return enderecoClient.findByCep(cep);
    }

    public Collection<Estado> obterEstados() {
        return localidadeClient.obterEstados();
    }

    public Collection<Municipio> obterMunicipios(Integer uf) {
        return localidadeClient.obterMunicipios(uf);
    }

}
