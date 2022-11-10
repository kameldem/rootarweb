package com.rootar.rootarweb;

import com.rootar.rootarweb.converter.EvenementsConverter;
import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.*;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

@Named("rootarBean")
@SessionScoped
public class RootarBean implements Serializable {
    private String nomIMage;
    private Continent continentSelected;
    private ArrayList<Continent> listContinent;
    private ArrayList<Pays> listPays;

    private Aeroports aeroportsSelected;

    private ArrayList<Aeroports>ListAeroports;

    private Categories categories;

    private ArrayList<Categories> listCategories;

    private DonneesClimat donneesClimat;

    private ArrayList<DonneesClimat> donneesClimatArrayList;

    private Ville ville;

    private ArrayList<Ville> listVille;

    private Region region;

    private ArrayList<Region> listRegion;

    private Themes themes;

    private ArrayList<Themes> listThemes;

    private Visas visas;

    private ArrayList<Visas> listVisas;

    private Evenements evenements;

    private ArrayList<Evenements> listEvenments;

    private Langues langues;

    private ArrayList<Langues> listLangues;


    public RootarBean() {
        continentSelected=new Continent();

    }
    @PostConstruct
    private void init(){
    listContinent=DAOFactory.getContinentDAO().getAll();

    }
    public void show(Continent continent){
        continentSelected=continent;
        listPays=DAOFactory.getPaysDAO().getPaysByContinent(continentSelected.getIdContinent());

    }
    public void buttonAction() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("./payseurope.xhtml");
    }

    public String getNomIMage() {
        return nomIMage;
    }

    public void setNomIMage(String nomIMage) {
        this.nomIMage = nomIMage;
    }

    public Continent getContinentSelected() {
        return continentSelected;
    }

    public void setContinentSelected(Continent continentSelected) {
        this.continentSelected = continentSelected;
    }

    public ArrayList<Pays> getListPays() {
        return listPays;
    }

    public void setListPays(ArrayList<Pays> listPays) {
        this.listPays = listPays;
    }

    public ArrayList<Continent> getListContinent() {
        return listContinent;
    }

    public void setListContinent(ArrayList<Continent> listContinent) {
        this.listContinent = listContinent;
    }

    public Aeroports getAeroportsSelected() {
        return aeroportsSelected;
    }

    public void setAeroportsSelected(Aeroports aeroportsSelected) {
        this.aeroportsSelected = aeroportsSelected;
    }

    public ArrayList<Aeroports> getListAeroports() {
        return ListAeroports;
    }

    public void setListAeroports(ArrayList<Aeroports> listAeroports) {
        ListAeroports = listAeroports;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public ArrayList<Categories> getListCategories() {
        return listCategories;
    }

    public void setListCategories(ArrayList<Categories> listCategories) {
        this.listCategories = listCategories;
    }

    public DonneesClimat getDonneesClimat() {
        return donneesClimat;
    }

    public void setDonneesClimat(DonneesClimat donneesClimat) {
        this.donneesClimat = donneesClimat;
    }

    public ArrayList<DonneesClimat> getDonneesClimatArrayList() {
        return donneesClimatArrayList;
    }

    public void setDonneesClimatArrayList(ArrayList<DonneesClimat> donneesClimatArrayList) {
        this.donneesClimatArrayList = donneesClimatArrayList;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public ArrayList<Ville> getListVille() {
        return listVille;
    }

    public void setListVille(ArrayList<Ville> listVille) {
        this.listVille = listVille;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public ArrayList<Region> getListRegion() {
        return listRegion;
    }

    public void setListRegion(ArrayList<Region> listRegion) {
        this.listRegion = listRegion;
    }

    public Themes getThemes() {
        return themes;
    }

    public void setThemes(Themes themes) {
        this.themes = themes;
    }

    public ArrayList<Themes> getListThemes() {
        return listThemes;
    }

    public void setListThemes(ArrayList<Themes> listThemes) {
        this.listThemes = listThemes;
    }

    public Visas getVisas() {
        return visas;
    }

    public void setVisas(Visas visas) {
        this.visas = visas;
    }

    public ArrayList<Visas> getListVisas() {
        return listVisas;
    }

    public void setListVisas(ArrayList<Visas> listVisas) {
        this.listVisas = listVisas;
    }

    public Evenements getEvenements() {
        return evenements;
    }

    public void setEvenements(Evenements evenements) {
        this.evenements = evenements;
    }

    public ArrayList<Evenements> getListEvenments() {
        return listEvenments;
    }

    public void setListEvenments(ArrayList<Evenements> listEvenments) {
        this.listEvenments = listEvenments;
    }

    public Langues getLangues() {
        return langues;
    }

    public void setLangues(Langues langues) {
        this.langues = langues;
    }

    public ArrayList<Langues> getListLangues() {
        return listLangues;
    }

    public void setListLangues(ArrayList<Langues> listLangues) {
        this.listLangues = listLangues;
    }
}
