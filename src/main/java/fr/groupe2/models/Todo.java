package fr.groupe2.models;


import java.util.Date;

public class Todo {
    // attributs
    private int id;
    private String titre, description;
    private Date date;
    private User user;
    private Urgence urgence;

    // constructeur
    private  Todo() {

    }
    public Todo(int id, String titre, String description, Date date, User user, Urgence urgence) {
        this.id = id;
        this.urgence = urgence;
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.user = user;

    }

    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Urgence getUrgence() {
        return urgence;
    }
    public void setUrgence(Urgence urgence) {
        this.urgence = urgence;
    }
}
