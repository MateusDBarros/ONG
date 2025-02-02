package mb.projeto.ONG.doacoes.Service;

import mb.projeto.ONG.doacoes.Model.Doacao;
import mb.projeto.ONG.doacoes.Repository.DoacaoRepository;
import mb.projeto.ONG.ongs.Repository.OngRepository;

import java.util.List;

public class DoacaoService {

    private final DoacaoRepository repository;
    private final OngRepository ongRepository;

    public DoacaoService(DoacaoRepository repository, OngRepository ongRepository) {
        this.repository = repository;
        this.ongRepository = ongRepository;
    }

    public void novaDoacao(Doacao doacao) {
        if (doacao.getValor() <= 0)
            throw new IllegalStateException("O valor da doação precisa ser maior que 0");
        if (doacao.getData() == null)
            throw new IllegalStateException("Por favor insira uma data válida");
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
