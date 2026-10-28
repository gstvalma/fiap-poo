package br.com.fiapride.model;

// Passaro É UM Pet (calopsita, periquito, canário...)
public class Passaro extends Pet {

	private boolean asaCortada;

	public Passaro(String nome, Tutor tutor, boolean asaCortada) {
		super(nome, "Pássaro", tutor);
		this.asaCortada = asaCortada;
	}

	@Override
	public String emitirSom() {
		return "Piu piu!";
	}

	@Override
	public double calcularRacaoDiaria() {
		if (this.getPeso() <= 0) {
			return super.calcularRacaoDiaria();
		}
		// pássaro come cerca de 10% do próprio peso em sementes (peso em kg * 1000 * 0.10)
		return this.getPeso() * 100;
	}

	public boolean isAsaCortada() {
		return this.asaCortada;
	}

	public boolean podeVoarSolto() {
		// com a asa cortada ele não consegue voar, então é seguro soltar dentro de casa
		return !this.asaCortada;
	}

}
