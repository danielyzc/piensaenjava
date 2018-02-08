/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import entidades.Servicio;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface ServicioFacadeLocal {

    void create(Servicio servicio);

    void edit(Servicio servicio);

    void remove(Servicio servicio);

    Servicio find(Object id);

    List<Servicio> findAll();

    List<Servicio> findRange(int[] range);

    int count();
    
    List<Servicio> lista_activos();
    
    List<Servicio> lista_activos_fecha(String parametro, int tipo_orden,Date inicio_, Date final_);
}
