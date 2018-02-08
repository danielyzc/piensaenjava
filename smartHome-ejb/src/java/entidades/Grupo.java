/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g")
    , @NamedQuery(name = "Grupo.findByPkId", query = "SELECT g FROM Grupo g WHERE g.pkId = :pkId")
    , @NamedQuery(name = "Grupo.findByNombre", query = "SELECT g FROM Grupo g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "Grupo.findByDescripcion", query = "SELECT g FROM Grupo g WHERE g.descripcion = :descripcion")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo", fetch = FetchType.LAZY)
    private List<GrupoUsuario> grupoUsuarioList;

    public Grupo() {
    }

    public Grupo(Integer pkId) {
        this.pkId = pkId;
    }

    public Grupo(Integer pkId, String nombre, String descripcion) {
        this.pkId = pkId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<GrupoUsuario> getGrupoUsuarioList() {
        return grupoUsuarioList;
    }

    public void setGrupoUsuarioList(List<GrupoUsuario> grupoUsuarioList) {
        this.grupoUsuarioList = grupoUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkId != null ? pkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Grupo[ pkId=" + pkId + " ]";
    }
    
}
