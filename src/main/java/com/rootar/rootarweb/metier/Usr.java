package com.rootar.rootarweb.metier;

public class Usr {

    private int idUsr;
    private String nom;
    private String prenom;
    private String email;
    private String password;

    private String login;

    public Usr() {
        this.nom="";
        this.prenom="";
        this.email="";
        this.password="";
        this.login="";

    }

    public Usr(int idUsr, String nom, String prenom, String mail, String password, String login) {
        this.idUsr = idUsr;
        this.nom = nom;
        this.prenom = prenom;
        this.email = mail;
        this.password = password;
        this.login = login;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Usr{" +
                "idUsr=" + idUsr +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
