/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import clases.ReciboSuma;
import entidades.Recibo;
import entidades.TipoServicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface ReciboFacadeLocal {

    void create(Recibo recibo);

    void edit(Recibo recibo);

    void remove(Recibo recibo);

    Recibo find(Object id);

    List<Recibo> findAll();

    List<Recibo> findRange(int[] range);

    int count();

    public List<Recibo> lista_tipoServicio(TipoServicio obj_TipoServicio);

    public List<Object[]> lista_categoria();
    
   public List<ReciboSuma> lista_mes();
}
