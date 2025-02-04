package mb.projeto.ONG.doacoes.Service;

import mb.projeto.ONG.doacoes.Model.Doacao;
import mb.projeto.ONG.doacoes.Repository.DoacaoRepository;
import mb.projeto.ONG.ongs.Repository.OngRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoacaoService {

    private final DoacaoRepository repository;
    private final OngRepository ongRepository;

    public DoacaoService(DoacaoRepository repository, OngRepository ongRepository) {
        this.repository = repository;
        this.ongRepository = ongRepository;
    }

    public void novaDoacao(Doacao doacao) {
        if (doacao == null)
            throw new IllegalArgumentException("A doação não pode ser nula");

        if (doacao.getValor() <= 0)
            throw new IllegalArgumentException("O valor da doação precisa ser maior que 0");

        if (doacao.getData() == null)   // Ou doacao.getDataDoacao(), conforme seu modelo
            throw new IllegalArgumentException("Por favor, insira uma data válida");

        repository.novaDoacao(doacao);
    }


    public List<Doacao> listarDoacoes() {
        return repository.listarDoacoes();
    }

    public Doacao findById(long id) {
        if (!ongRepository.existe(id))
            throw new IllegalStateException("Doação com ID #" +id+ " não encontrada.");
        return repository.findById(id);
    }
}
