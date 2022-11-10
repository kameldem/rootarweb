package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.RootarBean;
import com.rootar.rootarweb.metier.Aeroports;
import com.rootar.rootarweb.metier.DonneesClimat;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="donneesClimatConverter", managed = true)
public class DonneesClimatConverter implements Converter {

   @Inject
    private RootarBean rootarBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (DonneesClimat donneesClimat: rootarBean.getDonneesClimatArrayList()){
                if(donneesClimat.getIdRegion()== Integer.parseInt(value)){
                    return donneesClimat;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        DonneesClimat donneesClimat= (DonneesClimat) object;
        return String.valueOf(donneesClimat.getIdRegion());
    }
}
