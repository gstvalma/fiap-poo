package br.com.fiapride.main;

import java.util.ArrayList;
import java.util.List;

import br.com.fiapride.model.Cachorro;
import br.com.fiapride.model.Gato;
import br.com.fiapride.model.Passaro;
import br.com.fiapride.model.Pet;
import br.com.fiapride.model.Tutor;
import br.com.fiapride.model.Vacinavel;

public class TestePet {

	public static void main(String[] args) {

		System.out.println("--- Teste do Meu Projeto Pessoal (Pet) ---");

		// Aula 8: Pet virou abstrata, então os testes antigos agora usam as filhas
		Tutor luiz = new Tutor("Luiz", "11 99999-1234");
		Tutor marina = new Tutor("Marina", "11 98888-4321");

		// ===== Aula 2 e 3 - Métodos e Encapsulamento =====
		Pet pet1 = new Cachorro("Rex", luiz, "P");
		pet1.setIdade(1.0);
		Pet pet2 = new Passaro("Kiwi", marina, false);
		pet2.setIdade(3.2);

		System.out.println(" - - - Informações de seu pet - - -");
		System.out.println("|      Nome      |     Especie     |Idade (em anos)|");
		System.out.println("|   " + pet1.getNome() + "  | " + pet1.getEspecie() + "  | " + pet1.getIdade() + "    |");
		System.out.println("|   " + pet2.getNome() + "  | " + pet2.getEspecie() + "  | " + pet2.getIdade() + " |");

		System.out.println("\n - - - Testando os métodos - - -");
		pet1.atualizarPeso(8.0);
		pet1.fazerAniversario();
		System.out.println(pet1.getNome() + " tem " + pet1.calcularIdadeEmMeses() + " meses.");
		System.out.println(pet1.getNome() + " precisa de " + pet1.calcularRacaoDiaria() + "g de ração por dia.");

		System.out.println("\n - - - Tentando burlar o sistema - - -");
		pet2.setIdade(-5);      // bloqueado
		pet2.setIdade(120);     // bloqueado
		pet2.setNome("   ");    // bloqueado
		pet2.atualizarPeso(-3); // bloqueado
		pet2.setIdade(39.5);
		pet2.fazerAniversario(); // passaria de 40, bloqueado
		System.out.println("Pet 2 continua: " + pet2.getNome() + ", " + pet2.getIdade() + " anos, " + pet2.getPeso() + " kg");
		// pet2.idade = -5; // não compila, o atributo é private!

		// ===== Aula 4 - Construtores =====
		System.out.println("\n - - - Testando os construtores - - -");
		Gato resgatado = new Gato(); // construtor padrão -> this("Sem nome", null, false)
		Gato pipoca = new Gato("Pipoca", marina, true);
		System.out.println("Resgatado: " + resgatado.getNome() + " | Espécie: " + resgatado.getEspecie());
		System.out.println("Filhote: " + pipoca.getNome() + " | " + pipoca.getEspecie() + " | " + pipoca.getIdade() + " anos");
		// pet1.setEspecie("Gato"); // não existe, a espécie não muda depois de criada

		// ===== Aula 5 - Associação =====
		System.out.println("\n - - - Testando a associação Pet -> Tutor - - -");
		Cachorro thor = new Cachorro("Thor", luiz, "G");
		thor.atualizarPeso(30);
		thor.exibirFicha();
		System.out.println("Ligar para o tutor do " + thor.getNome() + ": " + thor.getTutor().getTelefone());

		// Prova da referência: se o tutor muda o telefone, a ficha do pet já enxerga
		luiz.atualizarTelefone("11 97777-0000");
		luiz.atualizarTelefone("123"); // inválido
		System.out.println("Telefone visto pelo pet: " + thor.getTutor().getTelefone());

		resgatado.exibirFicha();       // sem tutor
		resgatado.trocarTutor(null);   // bloqueado
		resgatado.trocarTutor(marina); // adoção!
		resgatado.setNome("Frajola");
		resgatado.exibirFicha();

		// ===== Aula 6 - Herança =====
		System.out.println("\n - - - Testando a herança - - -");
		Cachorro hemerson = new Cachorro("Hemerson", luiz, "M");
		Gato mingau = new Gato("Mingau", marina, false);
		Passaro mariaBraga = new Passaro("Maria Braga", luiz, true);
		Cachorro semPorte = new Cachorro("Bidu", marina, "XXL"); // porte inválido

		hemerson.atualizarPeso(12.5); // método herdado da mãe Pet
		hemerson.exibirFicha();
		System.out.println("Porte do " + hemerson.getNome() + ": " + hemerson.getPorte());
		System.out.println("Porte do " + semPorte.getNome() + ": " + semPorte.getPorte());

		mingau.castrar();
		mingau.castrar(); // já castrado, deve bloquear
		System.out.println(mingau.getNome() + " é castrado? " + mingau.isCastrado());
		System.out.println(mariaBraga.getNome() + " (" + mariaBraga.getEspecie() + ") pode voar solto? " + mariaBraga.podeVoarSolto());

		// ===== Aula 7 - Polimorfismo =====
		System.out.println("\n - - - Relatório da clínica (polimorfismo) - - -");
		mingau.atualizarPeso(4.0);
		mariaBraga.atualizarPeso(0.09);

		List<Pet> pacientes = new ArrayList<>();
		pacientes.add(hemerson);
		pacientes.add(mingau);
		pacientes.add(mariaBraga);
		pacientes.add(semPorte); // sem peso cadastrado

		// Sem nenhum if para descobrir o tipo: cada objeto sabe o seu som e a sua ração
		for (Pet pet : pacientes) {
			System.out.println(pet.getNome() + " (" + pet.getEspecie() + ") diz: " + pet.emitirSom());
			System.out.println("Ração diária: " + pet.calcularRacaoDiaria() + "g");
			System.out.println("---");
		}

		// ===== Aula 8 - Classes Abstratas =====
		System.out.println("\n - - - Testando a classe abstrata - - -");
		// Pet generico = new Pet("Coisa", "Generica");
		// ❌ Não compila: "Cannot instantiate the type Pet" -> não existe pet sem espécie
		Pet[] sala = new Pet[] { thor, pipoca, pet2 };
		for (Pet pet : sala) {
			System.out.println(pet.getNome() + ": " + pet.emitirSom());
		}

		// ===== Aula 9 - Interfaces =====
		System.out.println("\n - - - Campanha de vacinação (interface Vacinavel) - - -");
		System.out.println("Idade mínima para vacinar: " + Vacinavel.IDADE_MINIMA_VACINA_MESES + " meses");
		hemerson.setIdade(2.0);
		mingau.setIdade(1.5);
		pipoca.setIdade(0.1); // pouco mais de 1 mês, ainda não pode

		// Classes de hierarquias DIFERENTES (Pet e Tutor) tratadas pelo mesmo contrato
		Vacinavel[] fila = new Vacinavel[] { hemerson, mingau, pipoca, luiz };
		for (Vacinavel v : fila) {
			v.vacinar("Antirrábica");
		}
		hemerson.vacinar("V10");
		hemerson.vacinar(""); // inválido

		System.out.println("Vacinas do " + hemerson.getNome() + ": " + hemerson.getQuantidadeVacinas());
		System.out.println("Vacinas da " + pipoca.getNome() + ": " + pipoca.getQuantidadeVacinas());
		System.out.println("Vacinas do tutor " + luiz.getNome() + ": " + luiz.getQuantidadeVacinas());

		// Pássaro não assina o contrato, então não entra na fila:
		// Vacinavel v = mariaBraga; // não compila
		System.out.println(mariaBraga.getNome() + " é Vacinavel? " + (Vacinavel.class.isInstance(mariaBraga)));
		System.out.println(hemerson.getNome() + " é Pet? " + (hemerson instanceof Pet) + " | é Vacinavel? " + (hemerson instanceof Vacinavel));
	}

}
