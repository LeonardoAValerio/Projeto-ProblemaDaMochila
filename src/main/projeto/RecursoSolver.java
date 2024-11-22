package main.projeto;

import main.knapsack.Item;
import main.knapsack.Knapsack;
import main.knapsack.KnapsackState;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class RecursoSolver {
    // Define um limite para a profundidade e para o tamanho da fila de prioridade para evitar o consumo excessivo de memória.
    private static final int MAX_QUEUE_SIZE = 1000;  // Limite de tamanho da fila de prioridade
    private static final int MAX_DEPTH = 50;         // Limite de profundidade de expansão

    public RecursoResultado solve(Recurso recurso) {
        List<Projeto> projetos = recurso.getProjetos();
        double capacity = recurso.getOrcamento();

        // Fila de prioridade para armazenar estados
        PriorityQueue<RecursoResultado> openList = new PriorityQueue<>(Comparator.comparingDouble(this::calculatePriority).reversed());

        RecursoResultado estadoInicial = new RecursoResultado();
        openList.add(estadoInicial);
        RecursoResultado melhorEstado = estadoInicial;

        while (!openList.isEmpty() && openList.size() <= MAX_QUEUE_SIZE) {
            RecursoResultado atual = openList.poll();

            // Atualiza o melhor estado se necessário
            if (atual.getTotalRetornado() > melhorEstado.getTotalRetornado() && atual.getTotalInvestido() <= capacity) {
                melhorEstado = atual;
            }

            // Expande o estado atual se não tiver atingido o limite de profundidade
            if (atual.getProjetosSelecionados().size() < MAX_DEPTH) {
                for (Projeto projeto : projetos) {
                    if (!atual.projetosSelecionados.contains(projeto)) {
                        RecursoResultado novoEstado = new RecursoResultado(atual.projetosSelecionados);
                        novoEstado.addProjeto(projeto);

                        // Adiciona o novo estado à fila apenas se ele respeitar o limite de capacidade
                        // e tiver potencial para superar a melhor solução atual
                        if (novoEstado.getTotalInvestido() <= capacity && calculateBound(novoEstado, projetos, capacity) > melhorEstado.getTotalRetornado()) {
                            openList.add(novoEstado);

                            // Limita o tamanho da fila de prioridade para evitar estouro de memória
                            if (openList.size() > MAX_QUEUE_SIZE) {
                                openList.poll();
                            }
                        }
                    }
                }
            }
        }

        return melhorEstado;
    }

    private double calculatePriority(RecursoResultado estado) {
        return estado.getTotalRetornado() / (estado.getTotalInvestido() + 1e-5); // Evita divisão por zero
    }

    private double calculateBound(RecursoResultado state, List<Projeto> projetos, double capacity) {
        double bound = state.getTotalRetornado();
        double remainingCapacity = capacity - state.getTotalInvestido();

        for (Projeto projeto : projetos) {
            if (!state.projetosSelecionados.contains(projeto)) {
                if (projeto.getValor() <= remainingCapacity) {
                    bound += projeto.getRetorno();
                    remainingCapacity -= projeto.getValor();
                } else {
                    bound += projeto.getRetorno() * (remainingCapacity / projeto.getValor());
                    break;
                }
            }
        }

        return bound;
    }
}
