package mb.projeto.ONG.ongs.Controller;

import mb.projeto.ONG.ongs.Model.Ong;
import mb.projeto.ONG.ongs.Service.OngService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ongs")
public class OngController {

    private final OngService services;

    public OngController(OngService services) {
        this.services = services;
    }

    // Endpoints

    // Metodo Post
    @PostMapping
    public ResponseEntity<String> novaOng(@RequestBody Ong ong) {
        services.novaOng(ong);
        return ResponseEntity.status(HttpStatus.CREATED).body("Nova ong adicionada com sucesso!");
    }

    // Metodos GET
    @GetMapping
    public ResponseEntity<List<Ong>> listarOngs() {
        List<Ong> list = services.ListarOngs();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ong> findById(@PathVariable long id) {
        Ong ong = services.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ong);
    }

    // Metodo PUT
    @PutMapping
    public ResponseEntity<String> updateOng(@RequestBody Ong ong, @PathVariable long id) {
        ong.setOng_id(id);
        services.updateOng(ong);
        return ResponseEntity.status(HttpStatus.OK).body("Dados do id: " + id +" foram atualizados com sucesso!");
    }

    // Metodo DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOng(@PathVariable long id) {
        services.deleteOng(id);
        return ResponseEntity.status(HttpStatus.OK).body("ONG com ID: " +id+ " foram excluidos com sucesso!");
    }
}
