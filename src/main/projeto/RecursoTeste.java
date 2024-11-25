package main.projeto;

public class RecursoTeste {
    public static void main(String[] args) {
        Recurso recurso = new Recurso(500);
        recurso.addProjeto(new Projeto("Projeto de IA",100.0, 110.0));
        recurso.addProjeto(new Projeto("Projeto de Oléo",500.0, 200.0));
        recurso.addProjeto(new Projeto("Projeto de Padaria",300.0, 300.0));
        recurso.addProjeto(new Projeto("Projeto de Vendas",200.0, 400.0));
        recurso.addProjeto(new Projeto("Projeto de Customizações",250.0, 200.0));

        RecursoSolver solver = new RecursoSolver();
        RecursoResultado resultado = solver.solve(recurso);

        for (Projeto projeto : resultado.projetosSelecionados) {
            System.out.println(projeto);
        }
        System.out.println("Total investido: " + resultado.totalInvestido);
        System.out.println("Total retornado: " + resultado.totalRetornado);
    }
}
