package main;

import main.knapsack.Item;
import main.knapsack.KnapsackSolver;
import main.knapsack.KnapsackSolverBacktracking;
import main.knapsack.KnapsackState;

public class Main {
    public static void main(String[] args) {
        Recurso recurso1 = new Recurso(200);
        recurso1.addItem(new Projeto("Investimento", 200.0, 300.0));
        recurso1.addItem(new Projeto("Investimento bolsa", 190.0, 320.0));
        recurso1.addItem(new Projeto("Investimento Legal", 100.0, 40.0));
        recurso1.addItem(new Projeto("Investimento bolsa", 50.0, 130.0));
        recurso1.addItem(new Projeto("Investimento bolsa", 150.0, 200.0));
        recurso1.getItems().forEach(item -> System.out.println(item));

        KnapsackSolver solver = new KnapsackSolver();
        KnapsackState bestState = solver.solve(recurso1);
        // Exibir os resultados
        System.out.println("Itens selecionados para a mochila:");
        for (Item item : bestState.getItemsSelected()) {
            System.out.printf("Peso: %.2f, Valor: %.2f%n", item.getWeight(), item.getValue());
        }
        System.out.printf("Peso total: %.2f%n", bestState.getTotalWeight());
        System.out.printf("Valor total: %.2f%n", bestState.getTotalValue());
    }
}