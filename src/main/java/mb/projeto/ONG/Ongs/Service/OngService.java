package mb.projeto.ONG.Ongs.Service;

import mb.projeto.ONG.Ongs.Model.Ong;
import mb.projeto.ONG.Ongs.Repository.OngRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OngService {

    private final OngRepository repository;

    public OngService(OngRepository repository) {
        this.repository = repository;
    }

    // Regras de negócio
    // Metodo para checagem de excessões
    public boolean check(Ong ong) {
        if (ong.getNome() == null || ong.getNome().isEmpty())
            throw new IllegalStateException("Por favor insira um NOME valido para a ong.");
        if (ong.getCategoria() == null)
            throw new IllegalStateException("Por favor insira uma CATEGORIA para a ong.");
        if (ong.getSaldo() < 0)
            throw new IllegalStateException("SALDO não pode ser menor que 0.");
        return true;
    }

    // Metodo de cadastro
    public void novaOng(Ong ong) {
        if (check(ong))
            repository.novaOng(ong);
    }

    // Metodo de vizualizar todos
    public List<Ong> ListarOngs() {
        return repository.listarOngs();
    }

    // Metodo de procurar por id
    public Ong findById(long id) {
        if (!repository.existe(id))
            throw new IllegalStateException("ID não encontrado para pesquisa.");
        return repository.findById(id);
    }

    // Metodo de atualização
    public void updateOng(Ong ong) {
        if (check(ong))
            repository.updateOng(ong);
    }

    // Metodo de exclusao
    public void deleteOng(long id) {
        if (!repository.existe(id))
            throw new IllegalStateException("ID não encontrado para exclusão");
        repository.deleteOng(id);
    }
}