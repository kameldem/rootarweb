package com.rootar.rootarweb.metier;

public class Usr {

    private int idUsr;
    private String nom;
    private String prenom;
    private String mail;
    private String password;

    public Usr() {
        this.nom="";
        this.prenom="";
        this.mail="";
        this.password="";
    }

    public Usr(int idUsr, String nom, String prenom, String mail, String password) {
        this.idUsr = idUsr;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(int idUsr) {
        this.idUsr = idUsr;
    }

    @Override
    public String toString() {
        return "Usr{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
