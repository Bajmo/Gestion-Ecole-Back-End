package mourad.anas.controle.controllers;

import mourad.anas.controle.models.Etudiant;
import mourad.anas.controle.repositories.ClasseMouradRepository;
import mourad.anas.controle.repositories.EtudiantRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
@CrossOrigin("http://localhost:3000")
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ClasseMouradRepository classeRepository;

    @PostMapping
    public ResponseEntity<Etudiant> add(@RequestBody Etudiant etudiant) {
        etudiantRepository.save(etudiant);

        return ResponseEntity.ok(etudiant);
    }

    @GetMapping
    public List<Etudiant> get() { return etudiantRepository.findAll(); }

    @GetMapping("/classe/{idClasse}")
    public List<Etudiant> findAllByClasse(@PathVariable int idClasse) { return classeRepository.getEtudiantsByClasse(idClasse); }

    @DeleteMapping("/{idE}")
    public void delete(@PathVariable int idE) { classeRepository.deleteById(idE); }

    @PutMapping("/{idE}")
    public ResponseEntity<Etudiant> update(@RequestBody Etudiant etudiant) {
        Etudiant updateEtudiant = etudiantRepository.findById(etudiant.getIdE())
                .orElseThrow(() -> new ResourceNotFoundException("L'étudiant " + etudiant.getIdE() + " n'existe pas!"));

        updateEtudiant.setNom(etudiant.getNom());
        updateEtudiant.setClasse(etudiant.getClasse());

        etudiantRepository.save(updateEtudiant);

        return ResponseEntity.ok(updateEtudiant);
    }
}
