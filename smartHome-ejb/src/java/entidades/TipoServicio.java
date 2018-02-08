/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "tipo_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoServicio.findAll", query = "SELECT t FROM TipoServicio t")
    , @NamedQuery(name = "TipoServicio.findByPkId", query = "SELECT t FROM TipoServicio t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TipoServicio.findByDescripcion", query = "SELECT t FROM TipoServicio t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoServicio.findByEstado", query = "SELECT t FROM TipoServicio t WHERE t.estado = :estado")})
public class TipoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_id")
    private Integer pkId;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Integer estado;
    @OneToMany(mappedBy = "tipoServicio", fetch = FetchType.LAZY)
    private List<Servicio> servicioList;

    public TipoServicio() {
    }

    public TipoServicio(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
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
        if (!(object instanceof TipoServicio)) {
            return false;
        }
        TipoServicio other = (TipoServicio) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoServicio[ pkId=" + pkId + " ]";
    }
    
}
