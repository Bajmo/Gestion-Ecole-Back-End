package mourad.anas.controle.repositories;

import mourad.anas.controle.models.ClasseMourad;
import mourad.anas.controle.models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseMouradRepository extends JpaRepository<ClasseMourad, Integer> {
    @Query("Select e from Etudiant e JOIN e.classe c where c.idCl=:idClasse")
    List<Etudiant> getEtudiantsByClasse(@Param("idClasse") int idClasse);

    @Query("Select c from ClasseMourad c where c.niveau=:niveau")
    List<ClasseMourad> getClassesByNiveau(@Param("niveau") String niveau);
}
