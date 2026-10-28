package br.com.fiapride.model;

// Passaro É UM Pet (calopsita, periquito, canário...)
public class Passaro extends Pet {

	private boolean asaCortada;

	public Passaro(String nome, Tutor tutor, boolean asaCortada) {
		super(nome, "Pássaro", tutor);
		this.asaCortada = asaCortada;
	}

	public boolean isAsaCortada() {
		return this.asaCortada;
	}

	public boolean podeVoarSolto() {
		// com a asa cortada ele não consegue voar, então é seguro soltar dentro de casa
		return !this.asaCortada;
	}

}
