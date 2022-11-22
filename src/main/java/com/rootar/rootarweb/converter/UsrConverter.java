package com.rootar.rootarweb.converter;

import com.rootar.rootarweb.bean.UserBean;
import com.rootar.rootarweb.metier.Usr;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="usrConverter", managed = true)
public class UsrConverter implements Converter {
    @Inject
    private UserBean userBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Usr usr: userBean.getListUsr()){
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
