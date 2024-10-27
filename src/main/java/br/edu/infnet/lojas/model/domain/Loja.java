package br.edu.infnet.lojas.model.domain;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TLoja")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;

    @Transient
    private Endereco endereco;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Veiculo> veiculos;

    public Loja() {
        this.veiculos = new ArrayList<Veiculo>();
    }

    @Override
    public String toString() {
        return String.format("Loja %s cadastrado! %s; Produtos %d", nome, endereco, veiculos.size());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
