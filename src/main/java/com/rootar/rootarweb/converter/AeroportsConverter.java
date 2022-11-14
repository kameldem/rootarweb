package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.RootarBean;
import com.rootar.rootarweb.metier.Aeroports;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter (value="aeroportsConverter", managed = true)
public class AeroportsConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Aeroports aeroports: rootarBean.getListAeroports()){
                if(aeroports.getIdAeroport()== Integer.parseInt(value)){
                    return aeroports;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Aeroports aeroports= (Aeroports) object;
        return String.valueOf(aeroports.getIdAeroport());
    }
}
