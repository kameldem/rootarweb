package com.rootar.rootarweb.metier;


public class Pays {
    private int idPays;
    private String nomPaysFr;
    private String codePays;
    private String nomPaysAng;
    private String nationalite;
    private int superficie;
    private int nbreHabitant;
    private String devise;
    private String feteNationale;
    private String indicatifTel;
    private Continent continent;
    private Monnaie monnaie;
    private Visas visas;

    private Ville ville;


    public Pays() {
    }

    public Pays(int idPays, String nomPaysFr) {
        this.idPays = idPays;
        this.nomPaysFr = nomPaysFr;
        continent = new Continent();
        monnaie = new Monnaie();
        visas = new Visas();
    }

    public Pays(int idPays, String codePays,String nomPaysFr,  String nomPaysAng, String nationalite,int nbreHabitant,  int superficie, String devise, String feteNationale, String indicatifTel,Continent continent,Monnaie monnaie, Ville ville) {
        this.idPays = idPays;
        this.nomPaysFr = nomPaysFr;
        this.codePays = codePays;
        this.nomPaysAng = nomPaysAng;
        this.nationalite = nationalite;
        this.nbreHabitant = nbreHabitant;
        this.superficie = superficie;
        this.devise = devise;
        this.feteNationale = feteNationale;
        this.indicatifTel = indicatifTel;
        this.continent=continent;
        this.monnaie=monnaie;
        this.ville=ville;
    }

    public Pays(int idPays, String nomPaysFr, Continent continent) {
        this.idPays = idPays;
        this.nomPaysFr = nomPaysFr;
        this.continent = continent;

    }

    public Pays(int idPays, String nomPaysFr, Continent continent, Ville ville) {
        this.idPays = idPays;
        this.nomPaysFr = nomPaysFr;
        this.continent = continent;
        this.ville = ville;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Monnaie getMonnaie() {
        return monnaie;
    }

    public void setMonnaie(Monnaie monnaie) {
        this.monnaie = monnaie;
    }

    public Visas getVisas() {
        return visas;
    }

    public void setVisas(Visas visas) {
        this.visas = visas;
    }

  /*  public StringProperty codePaysProperty()
    {
        return new SimpleStringProperty(codePays);
    }
    public StringProperty nomPaysFrProperty()
    {
        return new SimpleStringProperty(nomPaysFr);
    }

    public StringProperty nomContinentProperty() {
        return new SimpleStringProperty(this.continent.getNomContinentFr());
    }

    public StringProperty nomVilleProperty(){
        return new SimpleStringProperty(this.ville.getNomVille());
    }
*/
    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public String getNomPaysFr() {
        return nomPaysFr;
    }

    public void setNomPaysFr(String nomPaysFr) {
        this.nomPaysFr = nomPaysFr;
    }

    public String getCodePays() {
        return codePays;
    }

    public void setCodePays(String codePays) {
        this.codePays = codePays;
    }

    public String getNomPaysAng() {
        return nomPaysAng;
    }

    public void setNomPaysAng(String nomPaysAng) {
        this.nomPaysAng = nomPaysAng;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }


    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getNbreHabitant() {
        return nbreHabitant;
    }

    public void setNbreHabitant(int nbreHabitant) {
        this.nbreHabitant = nbreHabitant;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getFeteNationale() {
        return feteNationale;
    }

    public void setFeteNationale(String feteNationale) {
        this.feteNationale = feteNationale;
    }

    public String getIndicatifTel() {
        return indicatifTel;
    }

    public void setIndicatifTel(String indicatifTel) {
        this.indicatifTel = indicatifTel;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return nomPaysFr;
    }
}
