package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.RootarBean;
import com.rootar.rootarweb.metier.Aeroports;
import com.rootar.rootarweb.metier.Ville;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter (value= "villeConverter", managed = true)
public class VilleConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Ville ville: rootarBean.getListVille()){
                if(ville.getIdVille()== Integer.parseInt(value)){
                    return ville;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Ville ville= (Ville) object;
        return String.valueOf(ville.getIdVille());
    }
}
