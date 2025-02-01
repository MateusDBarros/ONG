package mb.projeto.ONG.doadores.Controller;

import mb.projeto.ONG.doadores.Model.Doador;
import mb.projeto.ONG.doadores.Service.DoadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doadores")
public class DoadorController {

    private final DoadorService services;

    public DoadorController(DoadorService services) {
        this.services = services;
    }

    // Endpoints

    @PostMapping
    public ResponseEntity<String> novoDoador(@RequestBody Doador doador) {
        services.novoDoador(doador);
        return ResponseEntity.status(HttpStatus.CREATED).body("Novo doador adicionado com sucesso.");
    }

    @GetMapping
    public ResponseEntity<List<Doador>> listarDoadores() {
        List<Doador> list = services.listarDoadores();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDoador(@RequestBody Doador doador, @PathVariable long id) {
        doador.setDoadorID(id);
        services.updateDoador(doador);
        return ResponseEntity.status(HttpStatus.OK).body("Doador com ID #" +id+ " atualizado com sucesso!");
    }
}
