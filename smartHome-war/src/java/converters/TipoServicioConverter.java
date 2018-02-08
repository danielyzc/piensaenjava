/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import beans.ManagedBeanTipoServicio;
import entidades.TipoServicio;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Usuario
 */
@FacesConverter(value = "tipoServicioConverter")
public class TipoServicioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (context == null) {
            throw new NullPointerException("Context");
        }
        if (component == null) {
            throw new NullPointerException("Component");
        }
        FacesContext ctx = FacesContext.getCurrentInstance();
        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{managedBeanTipoServicio}", ManagedBeanTipoServicio.class);
        ManagedBeanTipoServicio bean = (ManagedBeanTipoServicio) vex.getValue(ctx.getELContext());
        TipoServicio objeto = new TipoServicio();
        try {
            objeto = bean.traerObjeto(new Integer(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (objeto == null) {
            throw new ConverterException("ERROR");
        }
        return objeto;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (context == null) {
            throw new NullPointerException("Context");
        }
        if (component == null) {
            throw new NullPointerException("Component");
        }
        if (value == null || ((TipoServicio) value).getPkId() == null) {
            return "";
        }
        System.out.println("hey" + value);
        return ((TipoServicio) value).getPkId().toString();
    }

}
