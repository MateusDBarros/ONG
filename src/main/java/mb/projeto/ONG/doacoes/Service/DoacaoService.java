package mb.projeto.ONG.doacoes.Service;

import mb.projeto.ONG.doacoes.Model.Doacao;
import mb.projeto.ONG.doacoes.Repository.DoacaoRepository;

public class DoacaoService {

    private final DoacaoRepository repository;

    public DoacaoService(DoacaoRepository repository) {
        this.repository = repository;
    }

    public void novaDoacao(Doacao doacao) {
        if (doacao.getValor() <= 0)
            throw new IllegalStateException("O valor da doação precisa ser maior que 0");
        if (doacao.getData() == null)
            throw new IllegalStateException("Por favor insira uma data válida");
        repository.novaDoacao(doacao);
    }


}
