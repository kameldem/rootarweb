package com.rootar.rootarweb.bean;

import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.Pays;
import com.rootar.rootarweb.metier.Themes;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

@Named("themeBean")
@ApplicationScoped
public class ThemeBean implements Serializable {

    private Themes themesSelected;
    private ArrayList<Themes> listThemes;

    private ArrayList<Pays> listPays;

    @PostConstruct
    private void init(){
        listThemes=DAOFactory.getThemesDAO().getAll();
    }

    public void showThemes(Themes themes){
        themesSelected=themes;
        listPays=DAOFactory.getPaysDAO().getPaysByThemes(themes);

    }


    public void buttonListTheme() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("./paysThemes.xhtml");
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

    public ArrayList<Pays> getListPays() {
        return listPays;
    }

    public void setListPays(ArrayList<Pays> listPays) {
        this.listPays = listPays;
    }
}
