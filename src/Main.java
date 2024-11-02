import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciarReservas gerenciador = new GerenciarReservas();
        CodigoMenuInteracacoes menuInteracacoes = new CodigoMenuInteracacoes(gerenciador);
        Hospede_Estadia hospedes = new Hospede_Estadia();
        Scanner scanner = new Scanner(System.in);

        try {

            boolean menuExecutando = true;

            while (menuExecutando) {
                System.out.println("\n================================================");
                System.out.println("Bem-Vindo ao Sistema de Gerenciamento do HotelXYZ!");
                System.out.println("==================================================");

                System.out.println("\n=== Gerenciamento de Quartos ===");
                System.out.println("[1] Cadastrar novos Quartos");
                System.out.println("[2] Visualizar quartos disponíveis");
                System.out.println("[3] Atualizar o status dos quartos");

                System.out.println("\n=== Gerenciamento de Hóspedes ===");
                System.out.println("[4] Cadastrar Novos Hóspedes");
                System.out.println("[5] Visualizar histórico de estadias");
                System.out.println("[6] Editar informações dos hóspedes");

                System.out.println("\n=== Gerenciamento de Reservas ===");
                System.out.println("[7] Criar reservas");
                System.out.println("[8] Cancelar reservas");
                System.out.println("[9] Verificar disponibilidade de quartos");

                System.out.println("\n=== Gerenciamento de Funcionários ===");
                System.out.println("[10] Cadastrar funcionários");
                System.out.println("[11] Editar informações dos funcionários");
                System.out.println("[12] Mostrar horas de trabalho e calcular salário dos funcionários");

                System.out.println("\n[13] Sair");
                System.out.println("===========================================");
                System.out.print("Escolha uma opção: ");

                int escolhaMenu = scanner.nextInt();
                scanner.nextLine();

                switch (escolhaMenu) {
                    case 1:
                        //Aqui ficará o comando de cadastrar novos quartos
                        menuInteracacoes.adicionarQuarto();
                        break;
                    case 2:
                        //Aqui ficará o comando de visualizar quartos disponíveis
                        gerenciador.visualizarQuartos();
                        break;
                    case 3:
                        // Aqui ficará o comando de atualizar o status dos quartos
                        break;
                    case 4:
                        // Aqui ficará o comando de cadastrar novos hospedes
                        break;
                    case 5:
                        hospedes.listarHistoricoDeEstadias();
                        break;
                    case 6:
                        // Aqui ficará o comando de editar informações dos hospedes
                        break;
                    case 7:
                        // Aqui ficará o comando de criar reservas
                        break;
                    case 8:
                        // Aqui ficará o comando de cancelar reservas
                        break;
                    case 9:
                        // Aqui ficará o comando de verificar disponibilidade de quartos
                        break;
                    case 10:
                        // Aqui ficará o comando de cadastrar funcionarios
                        break;
                    case 11:
                        // Aqui ficará o comando de editar informações dos funcionários
                        break;
                    case 12:
                        // Aqui ficará o comando de mostrar horas de trabalho e calcular salário dos funcionários
                        break;
                    case 13:
                        System.out.println("Saindo...");
                        menuExecutando = false;
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }


            // Códigos de teste
            // TODO: REMOVER DEPOIS
            gerenciador.adicionarQuarto(new Quarto(101, TipoQuarto.SOLTEIRO, 1, 100.0));
            gerenciador.adicionarQuarto(new Quarto(102, TipoQuarto.CASAL, 2, 200.0));

            Hospede hospede = new Hospede("João Silva", "123.456.789-00", "(11) 99999-9999");

            LocalDate dataEntrada = LocalDate.now().plusDays(1);
            LocalDate dataSaida = LocalDate.now().plusDays(3);

            Reserva reserva = gerenciador.criarReserva(hospede, 101, dataEntrada, dataSaida, 1);
            System.out.println("Reserva criada com sucesso! ID: " + reserva.getId());

            gerenciador.cancelarReserva(reserva.getId());
            System.out.println("Reserva cancelada com sucesso!");

        } catch (ReservaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
