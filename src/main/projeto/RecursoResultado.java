package main.projeto;

import java.util.ArrayList;
import java.util.List;

public class RecursoResultado {
    protected final List<Projeto> projetosSelecionados;
    protected double totalInvestido;
    protected double totalRetornado;

    public RecursoResultado() {
        this.projetosSelecionados = new ArrayList<>();
        this.totalInvestido = 0.0;
        this.totalRetornado = 0.0;
    }

    public RecursoResultado(List<Projeto> projetosSelecionados) {
        this.projetosSelecionados = new ArrayList<>(projetosSelecionados);
        for (Projeto projeto : projetosSelecionados) {
            this.totalInvestido += projeto.getValor();
            this.totalRetornado += projeto.getRetorno();
        }
    }

    public void addProjeto(Projeto projeto) {
        projetosSelecionados.add(projeto);
        totalInvestido += projeto.getValor();
        totalRetornado += projeto.getRetorno();
    }

    public double getTotalInvestido() {
        return totalInvestido;
    }

    public double getTotalRetornado() {
        return totalRetornado;
    }

    public List<Projeto> getProjetosSelecionados() {
        return projetosSelecionados;
    }

    public double heuristic(double capacity) {
        return capacity - totalInvestido;
    }


}
