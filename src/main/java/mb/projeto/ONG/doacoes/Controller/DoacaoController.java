package mb.projeto.ONG.doacoes.Controller;

import mb.projeto.ONG.doacoes.Model.Doacao;
import mb.projeto.ONG.doacoes.Service.DoacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {

    private final DoacaoService services;

    public DoacaoController(DoacaoService services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<String> novaDoacao(@RequestBody Doacao doacao) {
        services.novaDoacao(doacao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Doação registrada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Doacao>> listarDoacoes() {
        List <Doacao> list = services.listarDoacoes();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")

}
