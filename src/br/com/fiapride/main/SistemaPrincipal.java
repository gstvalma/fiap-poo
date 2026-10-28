package br.com.fiapride.main;

import java.util.ArrayList;
import java.util.List;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Veiculo;
import br.com.fiapride.model.Viagem;

public class SistemaPrincipal {

    public static void main(String[] args) {

        System.out.println("--- Iniciando o Sistema FiapRide --- \n");

        // ===== Aula 2 e 3 - Métodos e Encapsulamento =====
        // Não precisamos mais de passageiro.nome = "Ana", já passamos tudo no construtor.
        Passageiro passageiro1 = new Passageiro("Ana Silva", "222.222.222-22");
        System.out.println(">>> Recarga Passageiro 1:");
        passageiro1.adicionarSaldo(50.0);

        Passageiro passageiro2 = new Passageiro("Carlos Souza", "333.333.333-33");
        System.out.println(">>> Recarga Passageiro 2:");
        passageiro2.adicionarSaldo(12.5);
        passageiro2.adicionarSaldo(-10); // recarga negativa, deve bloquear

        System.out.println("\n--- Status dos Passageiros ---");
        // Lendo os dados com os Getters:
        System.out.println("Passageiro: " + passageiro1.getNome() + " | Saldo: R$ " + passageiro1.getSaldo() + " | CPF: " + passageiro1.getCpf());
        System.out.println("Passageiro: " + passageiro2.getNome() + " | Saldo: R$ " + passageiro2.getSaldo() + " | CPF: " + passageiro2.getCpf());

        System.out.println("\n--- Realizando Viagens ---");
        System.out.println("Pagando viagem do passageiro 1 (Ana)...");
        passageiro1.pagarViagem(20.0); // Ana tem 50, vai sobrar 30.

        System.out.println("\nPagando viagem do passageiro 2 (Carlos)...");
        passageiro2.pagarViagem(20.0); // Carlos tem 12.5. O sistema DEVE bloquear!

        // Tentativa de hackear o sistema:
        // passageiro1.saldo = 999999.0; // não compila, o atributo é private!

        // ===== Aula 4 - Construtores =====
        System.out.println("\n--- Aula 4: Construtores ---");
        Passageiro passageiro3 = new Passageiro("Bruna Lima", "444.444.444-44", 30.0);
        System.out.println("Passageiro: " + passageiro3.getNome() + " | Saldo: R$ " + passageiro3.getSaldo());

        // TESTE 1: A forma correta (Nascimento legalizado)
        Veiculo meuCarro = new Carro("ABC-1234", "Toyota Corolla", 4); // (aula 8: Veiculo virou abstrata)
        meuCarro.atualizarPlaca("XYZ-9876"); // placa válida
        meuCarro.atualizarPlaca("");         // placa inválida, deve bloquear
        System.out.println("Placa final: " + meuCarro.getPlaca() + " | Modelo: " + meuCarro.getModelo());

        // TESTE 2: Tentando burlar o sistema
        // Veiculo carroFantasma = new Veiculo();
        // Não compila: "The constructor Veiculo() is undefined"
        // Quando criamos um construtor com parâmetros, o Java não cria mais o construtor vazio.

        // ===== Aula 5 - Associação =====
        System.out.println("\n--- Aula 5: Associação ---");
        // 1. Criamos os "atores" independentes primeiro
        Passageiro ana = new Passageiro("Ana Silva", "222.222.222-22");
        Veiculo carroDoJoao = new Carro("ABC-1234", "Toyota Corolla", 4);

        // 2. Criamos a Viagem, conectando (associando) os objetos
        Viagem viagemDaAna = new Viagem("Avenida Paulista, 1000", ana, carroDoJoao);
        viagemDaAna.exibirResumo();

        // 3. Prova da Passagem por Referência:
        // a Ana coloca saldo DEPOIS que a viagem foi criada... a viagem enxerga?
        ana.adicionarSaldo(50.0);
        System.out.println("Saldo da Ana consultado ATRAVÉS da Viagem: R$ " + viagemDaAna.getSolicitante().getSaldo());

        // 4. Fim da viagem: a Viagem cobra direto do objeto Passageiro
        viagemDaAna.finalizarViagem(-5);   // inválido
        viagemDaAna.finalizarViagem(27.90);
        viagemDaAna.exibirResumo();
        System.out.println("Saldo final da Ana: R$ " + ana.getSaldo());

        // ===== Aula 6 - Herança =====
        System.out.println("\n--- Aula 6: Teste de Frota (Herança) ---");
        int quantidadePassageiro = 4;
        Carro uberX = new Carro("DEF-1234", "Chevrolet Onix", quantidadePassageiro);
        Moto mottu = new Moto("GHI-9999", "Caloi City", true);
        Carro carroErrado = new Carro("JKL-5555", "Fiat Mobi", 50); // capacidade inválida

        // getPlaca() e getModelo() não estão escritos no Carro, ele herdou da mãe!
        System.out.println("Carro modelo: " + uberX.getModelo() + " | Placa: " + uberX.getPlaca());
        System.out.println("Vagas para passageiros: " + uberX.getCapacidadePassageiros());
        System.out.println("Vagas do " + carroErrado.getModelo() + ": " + carroErrado.getCapacidadePassageiros());

        System.out.println("\nMoto modelo: " + mottu.getModelo() + " | Placa: " + mottu.getPlaca());
        if (mottu.isEletrica()) {
            System.out.println("Atenção: Esta moto é elétrica e atinge maiores velocidades!");
        }

        // Um Carro também é um Veiculo, então pode ser usado numa Viagem
        Viagem viagemDeMoto = new Viagem("FIAP Paulista", passageiro1, mottu);
        viagemDeMoto.exibirResumo();

        // ===== Aula 7 - Polimorfismo =====
        // Lista da SUPERCLASSE: aceita qualquer herdeiro
        List<Veiculo> frota = new ArrayList<>();
        frota.add(uberX);
        frota.add(mottu);
        frota.add(new Carro("MNO-4321", "Honda Civic", 5));

        System.out.println("--- ⛽ RELATÓRIO DE AUTONOMIA DA FROTA ---");
        // Mesmo comando, resultados diferentes: o Java usa a conta de cada classe
        for (Veiculo veiculo : frota) {
            System.out.println("Veículo: " + veiculo.getModelo());
            veiculo.abastecer(50);
            System.out.println(veiculo.calcularAutonomia());
            System.out.println("---------------------------------------");
        }
        uberX.abastecer(-10); // inválido

        // ===== Aula 8 - Classes Abstratas =====
        System.out.println("\n=== FIAPRIDE: Teste de Classes Abstratas ===");
        // Veiculo v = new Veiculo("ABC-1234", "Generico");
        // ❌ Não compila: "Cannot instantiate the type Veiculo" -> Veiculo é só um molde!

        Veiculo taxi = new Carro("PQR-1111", "Chevrolet Onix", 4);
        Veiculo mototaxi = new Moto("STU-2222", "Honda Biz", false);
        taxi.exibirTipo();
        mototaxi.exibirTipo();

        System.out.println("\n=== Polimorfismo com Classe Abstrata ===");
        Veiculo[] frotaNova = new Veiculo[] {
            new Carro("VWX-3333", "Fiat Uno", 4),
            new Moto("YZA-4444", "Yamaha Factor", false),
            new Carro("BCD-5555", "Honda Civic", 5)
        };
        for (Veiculo v : frotaNova) {
            System.out.print(v.getModelo() + " -> ");
            v.exibirTipo();
        }
    }
}
