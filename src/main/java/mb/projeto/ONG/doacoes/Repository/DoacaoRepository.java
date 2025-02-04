package mb.projeto.ONG.doacoes.Repository;

import mb.projeto.ONG.doacoes.Model.Doacao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoacaoRepository {

    private final JdbcTemplate jdbc;

    public DoacaoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void novaDoacao(Doacao doacao) {
        String sql = "INSERT INTO doacoes (ongID, doadorID, datatempo, valor) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, doacao.getOngID(), doacao.getDoadorID(), doacao.getData(), doacao.getValor());
    }

    public List<Doacao> listarDoacoes() {
        String sql = "SELECT * FROM doacoes";
        return jdbc.query(sql, (rs, rowNum) ->
                new Doacao(
                        rs.getLong("doacaoID"),
                        rs.getLong("ongID"),
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
                        rs.getLong("ongID"),
                        rs.getLong("doadorID"),
                        rs.getTimestamp("datatempo").toLocalDateTime(),
                        rs.getDouble("valor")
                ));
    }
}
