package br.com.fiapride.model;

// Cachorro É UM Pet
public class Cachorro extends Pet implements Vacinavel {

	private String porte; // P, M ou G
	private int quantidadeVacinas;

	public Cachorro(String nome, Tutor tutor, String porte) {
		// a espécie já é fixa, quem chama não precisa informar
		super(nome, "Cachorro", tutor);
		this.setPorte(porte);
	}

	// Construtor padrão: cachorro resgatado sem nome e sem tutor (porte médio por padrão)
	public Cachorro() {
		this("Sem nome", null, "M");
	}

	// ===== Aula 9 - Interface Vacinavel =====
	@Override
	public void vacinar(String nomeVacina) {
		if (nomeVacina == null || nomeVacina.trim().isEmpty()) {
			System.out.println("Erro: informe o nome da vacina.");
			return;
		}
		// Regra: filhote muito novo ainda não pode ser vacinado
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
