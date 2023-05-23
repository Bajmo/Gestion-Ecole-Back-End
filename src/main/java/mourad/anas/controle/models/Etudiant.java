package mourad.anas.controle.models;

import jakarta.persistence.*;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idE;
    @Column(nullable = false,length = 80)
    private String nom;
    @ManyToOne
    private ClasseMourad classe;

    public Etudiant(int idE, String nom, ClasseMourad classe) {
        this.idE = idE;
        this.nom = nom;
        this.classe = classe;
    }

    public Etudiant() {

    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ClasseMourad getClasse() {
        return classe;
    }

    public void setClasse(ClasseMourad classe) {
        this.classe = classe;
    }
}
