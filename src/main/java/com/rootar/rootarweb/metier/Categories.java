package com.rootar.rootarweb.metier;

public class Categories {

    private int idCategories;

    private String libelleCategories;

    public Categories() {

    }

    public Categories(int idCategories, String libelleCategories) {
        this.idCategories = idCategories;
        this.libelleCategories = libelleCategories;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    public String getLibelleCategories() {
        return libelleCategories;
    }

    public void setLibelleCategories(String libelleCategories) {
        this.libelleCategories = libelleCategories;
    }

    @Override
    public String toString() {
        return  libelleCategories ;
    }
}
