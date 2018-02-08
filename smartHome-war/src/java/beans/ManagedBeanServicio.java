/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import clases.PersonaReporte;
import componentes.PersonaFacadeLocal;
import componentes.ServicioFacadeLocal;
import entidades.Servicio;
import entidades.TipoServicio;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
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
public class ManagedBeanServicio implements Serializable {

    @EJB
    private PersonaFacadeLocal personaFacade;

    @EJB
    private ServicioFacadeLocal servicioFacade;
    
    private Servicio objeto;
    private Date f_inicio;
    private Date f_final;
    private List<Servicio> lista;
    
    
    

    public ManagedBeanServicio() {
        objeto = new Servicio();
        f_inicio = new Date();
        f_final = new Date();
        lista = new LinkedList<>();
    }

   

    public List<Servicio> getLista() {
        return lista;
    }

    public void setLista(List<Servicio> lista) {
        this.lista = lista;
    }

    public Date getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(Date f_inicio) {
        this.f_inicio = f_inicio;
    }

    public Date getF_final() {
        return f_final;
    }

    public void setF_final(Date f_final) {
        this.f_final = f_final;
    }

    public Servicio getObjeto() {
        return objeto;
    }

    public void setObjeto(Servicio objeto) {
        this.objeto = objeto;
    }

    public List<Servicio> getListaBD() {
        return servicioFacade.lista_activos();
    }

    public void preparaNuevoObjeto() {
        objeto = new Servicio();
        System.out.println("  pasando por preparaNuevoObjeto");
    }

    public void crear() {
        try {
            objeto.setEstado(1);
            objeto.setFecCreacion(new Date());
             // objeto.setTipoServicio(new TipoServicio(1));
            // insertando en bd
            servicioFacade.create(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editarObjeto() {
        try {
            servicioFacade.edit(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarObjeto() {
        try {
            objeto.setEstado(0);
            servicioFacade.edit(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(Servicio objetoEditar) {
        objeto = new Servicio();
        objeto = objetoEditar;
    }

    public void filtrar() {
        try {
            lista = servicioFacade.lista_activos_fecha("descripcion",1,f_inicio, f_final);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void test(){
        
        for(PersonaReporte p : personaFacade.listaPersonas()){
            System.out.println(" DATA  "+p.getPersona().getApePat()+ "  VS "+p.getCantidad());
        }
    
    }
}
