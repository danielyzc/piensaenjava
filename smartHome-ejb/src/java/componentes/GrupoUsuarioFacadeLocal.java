/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import entidades.GrupoUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface GrupoUsuarioFacadeLocal {

    void create(GrupoUsuario grupoUsuario);

    void edit(GrupoUsuario grupoUsuario);

    void remove(GrupoUsuario grupoUsuario);

    GrupoUsuario find(Object id);

    List<GrupoUsuario> findAll();

    List<GrupoUsuario> findRange(int[] range);

    int count();
    
}
