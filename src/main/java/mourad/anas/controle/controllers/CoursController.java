package mourad.anas.controle.controllers;

import mourad.anas.controle.models.Cours;
import mourad.anas.controle.repositories.CoursRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
@CrossOrigin("http://localhost:3000")
public class CoursController {
    @Autowired
    private CoursRepository coursRepository;

    @PostMapping
    public ResponseEntity<Cours> add(@RequestBody Cours cours) {
        coursRepository.save(cours);

        return ResponseEntity.ok(cours);
    }

    @GetMapping
    public List<Cours> get() { return coursRepository.findAll(); }

    @DeleteMapping("/{idCo}")
    public void delete(@PathVariable int idCo) { coursRepository.deleteById(idCo); }

    @PutMapping("/{idCo}")
    public ResponseEntity<Cours> update(@RequestBody Cours cours) {
        Cours updateCours = coursRepository.findById(cours.getIdCo())
                .orElseThrow(() -> new ResourceNotFoundException("Le cours " + cours.getIdCo() + " n'existe pas!"));

        updateCours.setTitre(cours.getTitre());
        updateCours.setClasse(cours.getClasse());

        coursRepository.save(updateCours);

        return ResponseEntity.ok(updateCours);
    }
}
