package main;

import main.knapsack.Item;
import main.knapsack.Knapsack;

import java.util.List;

public class Recurso extends Knapsack {
    private String name;

    public Recurso(int capacity) {
        super(capacity);
    }

    public Recurso(double capacity, List<Item> itens) {
        super(capacity, itens);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
