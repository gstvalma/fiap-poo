package br.com.fiapride.model;

public class Veiculo {

    // 1. Atributos sempre privados (Encapsulamento)
    private String placa;
    private String modelo;
    private double nivelCombustivel; // em litros

    // 2. O CONSTRUTOR (O Cartório)
    public Veiculo(String placa, String modelo) {
        // Usamos o setter privado para validar a placa logo no nascimento!
        this.setPlaca(placa);
        this.modelo = modelo;
        System.out.println("🚗 Registro inicial: Um " + this.modelo + " nasceu com a placa " + this.placa);
    }

    // 3. Getters (Apenas leitura)
    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    // 4. COMPORTAMENTO PÚBLICO (A regra de negócio / Ação)
    // Representa o processo real no Detran, não só "mudar um dado"
    public void atualizarPlaca(String novaPlaca) {
        System.out.println("🔄 Solicitada atualização de placa no Detran para o veículo " + this.modelo + "...");
        this.setPlaca(novaPlaca); // Chama o método privado que contém a regra de segurança
    }

    // 5. SETTER PRIVADO (A engrenagem interna de validação)
    private void setPlaca(String novaPlaca) {
        // Regra de negócio: a placa não pode ser nula nem vazia
        if (novaPlaca != null && !novaPlaca.trim().isEmpty()) {
            this.placa = novaPlaca;
            System.out.println("✅ Sucesso: A placa agora é " + this.placa);
        } else {
            System.out.println("❌ Erro de Validação: A placa informada é inválida!");
        }
    }

    // Obs: O modelo do carro é IMUTÁVEL na vida real (um Fiat Uno não se transforma em um Corolla).
    // Por isso NÃO existe setModelo()!

    // ===== Aula 7 - Polimorfismo =====
    // O "contrato" fica na mãe para que o loop da frota consiga chamar em qualquer veículo
    public String calcularAutonomia() {
        return "Autonomia não definida para um veículo genérico.";
    }

    public void abastecer(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("❌ Erro: quantidade de combustível inválida!");
            return;
        }
        this.setNivelCombustivel(this.getNivelCombustivel() + quantidade);
    }

    public double getNivelCombustivel() {
        return this.nivelCombustivel;
    }

    // Privado: o combustível só entra pelo abastecer()
    private void setNivelCombustivel(double nivelCombustivel) {
        this.nivelCombustivel = nivelCombustivel;
    }
}
