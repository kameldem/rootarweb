package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.RootarBean;
import com.rootar.rootarweb.metier.Priorite;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="prioriteConverter",managed=true)
public class PrioriteConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Priorite priorite: rootarBean.getListPriorite()){
                if(priorite.getIdPriorite()== Integer.parseInt(value)){
                    return priorite;
                }
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Priorite priorite= (Priorite) object;
        return String.valueOf(priorite.getIdPriorite());
    }

}