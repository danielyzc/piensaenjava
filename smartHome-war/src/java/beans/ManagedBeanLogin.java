/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import componentes.PersonaFacadeLocal;
import entidades.Persona;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class ManagedBeanLogin implements Serializable {

    @EJB
    private PersonaFacadeLocal personaFacade;
    private Persona objetoPersona;

    public ManagedBeanLogin() {
        objetoPersona = new Persona();
    }

    public Persona getObjetoPersona() {
        return objetoPersona;
    }

    public void setObjetoPersona(Persona objetoPersona) {
        this.objetoPersona = objetoPersona;
    }

    public void validarLogin(String usuario_) {
        if (usuario_ != null) {
            if (objetoPersona != null) {
                objetoPersona = (Persona) personaFacade.buscar_login(usuario_);
            } else {
            }
        } else {
            // redireccionar a pagina de error.
        }

    }
}
