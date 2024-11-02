package hotel;

public class Quarto {
    private int numero;
    private String tipo;
    private int capacidade;
    private double preco;
    private String status;
    private Hospede hospede;  // Hóspede atual

    public Quarto(int numero, String tipo, int capacidade, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.preco = preco;
        this.status = "disponível";  // Status inicial
        this.hospede = null;
    }

    // Getters e Setters

    public int getNumero() {
        return numero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public double getPreco() {
        return preco;
    }

    public void liberarQuarto() {
        this.status = "disponível";
        this.hospede = null;
    }
}
