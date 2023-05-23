package mourad.anas.controle.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private String libelle;
    @ManyToMany
    private List<Cours> cours;

    public Salle(int numero, String libelle, List<Cours> cours) {
        this.numero = numero;
        this.libelle = libelle;
        this.cours = cours;
    }

    public Salle() {

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
}
