package mb.projeto.ONG.doacoes.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class Doacao {

    private long doacaoID;
    private long doadorID;
    private long ong_id;
    private double valor;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime data;

    public Doacao() {
    }

    public Doacao(long doacaoID, long ongID, long doadorID, LocalDateTime data, double valor) {
        this.doacaoID = doacaoID;
        this.data = data;
        this.valor = valor;
        this.ong_id = ongID;
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

    public long getOng_id() {
        return ong_id;
    }

    public void setOng_id(long ong_id) {
        this.ong_id = ong_id;
    }

    public long getDoadorID() {
        return doadorID;
    }

    public void setDoadorID(long doadorID) {
        this.doadorID = doadorID;
    }
}
