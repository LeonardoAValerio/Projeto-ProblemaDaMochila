package main;

import main.knapsack.Item;

public class Projeto extends Item {
    private String name;

    public Projeto(String descricao, Double valor, Double retorno) {
        super(valor, retorno);
        this.name = descricao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "descricao='" + name + '\'' +
                "valor='" + this.getWeight() + '\'' +
                "retorno='" + this.getValue() + '\'' +
                '}';
    }
}
