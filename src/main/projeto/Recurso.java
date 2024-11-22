package main.projeto;

import main.knapsack.Item;
import main.knapsack.Knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recurso {
    private double orcamento;
    private List<Projeto> projetos;


    public Recurso(double orcamento) {
        this.orcamento = orcamento;
        this.projetos = new ArrayList<>();
    }

    public Recurso(double orcamento, List<Projeto> projetos) {
        this.orcamento = orcamento;
        this.projetos = projetos;
    }

    public void addProjeto(Projeto projeto){
        this.projetos.add(projeto);
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }
}
