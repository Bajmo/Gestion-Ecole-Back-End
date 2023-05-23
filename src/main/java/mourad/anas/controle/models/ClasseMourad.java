package mourad.anas.controle.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClasseMourad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCl;
    private String niveau;

    public ClasseMourad(int idCl, String niveau) {
        this.idCl = idCl;
        this.niveau = niveau;
    }

    public ClasseMourad() {

    }

    public int getIdCl() {
        return idCl;
    }

    public void setIdCl(int idCl) {
        this.idCl = idCl;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
