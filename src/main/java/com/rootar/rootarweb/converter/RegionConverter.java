package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.bean.RootarBean;
import com.rootar.rootarweb.metier.Region;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "regionConverter", managed = true)
public class RegionConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Region region: rootarBean.getListRegion()){
                if(region.getIdRegion()== Integer.parseInt(value)){
                    return region;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Region region= (Region) object;
        return String.valueOf(region.getIdRegion());
    }
}
