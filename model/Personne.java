package model;

import java.sql.Date;

public class Personne {

    private String nom;
    private String prenom;
    private int age;
    private double taille;
    private Date dateNaissance;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return this.nom.concat(" ").concat(this.prenom)
                .concat(" a l age de : ").concat(this.age + " ans")
                .concat("a une taille de : ").concat(this.taille + " m")
                .concat("nee le : ").concat(this.dateNaissance.toString());
    }
}
