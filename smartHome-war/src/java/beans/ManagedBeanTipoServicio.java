/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import componentes.TipoServicioFacadeLocal;
import entidades.TipoServicio;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class ManagedBeanTipoServicio implements Serializable {

    @EJB
    private TipoServicioFacadeLocal tipoServicioFacade;
    private List<SelectItem> listaItems = new LinkedList<>();

    public ManagedBeanTipoServicio() {
    }

    public List<SelectItem> getListaItems() {
        try {
            listaItems = new LinkedList<>();
            for (TipoServicio t : tipoServicioFacade.lista_activos()) {
                listaItems.add(new SelectItem(t, t.getDescripcion()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaItems;
    }

    public void setListaItems(List<SelectItem> listaItems) {
        this.listaItems = listaItems;
    }

    public TipoServicio traerObjeto(int id_) {
        return tipoServicioFacade.find(id_);
    }

    public List<TipoServicio> autocompletar(String dato) {
        return tipoServicioFacade.lista_filtrada("descripcion", dato);
    }
}
