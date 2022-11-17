package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.RootarBean;
import com.rootar.rootarweb.metier.TypeClimat;
import com.rootar.rootarweb.metier.TypeVisas;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="typeClimatConverter", managed = true)
public class TypeClimatConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (TypeClimat typeClimat: rootarBean.getListTypeClimat()){
                if(typeClimat.getIdTypeClimat()== Integer.parseInt(value)){
                    return typeClimat;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        TypeClimat typeClimat= (TypeClimat) object;
        return String.valueOf(typeClimat.getIdTypeClimat());
    }
}
