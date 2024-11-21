package main;

import java.util.Scanner;

public class Sistema {
    private IoT iot;
    private Recurso recurso;
    private Projeto projeto;

    public Sistema() {
        iot = new IoT();
        recurso = new Recurso(0);
    }

    public void iniciar() {
        Integer option;
        for (; ; ) {
            System.out.println("Sistema de Projetos/Recursos");
            System.out.println("[1] - Apresentar Melhores Projetos");
            System.out.println("[2] - Editar projeto");
            System.out.println("[3] - Adicionar projeto");
            System.out.println("[4] - Remover projeto");
            System.out.println("[0] - Sair");
            System.out.println("Informe a opção que deseja: ");
            option = iot.inputInteger();
            if (option == 1) {
                menuMelhoresProjetos();
            } else if (option == 2) {
                //Função menu Editar Projetos
            } else if (option == 3) {
                adicionarProjetos();
            } else if (option == 4) {
                //Função menu Remover Projetos
            } else if (option == 0) {
                System.out.println("Até mais!");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    private void menuMelhoresProjetos() {
        Integer option;
        for (; ; ) {
            System.out.printf("Valor da recurso atual: %.2f\n", recurso.getCapacity());
            System.out.println("[1] - Apresentar melhores projetos");
            System.out.println("[2] - Alterar recurso Atual");
            System.out.println("[0] - Sair");
            System.out.println("Informe a opção que deseja: ");
            option = iot.inputInteger();
            if (option == 1) {
                //Função que apresenta os melhores projetos escolhidos
            } else if (option == 2) {
                recurso.alterarCapacidade();
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    private void adicionarProjetos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do projeto: ");
        String descricao = scanner.nextLine();

        System.out.println("Digite o valor do projeto: ");
        double valor = scanner.nextDouble();
        if (valor <= 0) {
            System.out.println("O valor deve ser maior que zero!");
            return;
        }

        System.out.println("Digite o retorno do projeto: ");
        double retorno = scanner.nextDouble();
        if (retorno <= 0) {
            System.out.println("O retorno deve ser maior que zero!");
            return;
        }

        recurso.addItem(new Projeto("investimento melhor", 150.0,  950.0));
    }
}
