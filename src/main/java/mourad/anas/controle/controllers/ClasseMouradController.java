package mourad.anas.controle.controllers;

import mourad.anas.controle.models.ClasseMourad;
import mourad.anas.controle.repositories.ClasseMouradRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/classes")
@CrossOrigin("http://localhost:3000")
public class ClasseMouradController {
    @Autowired
    private ClasseMouradRepository classeRepository;

    @PostMapping
    public ResponseEntity<EntityModel<ClasseMourad>> add(@RequestBody ClasseMourad classe) {
        ClasseMourad classeToAdd = classeRepository.save(classe);
        EntityModel<ClasseMourad> ressource = EntityModel.of(classeToAdd);
        Link selfLink = linkTo(this.getClass()).slash(classeToAdd.getIdCl()).withSelfRel();
        ressource.add(selfLink);
        Link lien = linkTo(methodOn(this.getClass()).get()).withRel("classes");
        ressource.add(lien);

        return new ResponseEntity<>(ressource, HttpStatus.CREATED);
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
