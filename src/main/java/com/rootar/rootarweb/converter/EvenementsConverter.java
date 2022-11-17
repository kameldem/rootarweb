package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.RootarBean;
import com.rootar.rootarweb.metier.Continent;
import com.rootar.rootarweb.metier.Evenements;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="evenementsConverter", managed = true)
public class EvenementsConverter implements Converter {
    @Inject
    private RootarBean rootarBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Evenements evenements: rootarBean.getListEvenments()){
                if(evenements.getIdEvenements()== Integer.parseInt(value)){
                    return evenements;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Evenements evenements= (Evenements) object;
        return String.valueOf(evenements.getIdEvenements());
    }
}