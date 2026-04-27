public class Student {
private String nom;
    private double note;

    public Student() {
    }

    public Student(String nom, double note) {
        this.nom = nom;
        this.note = note;
    }

    public String getNom() {
        return nom;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return nom + " (" + note + "/20)";
    }
}
