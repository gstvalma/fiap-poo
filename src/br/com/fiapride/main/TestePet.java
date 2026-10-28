package br.com.fiapride.main;

import br.com.fiapride.model.Pet;

public class TestePet {

	public static void main(String[] args) {

		System.out.println("--- Teste do Meu Projeto Pessoal (Pet) ---");

		// ===== Aula 2 e 3 - Métodos e Encapsulamento =====
		// (aula 4: agora os pets já nascem com nome, espécie e idade pelo construtor)
		Pet pet1 = new Pet("Hemerson", "Cachorro", 1.0);
		Pet pet2 = new Pet("Maria Braga", "Calopsita", 3.2);

		System.out.println(" - - - Informações de seu pet - - -");
		System.out.println("|      Nome      |     Especie     |Idade (em anos)|");
		System.out.println("|   " + pet1.getNome() + "  | " + pet1.getEspecie() + "  | " + pet1.getIdade() + "    |");
		System.out.println("|   " + pet2.getNome() + "  | " + pet2.getEspecie() + "  | " + pet2.getIdade() + " |");

		System.out.println("\n - - - Testando os métodos - - -");
		pet1.atualizarPeso(12.5);
		pet1.fazerAniversario();
		System.out.println(pet1.getNome() + " tem " + pet1.calcularIdadeEmMeses() + " meses.");
		System.out.println(pet1.getNome() + " precisa de " + pet1.calcularRacaoDiaria() + "g de ração por dia.");

		System.out.println("\n - - - Tentando burlar o sistema - - -");
		pet2.setIdade(-5);     // bloqueado
		pet2.setIdade(120);    // bloqueado
		pet2.setNome("   ");   // bloqueado
		pet2.atualizarPeso(-3); // bloqueado
		System.out.println("Pet 2 continua: " + pet2.getNome() + ", " + pet2.getIdade() + " anos, " + pet2.getPeso() + " kg");

		// pet2.idade = -5; // não compila mais, o atributo é private!

		// ===== Aula 4 - Construtores =====
		System.out.println("\n - - - Testando os construtores - - -");
		Pet resgatado = new Pet(); // construtor padrão
		Pet filhote = new Pet("Pipoca", "Gato"); // idade começa em 0
		System.out.println("Resgatado: " + resgatado.getNome() + " | Espécie: " + resgatado.getEspecie());
		System.out.println("Filhote: " + filhote.getNome() + " | " + filhote.getEspecie() + " | " + filhote.getIdade() + " anos");

		// pet1.setEspecie("Gato"); // não existe, a espécie não muda depois de criada
	}

}
