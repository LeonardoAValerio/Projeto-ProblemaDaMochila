package main.projeto;

import main.knapsack.Item;

public class Projeto {
    private String nome;
    private Double valor;
    private Double retorno;

    public Projeto(String nome, Double valor, Double retorno) {
        this.nome = nome;
        this.valor = valor;
        this.retorno = retorno;
    }

    public Double getValor() {
        return valor;
    }

    public Double getRetorno() {
        return retorno;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", retorno=" + retorno +
                '}';
    }
}
