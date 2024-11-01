public class Quarto {
    private int numero;
    private TipoQuarto tipo;
    private int capacidade;
    private double precoDiaria;
    private DisponibilidadeQuarto disponibilidade;

    public Quarto(int numero, TipoQuarto tipo, int capacidade, double precoDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.precoDiaria = precoDiaria;
        this.disponibilidade = DisponibilidadeQuarto.DISPONIVEL;
    }

    public int getNumero() { return numero; }
    public TipoQuarto getTipo() { return tipo; }
    public int getCapacidade() { return capacidade; }
    public double getPrecoDiaria() { return precoDiaria; }
    public DisponibilidadeQuarto getDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(DisponibilidadeQuarto disponibilidade) { this.disponibilidade = disponibilidade; }
}
