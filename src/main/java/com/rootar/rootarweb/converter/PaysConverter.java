package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.bean.PaysBean;
import com.rootar.rootarweb.bean.RootarBean;
import com.rootar.rootarweb.metier.Pays;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
@FacesConverter(value="paysConverter",managed=true)
public class PaysConverter implements Converter {
    @Inject
    private PaysBean paysBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Pays pays: paysBean.getListPays()){
                if(pays.getIdPays() == Integer.parseInt(value)){
                    return pays;
                }
            }
        }
        return null;

    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Pays pays= (Pays) object;
        return String.valueOf(pays.getIdPays());
    }
}
