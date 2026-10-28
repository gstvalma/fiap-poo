package br.com.fiapride.model;

public class Pet{

	public String nome;
	public String especie;
	public double idade; //Idade em anos. 1 ano e seis meses, por exemplo, seriam 1.5
	public double peso; //Peso em kg

	public void fazerAniversario() {
		// Regra de negócio: nenhum pet passa dos 40 anos (nem papagaio vive tanto)
		if (this.idade + 1 > 40) {
			System.out.println("Erro: " + this.nome + " não pode passar dos 40 anos.");
			return;
		}
		this.idade += 1;
		System.out.println("Parabéns " + this.nome + "! Agora tem " + this.idade + " anos.");
	}

	public void atualizarPeso(double novoPeso) {
		// Regra de negócio: o peso precisa ser positivo e realista
		if (novoPeso <= 0 || novoPeso > 100) {
			System.out.println("Erro: peso inválido para " + this.nome + " (" + novoPeso + " kg).");
			return;
		}
		this.peso = novoPeso;
		System.out.println("Peso de " + this.nome + " atualizado para " + this.peso + " kg.");
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

}
