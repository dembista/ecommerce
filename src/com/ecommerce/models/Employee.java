package models;

public class Employee {
    private String nom;
    private int age;
    private double salaire;

    public Employee(String nom, int age, double salaire) {
        this.nom = nom;
        this.age = age;
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return String.format("%s (%d ans) - %.2f€", nom, age, salaire);
    }
}
