package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.RootarBean;
import com.rootar.rootarweb.metier.RepresentationEtrangere;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="representationEtrangereConverter",managed=true)
public class RepresentationEtrangereConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (RepresentationEtrangere representationEtrangere: rootarBean.getListRepEtr()){
                if(representationEtrangere.getIdRepEtrangere()== Integer.parseInt(value)){
                    return representationEtrangere;
                }
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        RepresentationEtrangere representationEtrangere= (RepresentationEtrangere) object;
        return String.valueOf(representationEtrangere.getIdRepEtrangere());
    }
}
