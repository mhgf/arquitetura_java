package br.edu.infnet.lojas;

import br.edu.infnet.lojas.model.domain.Bicicleta;
import br.edu.infnet.lojas.model.domain.Carro;
import br.edu.infnet.lojas.model.domain.Endereco;
import br.edu.infnet.lojas.model.domain.Loja;
import br.edu.infnet.lojas.model.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class Loader implements ApplicationRunner {

    @Autowired
    private LojaService lojaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("Files/lojas.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        Loja loja = null;

        while (linha != null) {
            String[] campos = linha.split(";");

            switch (campos[0].toUpperCase()) {
                case "L":
                    Endereco endereco = new Endereco();
                    endereco.setCep(campos[3]);

                    loja = new Loja();

                    loja.setNome(campos[1]);
                    loja.setEmail(campos[2]);
                    loja.setEndereco(endereco);

                    lojaService.incluir(loja);
                    break;
                case "C":
                    Carro carro = new Carro();
                    carro.setModelo(campos[1]);

                    loja.getVeiculos().add(carro);

                    break;
                case "B":
                    Bicicleta bicicleta = new Bicicleta();
                    bicicleta.setModelo(campos[1]);

                    loja.getVeiculos().add(bicicleta);
                    break;
                default:
                    break;

            }

            linha = leitura.readLine();
        }

        for (Loja l : lojaService.listar()) {
            System.out.println(l);
        }

        leitura.close();
    }
}
