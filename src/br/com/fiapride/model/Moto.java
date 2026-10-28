package br.com.fiapride.model;

public class Moto extends Veiculo {

    private boolean isEletrica;

    public Moto(String placa, String modelo, boolean isEletrica) {
        super(placa, modelo); // Repassa para a mãe
        this.isEletrica = isEletrica;
    }

    public boolean isEletrica() {
        return this.isEletrica;
    }
}
