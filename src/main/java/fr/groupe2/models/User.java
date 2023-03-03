package fr.groupe2.models;


public class User {
    //attribut
    private int id;
    private String nom;
    private String prenom;

    // constructeur
    public User(int id, String nom, String prenom){
        this.id= id;
        this.nom = nom;
        this.prenom = prenom;
    }

    // getter and setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }    public String getNom() {
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
}
