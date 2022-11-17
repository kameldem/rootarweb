package com.rootar.rootarweb.converter;


import com.rootar.rootarweb.RootarBean;
import com.rootar.rootarweb.metier.Categories;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter (value="categoriesConverter", managed = true)
public class CategoriesConverter implements Converter {

    @Inject
    private RootarBean rootarBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){

            for (Categories categories: rootarBean.getListCategories()){
                if(categories.getIdCategories()== Integer.parseInt(value)){
                    return categories;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Categories categories= (Categories) object;
        return String.valueOf(categories.getIdCategories());
    }
}
