package br.com.fiapride.model;

// Cachorro É UM Pet
public class Cachorro extends Pet {

	private String porte; // P, M ou G

	public Cachorro(String nome, Tutor tutor, String porte) {
		// a espécie já é fixa, quem chama não precisa informar
		super(nome, "Cachorro", tutor);
		this.setPorte(porte);
	}

	public String getPorte() {
		return this.porte;
	}

	private void setPorte(String porte) {
		if (porte != null && (porte.equals("P") || porte.equals("M") || porte.equals("G"))) {
			this.porte = porte;
		} else {
			System.out.println("Erro: porte inválido (" + porte + "). Use P, M ou G.");
		}
	}

}
