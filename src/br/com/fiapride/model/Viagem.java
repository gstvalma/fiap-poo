package br.com.fiapride.model;

public class Viagem {

    // 1. Atributos Simples
    private String destino;
    private double valor;

    // 2. ATRIBUTOS DE ASSOCIAÇÃO (Objetos Complexos)
    // O nome da variável indica O PAPEL que o objeto desempenha na Viagem
    private Passageiro solicitante;
    private Veiculo veiculoUtilizado;

    // 3. CONSTRUTOR (Regra de Negócio)
    // Uma viagem SÓ PODE nascer se tiver um destino, um passageiro e um carro!
    public Viagem(String destino, Passageiro solicitante, Veiculo veiculoUtilizado) {
        this.destino = destino;
        this.solicitante = solicitante;
        this.veiculoUtilizado = veiculoUtilizado;
        this.valor = 0.0; // Inicia zerado, é definido quando a viagem termina

        System.out.println("✅ Nova viagem solicitada para: " + this.destino);
    }

    // 4. MÉTODOS DE AÇÃO (Comportamento)
    public void exibirResumo() {
        System.out.println("\n--- RESUMO DA VIAGEM ---");
        System.out.println("Destino: " + this.destino);

        // Navegando entre os objetos: Viagem -> Solicitante -> Nome
        System.out.println("Passageiro: " + this.solicitante.getNome());
        System.out.println("Veículo: " + this.veiculoUtilizado.getModelo() + " (Placa: " + this.veiculoUtilizado.getPlaca() + ")");
        System.out.println("Valor: R$ " + this.valor);
        System.out.println("------------------------\n");
    }

    // Como a Viagem tem o OBJETO passageiro (e não só o nome), ela consegue cobrar a corrida dele
    public void finalizarViagem(double valorCorrida) {
        if (valorCorrida <= 0) {
            System.out.println("Erro: valor da corrida inválido.");
            return;
        }
        this.valor = valorCorrida;
        System.out.println("🏁 Viagem para " + this.destino + " finalizada. Cobrando R$ " + valorCorrida + " de " + this.solicitante.getNome());
        this.solicitante.pagarViagem(valorCorrida);
    }

    // Getters
    public String getDestino() { return this.destino; }
    public double getValor() { return this.valor; }
    public Passageiro getSolicitante() { return this.solicitante; }
    public Veiculo getVeiculoUtilizado() { return this.veiculoUtilizado; }

}
