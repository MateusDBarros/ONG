package mb.projeto.ONG.ongs.Repository;

import mb.projeto.ONG.ongs.Model.Categoria;
import mb.projeto.ONG.ongs.Model.Ong;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OngRepository {

    private final JdbcTemplate jdbc;

    public OngRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Cadastrar nova ong
    public void novaOng(Ong ong) {
        String sql = "INSERT INTO OngTable (nome, categoria, saldo) VALUES (?,?,?)";
        jdbc.update(sql, ong.getNome(), ong.getCategoria(), ong.getSaldo());
    }

    // Vizualizar ongs
    public List<Ong> listarOngs() {
        String sql = "SELECT * FROM OngTable";
        return jdbc.query(sql, (rs, rowNum) ->
                new Ong(
                        rs.getLong("ongID"),
                        rs.getString("nome"),
                        Categoria.valueOf(rs.getString("categoria")),
                        rs.getDouble("saldo")
                ));
    }

    // Vizualizar ong por ID
    public Ong findById(long id) {
        String sql = "SELECT nome, categoria, saldo FROM OngTable WHERE ongID = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Ong (
                        rs.getLong("ongID"),
                        rs.getString("nome"),
                        Categoria.valueOf(rs.getString("categoria")),
                        rs.getDouble("saldo")
                ));
    }

    // Atualizar ong
    public void updateOng(Ong ong) {
        String sql = "UPDATE OngTable SET nome = ?, categoria = ?, saldo = ? WHERE ongID = ?";
        jdbc.update(sql, ong.getNome(), ong.getCategoria(), ong.getSaldo(),ong.getOngID());
    }

    // Deletar ong
    public void deleteOng(long id) {
        String sql = "DELETE FROM OngTable WHERE ongID = ? ";
        jdbc.update(sql, id);
    }

    // Checar a existencia
    public boolean existe(long id) {
        String sql = "SELECT COUNT(*) FROM OngTable WHERE ongID = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
}
