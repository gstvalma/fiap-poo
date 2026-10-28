package br.com.fiapride.model;

// Gato É UM Pet
public class Gato extends Pet {

	private boolean castrado;

	public Gato(String nome, Tutor tutor, boolean castrado) {
		super(nome, "Gato", tutor);
		this.castrado = castrado;
	}

	// Construtor padrão: gato resgatado, sem tutor e ainda não castrado
	public Gato() {
		this("Sem nome", null, false);
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
