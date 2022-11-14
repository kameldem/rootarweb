package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.RootarBean;
import com.rootar.rootarweb.metier.Evenements;
import com.rootar.rootarweb.metier.Langues;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="languesConverter", managed = true)
public class LanguesConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Langues langues: rootarBean.getListLangues()){
                if(langues.getIdLangues()== Integer.parseInt(value)){
                    return langues;
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Langues langues= (Langues) object;
        return String.valueOf(langues.getIdLangues());
    }

}
