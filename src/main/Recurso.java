package main;

import main.knapsack.Item;
import main.knapsack.Knapsack;

import java.util.List;
import java.util.Scanner;

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

    public void alterarCapacidade() {
        System.out.println("Informe a nova capacidade: ");
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextDouble()) {
            double novaCapacidade = scanner.nextDouble();

            if (novaCapacidade > 0) {
                setCapacity(novaCapacidade);
                System.out.println("Capacidade alterada para: " + novaCapacidade);
            } else {
                System.out.println("A capacidade deve ser um valor positivo.");
            }
        } else {
            System.out.println("Entrada invalida. Por favor, insira um numero valido.");
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
