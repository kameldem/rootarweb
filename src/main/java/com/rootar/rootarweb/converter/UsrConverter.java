package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.LoginBean;
import com.rootar.rootarweb.RootarBean;
import com.rootar.rootarweb.metier.Usr;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="usrConverter", managed = true)
public class UsrConverter implements Converter {
    @Inject
    private LoginBean loginBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Usr usr: loginBean.getListUsr()){
                if(usr.getIdUsr()== Integer.parseInt(value)){
                    return usr;
                }
            }
        }
        return null;
    }
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Usr usr= (Usr) object;
        return String.valueOf(usr.getIdUsr());
    }
}
