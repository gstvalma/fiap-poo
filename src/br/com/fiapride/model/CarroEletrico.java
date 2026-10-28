package br.com.fiapride.model;

// Herda de UMA mãe (Veiculo) e assina o contrato Recarregavel
public class CarroEletrico extends Veiculo implements Recarregavel {

    private int nivelBateria;

    public CarroEletrico(String placa, String modelo) {
        super(placa, modelo);
    }

    // OBRIGATÓRIO: método da interface
    @Override
    public void recarregar(int percentual) {
        if (percentual < Recarregavel.CARGA_MINIMA || percentual > Recarregavel.CARGA_MAXIMA) {
            System.out.println("Erro: Percentual inválido!");
            return;
        }
        this.setNivelBateria(percentual);
        System.out.println("Carro " + this.getModelo() + " recarregado para " + percentual + "%");
    }

    // OBRIGATÓRIO: método abstrato da mãe Veiculo
    @Override
    public void exibirTipo() {
        System.out.println("Sou um Carro Elétrico");
    }

    // Carro elétrico não usa combustível, a autonomia vem da bateria
    @Override
    public String calcularAutonomia() {
        double kmRestante = this.getNivelBateria() * 5.0;
        return "Autonomia: " + kmRestante + " km.";
    }

    public int getNivelBateria() {
        return this.nivelBateria;
    }

    private void setNivelBateria(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }
}
