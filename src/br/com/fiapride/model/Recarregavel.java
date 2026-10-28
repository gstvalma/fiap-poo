package br.com.fiapride.model;

// 'interface' em vez de 'class': é um CONTRATO de comportamento
// Todo método é public abstract por padrão (não precisa escrever)
public interface Recarregavel {

    // Constantes (public static final por padrão)
    int CARGA_MAXIMA = 100;
    int CARGA_MINIMA = 0;

    // Quem implementa Recarregavel É OBRIGADO a ter este método
    void recarregar(int percentual);
}
