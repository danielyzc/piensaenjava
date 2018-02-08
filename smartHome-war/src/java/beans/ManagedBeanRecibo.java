/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import clases.ReciboSuma;
import componentes.ReciboFacadeLocal;
import entidades.Recibo;
import entidades.TipoServicio;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class ManagedBeanRecibo implements Serializable {

    @EJB
    private ReciboFacadeLocal reciboFacade;
    private Recibo objeto;
    private List<Recibo> lista;
    private List<Object[]> listaCategoria;

    public ManagedBeanRecibo() {
        lista = new LinkedList<>();
        objeto = new Recibo();
        listaCategoria = new LinkedList<>();
    }

    public Recibo getObjeto() {
        return objeto;
    }

    public void setObjeto(Recibo objeto) {
        this.objeto = objeto;
    }

    public List<Recibo> getLista() {
        return lista;
    }

    public void setLista(List<Recibo> lista) {
        this.lista = lista;
    }

    public List<Recibo> getTraerFiltrada() {
        lista = reciboFacade.lista_tipoServicio(new TipoServicio(2));
        return lista;
    }
    public List<ReciboSuma> getTraerReciboSuma() {
        return reciboFacade.lista_mes();
       
    }

    public List<Object[]> getListaCategoria() {
     return  listaCategoria = reciboFacade.lista_categoria();

    }
}
