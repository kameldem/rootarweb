package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.bean.RootarBean;
import com.rootar.rootarweb.metier.Visas;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="visasConverter", managed = true)
public class VisasConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Visas visas: rootarBean.getListVisas()){
                if(visas.getIdVisas()== Integer.parseInt(value)){
                    return visas;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Visas visas= (Visas) object;
        return String.valueOf(visas.getIdVisas());
    }
}
