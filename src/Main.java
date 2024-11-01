import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            GerenciarReservas gerenciador = new GerenciarReservas();

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