package br.com.fiapride.model;

// Cachorro É UM Pet
public class Cachorro extends Pet {

	private String porte; // P, M ou G

	public Cachorro(String nome, Tutor tutor, String porte) {
		// a espécie já é fixa, quem chama não precisa informar
		super(nome, "Cachorro", tutor);
		this.setPorte(porte);
	}

	// Construtor padrão: cachorro resgatado sem nome e sem tutor (porte médio por padrão)
	public Cachorro() {
		this("Sem nome", null, "M");
	}

	@Override
	public String emitirSom() {
		return "Au Au!";
	}

	@Override
	public double calcularRacaoDiaria() {
		// sem peso, reaproveito o aviso da mãe
		if (this.getPeso() <= 0) {
			return super.calcularRacaoDiaria();
		}
		// cachorro grande come proporcionalmente menos por kg
		if ("G".equals(this.porte)) {
			return this.getPeso() * 15;
		}
		return this.getPeso() * 25;
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
