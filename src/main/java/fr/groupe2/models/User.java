package fr.groupe2.models;


public class User {
    //attribut
    private String nom;
    private String prenom;
    // getter and setter
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // constructeur
    public User(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }
}
