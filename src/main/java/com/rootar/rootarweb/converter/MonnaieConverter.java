package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.bean.RootarBean;
import com.rootar.rootarweb.metier.Monnaie;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="monnaieConverter",managed=true)
public class MonnaieConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Monnaie monnaie: rootarBean.getListMonnaie()){
                if(monnaie.getIdMonnaie()== Integer.parseInt(value)){
                    return monnaie;
                }
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Monnaie monnaie= (Monnaie) object;
        return String.valueOf(monnaie.getIdMonnaie());
    }

}
