package mb.projeto.ONG.Ongs.Model;

public class Ong {

    private long ongID;
    private String nome;
    private Categoria categoria;
    private double saldo;

    public Ong() {
    }

    public Ong(long ongID, String nome, Categoria categoria, double saldo) {
        this.ongID = ongID;
        this.saldo = saldo;
        this.categoria = categoria;
        this.nome = nome;
    }

    public long getOngID() {
        return ongID;
    }

    public void setOngID(long ongID) {
        this.ongID = ongID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
