package model;

import java.time.LocalDate;

public class ContaCorrente {

    private double limite;
    private LocalDate dataVencimento;

    public double consultarLimite(){

    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
