package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.RootarBean;
import com.rootar.rootarweb.metier.Continent;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="continentConverter",managed=true)
public class ContinentConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Continent continent: rootarBean.getListContinent()){
                if(continent.getIdContinent()== Integer.parseInt(value)){
                    return continent;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Continent continent= (Continent) object;
        return String.valueOf(continent.getIdContinent());
    }

}
