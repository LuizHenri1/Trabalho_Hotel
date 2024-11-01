import java.util.ArrayList;
import java.util.List;

class Hospede_Estadia {
    private String nome;
    private List<Estadia> estadias;

    public Hospede_Estadia(String nome) {
        this.nome = nome;
        this.estadias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarEstadia(Estadia estadia) {
        estadias.add(estadia);
    }

    public void listarHistoricoDeEstadias() {
        System.out.println("Histórico de estadias de " + nome + ":");
        for (Estadia estadia : estadias) {
            System.out.println(estadia);
        }
    }
}
