package br.com.fiapride.model;

public class Pet{

	private String nome;
	private String especie;
	private double idade; //Idade em anos. 1 ano e seis meses, por exemplo, seriam 1.5
	private double peso; //Peso em kg

	// CONSTRUTOR PADRÃO: pet resgatado que chegou sem nenhuma informação
	public Pet() {
		this("Sem nome", "Não informada");
	}

	// Todo pet precisa nascer com nome e espécie
	public Pet(String nome, String especie) {
		this(nome, especie, 0);
	}

	// Construtor completo, os outros chamam este com this(...)
	public Pet(String nome, String especie, double idade) {
		this.setNome(nome);
		this.especie = especie;
		this.setIdade(idade);
	}

	public void fazerAniversario() {
		// Regra de negócio: nenhum pet passa dos 40 anos (nem papagaio vive tanto)
		if (this.idade + 1 > 40) {
			System.out.println("Erro: " + this.nome + " não pode passar dos 40 anos.");
			return;
		}
		this.setIdade(this.idade + 1);
		System.out.println("Parabéns " + this.nome + "! Agora tem " + this.idade + " anos.");
	}

	public void atualizarPeso(double novoPeso) {
		this.setPeso(novoPeso);
	}

	public int calcularIdadeEmMeses() {
		// O veterinário costuma usar a idade em meses para filhotes
		return (int) (this.idade * 12);
	}

	public double calcularRacaoDiaria() {
		// Sem peso cadastrado não tem como calcular a ração
		if (this.peso <= 0) {
			System.out.println("Aviso: cadastre o peso de " + this.nome + " antes de calcular a ração.");
			return 0;
		}
		// Regra geral: 20g de ração por kg
		return this.peso * 20;
	}

	// GETTERS (leitura)
	public String getNome() {
		return this.nome;
	}

	public String getEspecie() {
		return this.especie;
	}

	public double getIdade() {
		return this.idade;
	}

	public double getPeso() {
		return this.peso;
	}

	// SETTERS
	public void setNome(String nome) {
		// nome vazio não identifica ninguém na clínica
		if (nome == null || nome.trim().isEmpty()) {
			System.out.println("Erro: o nome do pet não pode ser vazio.");
			return;
		}
		this.nome = nome;
	}

	// Não existe setEspecie(): um cachorro não vira gato. A espécie só é definida no construtor.

	public void setIdade(double idade) {
		// Regra especial: idade entre 0 e 40 anos
		if (idade < 0 || idade > 40) {
			System.out.println("Erro: idade inválida (" + idade + "). Deve ser entre 0 e 40 anos.");
			return;
		}
		this.idade = idade;
	}

	// Privado: o peso só muda pelo atualizarPeso(), que é a ação de "pesar" o pet
	private void setPeso(double peso) {
		if (peso <= 0 || peso > 100) {
			System.out.println("Erro: peso inválido para " + this.nome + " (" + peso + " kg).");
			return;
		}
		this.peso = peso;
		System.out.println("Peso de " + this.nome + " atualizado para " + this.peso + " kg.");
	}

}
