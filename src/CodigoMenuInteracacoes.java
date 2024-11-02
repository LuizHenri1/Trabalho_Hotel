
// AQUI NESTE ARQUIVO TENTAREI COLOCAR TODOS OS MÉTODOS QUE
// REQUEREM INPUT DO USUÁRIO AFIM DE NÃO POLUIR O MENU DO MAIN
// - Vitorio

import java.util.Scanner;

public class CodigoMenuInteracacoes {
    public void adicionarQuarto() {
        Scanner scanner = new Scanner(System.in);
        GerenciarReservas gerenciador = new GerenciarReservas();

        System.out.println("Qual o número do quarto que você quer adicionar?");
        int quartoNum = scanner.nextInt();
        System.out.println("Qual o tipo do quarto?");
        System.out.println("[1] Quarto de Solteiro" +
                "\n[2] Quarto de Casal" +
                "\n[3] Suite");
        int tipoQuartoEscolha = scanner.nextInt();
        TipoQuarto tipoQuarto = null;

        switch(tipoQuartoEscolha) {
            case 1:
                tipoQuarto = TipoQuarto.SOLTEIRO;
                break;
            case 2:
                tipoQuarto = TipoQuarto.CASAL;
                break;
            case 3:
                tipoQuarto = TipoQuarto.SUITE;
                break;
            default:
                System.out.println("Opção inválida. Escolha um tipo de quarto válido.");
                return;
        }

        System.out.println("Qual a capacidade do quarto?");
        int capacidade = scanner.nextInt();
        System.out.println("Qual o preço da diária?");
        float precoDiaria = scanner.nextFloat();

        System.out.println("Quarto adicionado com sucesso!");
        gerenciador.adicionarQuarto(new Quarto(quartoNum, tipoQuarto, capacidade, precoDiaria));
    }
}