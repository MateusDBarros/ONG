package mb.projeto.ONG.doadores.Model;

public class Doador {
    private long doadorID;
    private String nome;

    public Doador() {
    }

    public Doador(long doadorID, String nome) {
        this.doadorID = doadorID;
        this.nome = nome;
    }

    public long getDoadorID() {
        return doadorID;
    }

    public void setDoadorID(long doadorID) {
        this.doadorID = doadorID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
