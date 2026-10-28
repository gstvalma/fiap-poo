package br.com.fiapride.model;

// Contrato para tudo que pode tomar vacina.
// Não coloquei isso na classe Pet porque nem todo pet é vacinado (pássaro não toma
// antirrábica, por exemplo) e porque o Tutor, que não é Pet, também toma vacina.
public interface Vacinavel {

    // Idade mínima (em meses) para um animal tomar a primeira vacina
    int IDADE_MINIMA_VACINA_MESES = 2;

    void vacinar(String nomeVacina);

    int getQuantidadeVacinas();
}
