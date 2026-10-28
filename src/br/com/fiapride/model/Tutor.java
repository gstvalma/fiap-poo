package br.com.fiapride.model;

// O dono (responsável) do pet
// Tutor não é Pet, mas também é Vacinavel (ex: a clínica faz campanha de antirrábica pros donos)
public class Tutor implements Vacinavel {

	private String nome;
	private String telefone;
	private int quantidadeVacinas;

	public Tutor(String nome, String telefone) {
		this.nome = nome;
		this.atualizarTelefone(telefone);
	}

	public String getNome() {
		return this.nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void atualizarTelefone(String novoTelefone) {
		// Regra: a clínica precisa de um telefone válido para avisar o tutor
		if (novoTelefone == null || novoTelefone.trim().length() < 8) {
			System.out.println("Erro: telefone inválido para o tutor " + this.nome);
			return;
		}
		this.telefone = novoTelefone;
	}

	@Override
	public void vacinar(String nomeVacina) {
		if (nomeVacina == null || nomeVacina.trim().isEmpty()) {
			System.out.println("Erro: informe o nome da vacina.");
			return;
		}
		// adulto não tem a regra de idade mínima
		this.quantidadeVacinas++;
		System.out.println("💉 Tutor(a) " + this.nome + " tomou a vacina " + nomeVacina + ". Total: " + this.quantidadeVacinas);
	}

	@Override
	public int getQuantidadeVacinas() {
		return this.quantidadeVacinas;
	}

}
