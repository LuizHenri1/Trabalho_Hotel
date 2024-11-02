package hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Hotel {
    private ArrayList<Quarto> quartos;

    public Hotel() {
        this.quartos = new ArrayList<>();
    }

    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void checkIn(int numeroQuarto, Hospede hospede) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto && quarto.getStatus().equalsIgnoreCase("disponível")) {
                quarto.setStatus("ocupado");
                quarto.setHospede(hospede);
                System.out.println("Check-in realizado para o hóspede " + hospede.getNome() + " no quarto " + numeroQuarto);
                return;
            }
        }
        System.out.println("Quarto " + numeroQuarto + " não está disponível para check-in.");
    }

    public void checkOut(int numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto && quarto.getStatus().equalsIgnoreCase("ocupado")) {
                long diasEstadia = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
                double valorTotal = diasEstadia * quarto.getPreco();
                System.out.println("Check-out realizado para o hóspede " + quarto.getHospede().getNome() + " do quarto " + numeroQuarto);
                System.out.println("Total da estadia: R$" + valorTotal);
                
                quarto.liberarQuarto();
                return;
            }
        }
        System.out.println("Quarto " + numeroQuarto + " não está ocupado.");
    }

    public void listarQuartosDisponiveis() {
        boolean temDisponiveis = false;

        for (Quarto quarto : quartos) {
            if (quarto.getStatus().equalsIgnoreCase("disponível")) {
                System.out.println("Número: " + quarto.getNumero() + ", Tipo: " + quarto.getTipo()
                        + ", Capacidade: " + quarto.getCapacidade() + ", Preço: R$" + quarto.getPreco()
                        + ", Status: " + quarto.getStatus());
                temDisponiveis = true;
            }
        }

        if (!temDisponiveis) {
            System.out.println("Não há quartos disponíveis no momento.");
        }
    }
}
