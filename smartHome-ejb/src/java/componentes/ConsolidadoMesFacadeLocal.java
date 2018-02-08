/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import entidades.ConsolidadoMes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface ConsolidadoMesFacadeLocal {

    void create(ConsolidadoMes consolidadoMes);

    void edit(ConsolidadoMes consolidadoMes);

    void remove(ConsolidadoMes consolidadoMes);

    ConsolidadoMes find(Object id);

    List<ConsolidadoMes> findAll();

    List<ConsolidadoMes> findRange(int[] range);

    int count();
    
}
