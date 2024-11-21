package main;

import main.knapsack.Item;

import java.util.Scanner;

public class Projeto extends Item {
    private String name;
    private static Recurso recurso;

    public Projeto(String descricao, Double valor, Double retorno) {
        super(valor, retorno);
        this.name = descricao;
        if (recurso == null) {
            recurso = new Recurso(0);
        }

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