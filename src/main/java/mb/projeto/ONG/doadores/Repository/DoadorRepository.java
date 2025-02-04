package mb.projeto.ONG.doadores.Repository;

import mb.projeto.ONG.doadores.Model.Doador;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoadorRepository {

    private final JdbcTemplate jdbc;

    public DoadorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Adicionar novo doador
    public void novoDoador(Doador doador) {
        String sql = "INSERT INTO doadores (nome) VALUES (?)";
        jdbc.update(sql, doador.getNome());
    }

    // Vizualizar doadores
    public List<Doador> listarDoadores() {
        String sql = "SELECT * FROM doadores";
        return jdbc.query(sql, (rs, rowNum) ->
                new Doador(
                        rs.getLong("doadorID"),
                        rs.getString("nome")
                ));
    }

    // Atualizar um doador
    public void updateDoador(Doador doador) {
        String sql = "UPDATE doadores SET nome = ? WHERE doadorID = ?";
        jdbc.update(sql, doador.getNome(), doador.getDoadorID());
    }

    // Deletar um doador
    public void deleteDoador(long id) {
        String sql =  "DELETE FROM doadores WHERE doadorID = ?";
        jdbc.update(sql, id);
    }

    // Checar se doador existe
    public boolean existe(long id) {
        String sql = "SELECT COUNT(*) FROM doadores WHERE doadorID = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
}
