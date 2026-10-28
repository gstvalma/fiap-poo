package br.com.fiapride.model;

// A palavra 'extends' faz a herança acontecer: Carro É UM Veiculo
public class Carro extends Veiculo {

    // Atributo exclusivo do Carro (a mãe Veiculo não tem isso)
    private int capacidadePassageiros;

    public Carro(String placa, String modelo, int capacidadePassageiros) {
        // 'super' chama o construtor da mãe para resolver placa e modelo
        super(placa, modelo);

        // E aqui o Carro resolve o que é dele:
        this.setCapacidadePassageiros(capacidadePassageiros);
    }

    public int getCapacidadePassageiros() {
        return this.capacidadePassageiros;
    }

    private void setCapacidadePassageiros(int capacidadePassageiros) {
        // Carro de aplicativo leva de 1 a 7 passageiros
        if (capacidadePassageiros < 1 || capacidadePassageiros > 7) {
            System.out.println("❌ Erro: capacidade inválida, usando o padrão de 4 passageiros.");
            this.capacidadePassageiros = 4;
            return;
        }
        this.capacidadePassageiros = capacidadePassageiros;
    }

    @Override // garante que estou sobrescrevendo o método da mãe (se errar o nome, dá erro)
    public String calcularAutonomia() {
        double kmRestante = this.getNivelCombustivel() * 10.0;
        return "Autonomia: " + kmRestante + " km (Consumo de 10 km/l).";
    }
}
