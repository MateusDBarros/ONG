package mb.projeto.ONG.ongs.Model;

public class Ong {

    private long ong_id;
    private String nome;
    private Categoria categoria;
    private double saldo;

    public Ong() {
    }

    public Ong(long ongID, String nome, Categoria categoria, double saldo) {
        this.ong_id = ongID;
        this.saldo = saldo;
        this.categoria = categoria;
        this.nome = nome;
    }

    public long getOng_id() {
        return ong_id;
    }

    public void setOng_id(long ong_id) {
        this.ong_id = ong_id;
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
