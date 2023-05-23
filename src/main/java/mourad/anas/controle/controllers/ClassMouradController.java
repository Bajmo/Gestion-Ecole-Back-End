package mourad.anas.controle.controllers;

import mourad.anas.controle.models.ClasseMourad;
import mourad.anas.controle.repositories.ClasseMouradRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
@CrossOrigin("http://localhost:3000")
public class ClassMouradController {
    @Autowired
    private ClasseMouradRepository classeRepository;

    @PostMapping
    public ResponseEntity<ClasseMourad> add(@RequestBody ClasseMourad classe) {
        classeRepository.save(classe);

        return ResponseEntity.ok(classe);
    }

    @GetMapping
    public List<ClasseMourad> get() { return classeRepository.findAll(); }

    @GetMapping("/niveau/{niveau}")
    public List<ClasseMourad> getAllByNiveau(@PathVariable String niveau) { return classeRepository.getClassesByNiveau(niveau); }

    @DeleteMapping("/{idCl}")
    public void delete(@PathVariable int idCl) { classeRepository.deleteById(idCl); }

    @PutMapping("/{idCl}")
    public ResponseEntity<ClasseMourad> update(@RequestBody ClasseMourad classe) {
        ClasseMourad updateClasse = classeRepository.findById(classe.getIdCl())
                .orElseThrow(() -> new ResourceNotFoundException("La classe " + classe.getIdCl() + " n'existe pas!"));

        updateClasse.setNiveau(classe.getNiveau());

        classeRepository.save(updateClasse);

        return ResponseEntity.ok(updateClasse);
    }
}
