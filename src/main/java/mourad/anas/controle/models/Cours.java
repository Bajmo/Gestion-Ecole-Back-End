package mourad.anas.controle.models;

import jakarta.persistence.*;

@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCo;
    private String titre;
    @ManyToOne
    private ClasseMourad classe;

    public Cours(int idCo, String titre, ClasseMourad classe) {
        this.idCo = idCo;
        this.titre = titre;
        this.classe = classe;
    }

    public Cours() {

    }

    public int getIdCo() {
        return idCo;
    }

    public void setIdCo(int idCo) {
        this.idCo = idCo;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ClasseMourad getClasse() {
        return classe;
    }

    public void setClasse(ClasseMourad classe) {
        this.classe = classe;
    }
}
