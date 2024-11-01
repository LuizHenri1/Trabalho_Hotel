package Code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Estadia {
    private String quarto;
    private Date dataEntrada;
    private Date dataSaida;

    public Estadia(String quarto, Date dataEntrada, Date dataSaida) {
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public String getQuarto() {
        return quarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    @Override
    public String toString() {
        return "Quarto: " + quarto + ", Entrada: " + dataEntrada + ", Saída: " + dataSaida;
    }
}