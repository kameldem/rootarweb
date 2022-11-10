package com.rootar.rootarweb.metier;

public class Objet {

    private int idObjet;
    private String libelleObjet;
    private Categories categories;

    public Objet() {

    }

    public Objet(int idObjet, String libelleObjet) {
        this.idObjet = idObjet;
        this.libelleObjet = libelleObjet;
        categories=new Categories();
    }

    public Objet(int idObjet, String libelleObjet, Categories categories) {
        this.idObjet = idObjet;
        this.libelleObjet = libelleObjet;
        this.categories = categories;
    }

    public int getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(int id) {
        this.idObjet = id;
    }

    public String getLibelleObjet() {
        return libelleObjet;
    }

    public void setLibelleObjet(String libelleObjet) {
        this.libelleObjet = libelleObjet;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return libelleObjet;
    }
}
