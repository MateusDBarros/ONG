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
        String sql = "INSERT INTO ong_table (nome, categoria, saldo) VALUES (?,?,?)";
        jdbc.update(sql, ong.getNome(), ong.getCategoria().name(), ong.getSaldo());
    }

    // Vizualizar ongs
    public List<Ong> listarOngs() {
        String sql = "SELECT * FROM ong_table";
        return jdbc.query(sql, (rs, rowNum) ->
                new Ong(
                        rs.getLong("ong_id"),
                        rs.getString("nome"),
                        Categoria.valueOf(rs.getString("categoria")),
                        rs.getDouble("saldo")
                ));
    }

    // Vizualizar ong por ID
    public Ong findById(long id) {
        String sql = "SELECT nome, categoria, saldo FROM ong_table WHERE ong_id = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Ong (
                        rs.getLong("ong_id"),
                        rs.getString("nome"),
                        Categoria.valueOf(rs.getString("categoria")),
                        rs.getDouble("saldo")
                ));
    }

    // Atualizar ong
    public void updateOng(Ong ong) {
        String sql = "UPDATE ong_table SET nome = ?, categoria = ?, saldo = ? WHERE ong_id = ?";
        jdbc.update(sql, ong.getNome(), ong.getCategoria().name(), ong.getSaldo(),ong.getOng_id());
    }

    // Deletar ong
    public void deleteOng(long id) {
        String sql = "DELETE FROM ong_table WHERE ong_id = ? ";
        jdbc.update(sql, id);
    }

    // Checar a existencia
    public boolean existe(long id) {
        String sql = "SELECT COUNT(*) FROM ong_table WHERE ong_id = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
}
