package mb.projeto.ONG.doacoes.Repository;

import mb.projeto.ONG.doacoes.Model.Doacao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class DoacaoRepository {

    private final JdbcTemplate jdbc;

    public DoacaoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void novaDoacao(Doacao doacao) {
        String sql = "INSERT INTO doacoes (doadorID, ong_id, datatempo, valor) VALUES (?, ?, ?, ?)";
        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, doacao.getDoadorID());
            ps.setLong(2, doacao.getOng_id());
            // Passa o LocalDateTime diretamente, informando que o tipo SQL é TIMESTAMP:
            ps.setObject(3, doacao.getData(), java.sql.Types.TIMESTAMP);
            ps.setDouble(4, doacao.getValor());
            return ps;
        });

    }

    public List<Doacao> listarDoacoes() {
        String sql = "SELECT * FROM doacoes";
        return jdbc.query(sql, (rs, rowNum) ->
                new Doacao(
                        rs.getLong("doacaoID"),
                        rs.getLong("ong_id"),
                        rs.getLong("doadorID"),
                        rs.getTimestamp("datatempo").toLocalDateTime(),
                        rs.getDouble("valor")
                ));
    }

    public Doacao findById(long id) {
        String sql = "SELECT * FROM doacoes WHERE doacaoID = ?";
        return jdbc.queryForObject(sql, new Object[] {id}, (rs, rowNum) ->
                new Doacao(
                        rs.getLong("doacaoID"),
                        rs.getLong("ong_id"),
                        rs.getLong("doadorID"),
                        rs.getTimestamp("datatempo").toLocalDateTime(),
                        rs.getDouble("valor")
                ));
    }
}
