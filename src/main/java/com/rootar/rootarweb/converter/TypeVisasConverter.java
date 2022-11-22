package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.bean.RootarBean;
import com.rootar.rootarweb.metier.TypeVisas;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="typeVisasConverter", managed = true)
public class TypeVisasConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (TypeVisas typeVisas: rootarBean.getListTypeVisas()){
                if(typeVisas.getIdTypeVisas()== Integer.parseInt(value)){
                    return typeVisas;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        TypeVisas typeVisas= (TypeVisas) object;
        return String.valueOf(typeVisas.getIdTypeVisas());
    }
}
