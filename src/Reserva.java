import java.time.LocalDate;

public class Reserva {
    private static int contadorId = 1;
    private int id;
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private int numeroHospedes;
    private boolean ativa;

    public Reserva(Hospede hospede, Quarto quarto, LocalDate dataEntrada,
                   LocalDate dataSaida, int numeroHospedes) {
        this.id = contadorId++;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.numeroHospedes = numeroHospedes;
        this.ativa = true;
    }

    public int getId() { return id; }
    public Hospede getHospede() { return hospede; }
    public Quarto getQuarto() { return quarto; }
    public LocalDate getDataEntrada() { return dataEntrada; }
    public LocalDate getDataSaida() { return dataSaida; }
    public int getNumeroHospedes() { return numeroHospedes; }
    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }
}