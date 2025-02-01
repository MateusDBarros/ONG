package mb.projeto.ONG.doacoes.Model;

import java.time.LocalDateTime;

public class Doacao {

    private long doacaoID;
    private long doadorID;
    private long ongID;
    private double valor;
    private LocalDateTime data;

    public Doacao() {
    }

    public Doacao(long doacaoID, long ongID, long doadorID, LocalDateTime data, double valor) {
        this.doacaoID = doacaoID;
        this.data = data;
        this.valor = valor;
        this.ongID = ongID;
        this.doadorID = doadorID;
    }

    public long getDoacaoID() {
        return doacaoID;
    }

    public void setDoacaoID(long doacaoID) {
        this.doacaoID = doacaoID;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getOngID() {
        return ongID;
    }

    public void setOngID(long ongID) {
        this.ongID = ongID;
    }

    public long getDoadorID() {
        return doadorID;
    }

    public void setDoadorID(long doadorID) {
        this.doadorID = doadorID;
    }
}
