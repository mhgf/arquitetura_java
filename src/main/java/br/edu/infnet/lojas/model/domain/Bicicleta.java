package br.edu.infnet.lojas.model.domain;

public class Bicicleta extends Veiculo{
    private int marchas;
    private boolean freioDisco;

    public boolean isFreioDisco() {
        return freioDisco;
    }

    public void setFreioDisco(boolean freioDisco) {
        this.freioDisco = freioDisco;
    }

    public int getMarchas() {
        return marchas;
    }

    public void setMarchas(int marchas) {
        this.marchas = marchas;
    }
}
