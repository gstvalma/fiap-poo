package br.com.fiapride.main;

import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Pet;

public class SistemaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// INSTANCIAÇÃO
        // O comando 'new' aloca memória para um novo objeto.
        // Criando o primeiro passageiro (Objeto 1)
        Passageiro passageiro1 = new Passageiro("Ana Silva", "222");
        System.out.println("Regarga passageiro 1");
        passageiro1.adicionarSaldo(50.0);

        // Criando o segundo passageiro (Objeto 2)
        Passageiro passageiro2 = new Passageiro("Carlos Souza", "333");
        System.out.println("Regarga passageiro 2");
        passageiro2.adicionarSaldo(12.5);

        System.out.println("--- Sistema FiapRide ---");
        System.out.println("Passageiro: " + passageiro1.nome + " | Saldo: R$ " + passageiro1.saldo + " | CPF: " + passageiro1.cpf);
        System.out.println("Passageiro: " + passageiro2.nome + " | Saldo: R$ " + passageiro2.saldo + " | CPF: " + passageiro2.cpf);
        
        System.out.println("Pagando viagem do passageiro 1");
        passageiro1.pagarViagem(20);
        System.out.println("Pagando viagem do passageiro 2");
        passageiro2.pagarViagem(20);

		
		Pet pet1 = new Pet();
		pet1.nome = "Hemerson";
		pet1.especie = "Cachorro";
		pet1.idade = 1.0;
		
		Pet pet2 = new Pet();
		pet2.nome = "Maria Braga";
		pet2.especie = "Calopsita";
		pet2.idade = 3.2;
		
		System.out.println(" - - - Informações de seu pet - - -");
		System.out.println("|      Nome      |     Especie     |Idade (em anos)|");
		System.out.println("|   " + pet1.nome + "  | " + pet1.especie + "  | "     + pet1.idade + "    |");
		System.out.println("|   " + pet2.nome + "  |	 " + pet2.especie + "  | " + pet2.idade + " |"  );

	}

}
