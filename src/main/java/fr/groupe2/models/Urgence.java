package fr.groupe2.models;


public class Urgence {

    // Attributs
    private int id;
    private String nom;

    // Constructeur
    public Urgence() {

    }

    public Urgence(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
