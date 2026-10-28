package br.com.fiapride.main;

import br.com.fiapride.model.Pet;

public class TestePet {

	public static void main(String[] args) {

		System.out.println("--- Teste do Meu Projeto Pessoal (Pet) ---");

		// ===== Aula 2 e 3 - Métodos e Encapsulamento =====
		Pet pet1 = new Pet();
		pet1.setNome("Hemerson");
		pet1.setEspecie("Cachorro");
		pet1.setIdade(1.0);

		Pet pet2 = new Pet();
		pet2.setNome("Maria Braga");
		pet2.setEspecie("Calopsita");
		pet2.setIdade(3.2);

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
	}

}
