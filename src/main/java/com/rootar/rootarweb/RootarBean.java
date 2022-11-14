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
    private Pays paysSelected;
    private ArrayList<Pays> listPays;
    private Aeroports aeroportsSelected;
    private ArrayList<Aeroports>ListAeroports;
    private Categories categoriesSelected;
    private ArrayList<Categories> listCategories;
    private DonneesClimat donneesClimatSelected;
    private ArrayList<DonneesClimat> donneesClimatArrayList;
    private Ville villeSelected;
    private ArrayList<Ville> listVille;
    private Region regionSelected;
    private ArrayList<Region> listRegion;
    private Themes themesSelected;
    private ArrayList<Themes> listThemes;
    private Visas visasSelected;
    private ArrayList<Visas> listVisas;
    private Evenements evenementsSelected;
    private ArrayList<Evenements> listEvenments;
    private Langues languesSelected;
    private ArrayList<Langues> listLangues;
    private Monnaie monnaieSelected;
    private ArrayList<Monnaie> listMonnaie;
    private Objet objetSelected;
    private ArrayList<Objet> listObjet;
    private Priorite prioriteSelected;
    private ArrayList<Priorite> listPriorite;
    private RepresentationEtrangere repEtrSelected;
    private ArrayList<RepresentationEtrangere> listRepEtr;
    private Sante santeSelected;
    private ArrayList<Sante> listSante;
    private TypeClimat typeClimatSelected;
    private ArrayList<TypeClimat> listTypeClimat;
    private TypeVisas typeVisasSelected;
    private ArrayList<TypeVisas> listTypeVisas;




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

    public ArrayList<Continent> getListContinent() {
        return listContinent;
    }

    public void setListContinent(ArrayList<Continent> listContinent) {
        this.listContinent = listContinent;
    }

    public Pays getPaysSelected() {
        return paysSelected;
    }

    public void setPaysSelected(Pays paysSelected) {
        this.paysSelected = paysSelected;
    }

    public ArrayList<Pays> getListPays() {
        return listPays;
    }

    public void setListPays(ArrayList<Pays> listPays) {
        this.listPays = listPays;
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

    public Categories getCategoriesSelected() {
        return categoriesSelected;
    }

    public void setCategoriesSelected(Categories categoriesSelected) {
        this.categoriesSelected = categoriesSelected;
    }

    public ArrayList<Categories> getListCategories() {
        return listCategories;
    }

    public void setListCategories(ArrayList<Categories> listCategories) {
        this.listCategories = listCategories;
    }

    public DonneesClimat getDonneesClimatSelected() {
        return donneesClimatSelected;
    }

    public void setDonneesClimatSelected(DonneesClimat donneesClimatSelected) {
        this.donneesClimatSelected = donneesClimatSelected;
    }

    public ArrayList<DonneesClimat> getDonneesClimatArrayList() {
        return donneesClimatArrayList;
    }

    public void setDonneesClimatArrayList(ArrayList<DonneesClimat> donneesClimatArrayList) {
        this.donneesClimatArrayList = donneesClimatArrayList;
    }

    public Ville getVilleSelected() {
        return villeSelected;
    }

    public void setVilleSelected(Ville villeSelected) {
        this.villeSelected = villeSelected;
    }

    public ArrayList<Ville> getListVille() {
        return listVille;
    }

    public void setListVille(ArrayList<Ville> listVille) {
        this.listVille = listVille;
    }

    public Region getRegionSelected() {
        return regionSelected;
    }

    public void setRegionSelected(Region regionSelected) {
        this.regionSelected = regionSelected;
    }

    public ArrayList<Region> getListRegion() {
        return listRegion;
    }

    public void setListRegion(ArrayList<Region> listRegion) {
        this.listRegion = listRegion;
    }

    public Themes getThemesSelected() {
        return themesSelected;
    }

    public void setThemesSelected(Themes themesSelected) {
        this.themesSelected = themesSelected;
    }

    public ArrayList<Themes> getListThemes() {
        return listThemes;
    }

    public void setListThemes(ArrayList<Themes> listThemes) {
        this.listThemes = listThemes;
    }

    public Visas getVisasSelected() {
        return visasSelected;
    }

    public void setVisasSelected(Visas visasSelected) {
        this.visasSelected = visasSelected;
    }

    public ArrayList<Visas> getListVisas() {
        return listVisas;
    }

    public void setListVisas(ArrayList<Visas> listVisas) {
        this.listVisas = listVisas;
    }

    public Evenements getEvenementsSelected() {
        return evenementsSelected;
    }

    public void setEvenementsSelected(Evenements evenementsSelected) {
        this.evenementsSelected = evenementsSelected;
    }

    public ArrayList<Evenements> getListEvenments() {
        return listEvenments;
    }

    public void setListEvenments(ArrayList<Evenements> listEvenments) {
        this.listEvenments = listEvenments;
    }

    public Langues getLanguesSelected() {
        return languesSelected;
    }

    public void setLanguesSelected(Langues languesSelected) {
        this.languesSelected = languesSelected;
    }

    public ArrayList<Langues> getListLangues() {
        return listLangues;
    }

    public void setListLangues(ArrayList<Langues> listLangues) {
        this.listLangues = listLangues;
    }

    public Monnaie getMonnaieSelected() {
        return monnaieSelected;
    }

    public void setMonnaieSelected(Monnaie monnaieSelected) {
        this.monnaieSelected = monnaieSelected;
    }

    public ArrayList<Monnaie> getListMonnaie() {
        return listMonnaie;
    }

    public void setListMonnaie(ArrayList<Monnaie> listMonnaie) {
        this.listMonnaie = listMonnaie;
    }

    public Objet getObjetSelected() {
        return objetSelected;
    }

    public void setObjetSelected(Objet objetSelected) {
        this.objetSelected = objetSelected;
    }

    public ArrayList<Objet> getListObjet() {
        return listObjet;
    }

    public void setListObjet(ArrayList<Objet> listObjet) {
        this.listObjet = listObjet;
    }

    public Priorite getPrioriteSelected() {
        return prioriteSelected;
    }

    public void setPrioriteSelected(Priorite prioriteSelected) {
        this.prioriteSelected = prioriteSelected;
    }

    public ArrayList<Priorite> getListPriorite() {
        return listPriorite;
    }

    public void setListPriorite(ArrayList<Priorite> listPriorite) {
        this.listPriorite = listPriorite;
    }

    public RepresentationEtrangere getRepEtrSelected() {
        return repEtrSelected;
    }

    public void setRepEtrSelected(RepresentationEtrangere repEtrSelected) {
        this.repEtrSelected = repEtrSelected;
    }

    public ArrayList<RepresentationEtrangere> getListRepEtr() {
        return listRepEtr;
    }

    public void setListRepEtr(ArrayList<RepresentationEtrangere> listRepEtr) {
        this.listRepEtr = listRepEtr;
    }

    public Sante getSanteSelected() {
        return santeSelected;
    }

    public void setSanteSelected(Sante santeSelected) {
        this.santeSelected = santeSelected;
    }

    public ArrayList<Sante> getListSante() {
        return listSante;
    }

    public void setListSante(ArrayList<Sante> listSante) {
        this.listSante = listSante;
    }

    public TypeClimat getTypeClimatSelected() {
        return typeClimatSelected;
    }

    public void setTypeClimatSelected(TypeClimat typeClimatSelected) {
        this.typeClimatSelected = typeClimatSelected;
    }

    public ArrayList<TypeClimat> getListTypeClimat() {
        return listTypeClimat;
    }

    public void setListTypeClimat(ArrayList<TypeClimat> listTypeClimat) {
        this.listTypeClimat = listTypeClimat;
    }

    public TypeVisas getTypeVisasSelected() {
        return typeVisasSelected;
    }

    public void setTypeVisasSelected(TypeVisas typeVisasSelected) {
        this.typeVisasSelected = typeVisasSelected;
    }

    public ArrayList<TypeVisas> getListTypeVisas() {
        return listTypeVisas;
    }

    public void setListTypeVisas(ArrayList<TypeVisas> listTypeVisas) {
        this.listTypeVisas = listTypeVisas;
    }
}
