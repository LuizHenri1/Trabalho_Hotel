import java.time.LocalDate;
import java.util.List;

public interface GerenciadorReservas {

    Reserva criarReserva(Hospede hospede, int numeroQuarto, LocalDate dataEntrada,
                         LocalDate dataSaida, int numeroHospedes) throws ReservaException;

    void cancelarReserva(int idReserva) throws ReservaException;

    boolean verificarDisponibilidade(Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida);

    List<Quarto> listarQuartosDisponiveis(LocalDate dataEntrada, LocalDate dataSaida);
}
