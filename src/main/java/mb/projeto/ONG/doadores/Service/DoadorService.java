package mb.projeto.ONG.doadores.Service;

import mb.projeto.ONG.doadores.Model.Doador;
import mb.projeto.ONG.doadores.Repository.DoadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoadorService {

    private final DoadorRepository repository;

    public DoadorService(DoadorRepository repository) {
        this.repository = repository;
    }

    // Regras de negocio

    public void novoDoador(Doador doador) {
        if (doador.getNome() == null || doador.getNome().isEmpty())
            throw new IllegalStateException("Por favor insira um nome valido para o doador");
        repository.novoDoador(doador);
    }

    public List<Doador> listarDoadores() {
        return repository.listarDoadores();
    }

    public void updateDoador(Doador doador) {
        if (!repository.existe(doador.getDoadorID()))
            throw new IllegalStateException("ID nao encontrado.");
        if (doador.getNome() == null || doador.getNome().isEmpty())
            throw new IllegalStateException("Por favor insira um nome valido para o doador");
        repository.updateDoador(doador);
    }

    public void deletarDoador(long id) {
        if (!repository.existe(id))
            throw new IllegalStateException("ID nao encontrado.");
        repository.deleteDoador(id);
    }
}
