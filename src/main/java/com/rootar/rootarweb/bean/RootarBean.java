package com.rootar.rootarweb.bean;

import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.*;
import com.rootar.rootarweb.service.RootarSearch;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named("rootarBean")
@ApplicationScoped
public class RootarBean implements Serializable {
    @Inject
    ApplicationBean applicationBean;
    private String nomIMage;


    private Aeroports aeroportsSelected;
    private ArrayList<Aeroports>ListAeroports;
    private Categories categoriesSelected;
    private ArrayList<Categories> listCategories;
    private DonneesClimat donneesClimatSelected;
    private ArrayList<DonneesClimat> donneesClimatArrayList;


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
    private ArrayList<Continent> listContinentCombo;

    private RootarSearch rootarSearch;


    public RootarBean() {


    }

    @PostConstruct
    private void init(){

        rootarSearch = new RootarSearch();

        listContinentCombo=DAOFactory.getContinentDAO().getAll();
        listContinentCombo.add(0,new Continent(0,"Choisir un continent"));


        listTypeClimat=DAOFactory.getTypeClimatDAO().getAll();
        TypeClimat typeClimat = new TypeClimat(0, "Choisir un Type Climat");
        listTypeClimat.add(0, typeClimat);

        //listPays=DAOFactory.getPaysDAO().getLike(rootarSearch);

    }







    public String getNomIMage() {
        return nomIMage;
    }

    public void setNomIMage(String nomIMage) {
        this.nomIMage = nomIMage;
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

    public ArrayList<Continent> getListContinentCombo() {
        return listContinentCombo;
    }

    public void setListContinentCombo(ArrayList<Continent> listContinentCombo) {
        this.listContinentCombo = listContinentCombo;
    }



}
