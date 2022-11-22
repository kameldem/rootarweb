package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.bean.RootarBean;
import com.rootar.rootarweb.metier.Themes;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter (value="themeConverter", managed = true)
public class ThemeConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Themes themes: rootarBean.getListThemes()){
                if(themes.getIdThemes()== Integer.parseInt(value)){
                    return themes;
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Themes themes= (Themes) object;
        return String.valueOf(themes.getIdThemes());
    }

}