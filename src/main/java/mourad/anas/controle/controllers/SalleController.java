package mourad.anas.controle.controllers;

import mourad.anas.controle.models.Salle;
import mourad.anas.controle.repositories.SalleRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salles")
@CrossOrigin("http://localhost:3000")
public class SalleController {
    @Autowired
    private SalleRepository salleRepository;

    @PostMapping
    public ResponseEntity<Salle> add(@RequestBody Salle salle) {
        salleRepository.save(salle);

        return ResponseEntity.ok(salle);
    }

    @GetMapping
    public List<Salle> get() { return salleRepository.findAll(); }

    @DeleteMapping("/{numero}")
    public void delete(@PathVariable int numero) { salleRepository.deleteById(numero); }

    @PutMapping("/{numero}")
    public ResponseEntity<Salle> update(@RequestBody Salle salle) {
        Salle updateSalle = salleRepository.findById(salle.getNumero())
                .orElseThrow(() -> new ResourceNotFoundException("L'étudiant " + salle.getNumero() + " n'existe pas!"));

        updateSalle.setLibelle(salle.getLibelle());
        updateSalle.setCours(salle.getCours()); 

        salleRepository.save(updateSalle);

        return ResponseEntity.ok(updateSalle);
    }
}
