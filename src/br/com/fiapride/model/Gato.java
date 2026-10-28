package br.com.fiapride.model;

// Gato É UM Pet
public class Gato extends Pet implements Vacinavel {

	private boolean castrado;
	private int quantidadeVacinas;

	public Gato(String nome, Tutor tutor, boolean castrado) {
		super(nome, "Gato", tutor);
		this.castrado = castrado;
	}

	// Construtor padrão: gato resgatado, sem tutor e ainda não castrado
	public Gato() {
		this("Sem nome", null, false);
	}

	// ===== Aula 9 - Interface Vacinavel =====
	@Override
	public void vacinar(String nomeVacina) {
		if (nomeVacina == null || nomeVacina.trim().isEmpty()) {
			System.out.println("Erro: informe o nome da vacina.");
			return;
		}
		// Regra: gatinho muito novo ainda não pode ser vacinado
		if (this.calcularIdadeEmMeses() < Vacinavel.IDADE_MINIMA_VACINA_MESES) {
			System.out.println("Erro: " + this.getNome() + " tem menos de " + Vacinavel.IDADE_MINIMA_VACINA_MESES + " meses, ainda não pode tomar a " + nomeVacina + ".");
			return;
		}
		this.quantidadeVacinas++;
		System.out.println("💉 " + this.getNome() + " tomou a vacina " + nomeVacina + ". Total: " + this.quantidadeVacinas);
	}

	@Override
	public int getQuantidadeVacinas() {
		return this.quantidadeVacinas;
	}

	@Override
	public String emitirSom() {
		return "Miau!";
	}

	@Override
	public double calcularRacaoDiaria() {
		if (this.getPeso() <= 0) {
			return super.calcularRacaoDiaria();
		}
		// gato come uns 15g por kg
		return this.getPeso() * 15;
	}

	public boolean isCastrado() {
		return this.castrado;
	}

	// Não tem setCastrado(false): não tem como "descastrar" um gato
	public void castrar() {
		if (this.castrado) {
			System.out.println("Erro: " + this.getNome() + " já é castrado.");
			return;
		}
		this.castrado = true;
		System.out.println(this.getNome() + " foi castrado com sucesso.");
	}

}
