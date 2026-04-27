package models;

public class User {
    private  String nom;
    private  String email;
    private  String password;
    private boolean isActive;
    private  boolean isAdmin;

    public User(String nom, String email, String password) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Nom ne doit pas être null ou vide");
        }
        if (email == null || email.trim().isEmpty() || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            throw new IllegalArgumentException("Email invalide");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password doit contenir au moins 6 caractères");
        }
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.isActive = true;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivate() {
        isActive = false;
    }

}
