package br.com.fiapride.model;

// O dono (responsável) do pet
public class Tutor {

	private String nome;
	private String telefone;

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

}
