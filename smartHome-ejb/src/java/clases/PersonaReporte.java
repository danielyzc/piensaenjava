/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import entidades.Persona;

/**
 *
 * @author Usuario
 */
public class PersonaReporte {
    private Persona persona;
    private Long cantidad;

    public PersonaReporte(Persona persona, Long cantidad) {
        this.persona = persona;
        this.cantidad = cantidad;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

}
