package br.com.fiapride.model;

public class Passageiro {

    // Agora ninguém fora desta classe consegue mexer nisso diretamente!
    private String nome;
    private String cpf;
    private double saldo;

    // Para criar um passageiro é OBRIGATÓRIO informar nome e cpf
    public Passageiro(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSaldo(0); // Todo mundo começa com zero!
    }

    // Construtor para quem já faz a primeira recarga no cadastro (promoção de boas-vindas)
    // this(...) reaproveita o construtor de cima em vez de repetir o código
    public Passageiro(String nome, String cpf, double recargaInicial) {
        this(nome, cpf);
        this.adicionarSaldo(recargaInicial);
    }

    public void adicionarSaldo(double valor) {
        // Regra de negócio: O valor da recarga deve ser positivo
        if (valor <= 0) {
            System.out.println("Erro: O valor de recarga deve ser maior que zero.");
            return; // Interrompe a execução do método
        }
        this.setSaldo(this.saldo + valor);
        System.out.println("Recarga realizada. Novo saldo: " + this.saldo);
    }

    public void pagarViagem(double custo) {
        // Regra de negócio: O custo deve ser positivo e o saldo deve ser suficiente
        if (custo <= 0) {
            System.out.println("Erro: O custo da viagem é inválido.");
            return;
        }
        if (this.saldo < custo) {
            System.out.println("Erro: Saldo insuficiente para realizar a viagem.");
            return;
        }
        this.setSaldo(this.saldo - custo);
        System.out.println("Viagem paga. Saldo restante: " + this.saldo);
    }

    public double getSaldo() {
        return this.saldo; // Apenas devolve o valor, não altera nada.
    }

    // Privado: o saldo só muda pelo adicionarSaldo() e pagarViagem()
    private void setSaldo(double valor) {
        if (valor >= 0) {
            this.saldo = valor;
        } else {
            System.out.println("Erro de Segurança: Tentativa de definir saldo negativo bloqueada!");
        }
    }

    public String getNome() {
        return this.nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
