import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciarReservas implements GerenciadorReservas {
    private List<Reserva> reservas;
    private List<Quarto> quartos;

    public GerenciarReservas() {
        this.reservas = new ArrayList<>();
        this.quartos = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void visualizarQuartos(){
        if (quartos.isEmpty()){
            System.out.println("Não há nenhum quarto disponível");
        }else {
            for (Quarto quarto : quartos) {
                quarto.mostrarQuartos();
            }
        }
    }

    @Override
    public Reserva criarReserva(Hospede hospede, int numeroQuarto,
                                LocalDate dataEntrada, LocalDate dataSaida,
                                int numeroHospedes) throws ReservaException {
        if (hospede == null || dataEntrada == null || dataSaida == null) {
            throw new ReservaException("Por favor, preencha todos os campos obrigatórios.");
        }

        if (dataEntrada.isAfter(dataSaida)) {
            throw new ReservaException("Data de check-out deve ser posterior à data de check-in.");
        }

        if (LocalDate.now().isAfter(dataEntrada)) {
            throw new ReservaException("Data de entrada não pode ser anterior à data atual.");
        }

        Quarto quartoSelecionado = quartos.stream()
                .filter(q -> q.getNumero() == numeroQuarto)
                .findFirst()
                .orElseThrow(() -> new ReservaException("Quarto não encontrado."));

        if (numeroHospedes > quartoSelecionado.getCapacidade()) {
            throw new ReservaException("Número de hóspedes excede a capacidade do quarto.");
        }

        if (!verificarDisponibilidade(quartoSelecionado, dataEntrada, dataSaida)) {
            throw new ReservaException("Quarto não está disponível para o período selecionado.");
        }

        Reserva novaReserva = new Reserva(hospede, quartoSelecionado, dataEntrada, dataSaida, numeroHospedes);
        reservas.add(novaReserva);
        return novaReserva;
    }

    @Override
    public void cancelarReserva(int idReserva) throws ReservaException {
        Reserva reserva = reservas.stream()
                .filter(r -> r.getId() == idReserva && r.isAtiva())
                .findFirst()
                .orElseThrow(() -> new ReservaException("Reserva não encontrada ou já cancelada."));

        reserva.setAtiva(false);
    }

    @Override
    public boolean verificarDisponibilidade(Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida) {
        return reservas.stream()
                .filter(r -> r.isAtiva() && r.getQuarto().getNumero() == quarto.getNumero())
                .noneMatch(r ->
                        (dataEntrada.isBefore(r.getDataSaida()) || dataEntrada.isEqual(r.getDataSaida())) &&
                                (dataSaida.isAfter(r.getDataEntrada()) || dataSaida.isEqual(r.getDataEntrada()))
                );
    }

    @Override
    public List<Quarto> listarQuartosDisponiveis(LocalDate dataEntrada, LocalDate dataSaida) {
        return quartos.stream()
                .filter(q -> verificarDisponibilidade(q, dataEntrada, dataSaida))
                .collect(Collectors.toList());
    }
}
