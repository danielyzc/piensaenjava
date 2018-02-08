/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")
    , @NamedQuery(name = "Servicio.findByPkId", query = "SELECT s FROM Servicio s WHERE s.pkId = :pkId")
    , @NamedQuery(name = "Servicio.findByDescripcion", query = "SELECT s FROM Servicio s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Servicio.findByFecCreacion", query = "SELECT s FROM Servicio s WHERE s.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "Servicio.findByEstado", query = "SELECT s FROM Servicio s WHERE s.estado = :estado")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
    @Column(name = "estado")
    private Integer estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio", fetch = FetchType.LAZY)
    private List<Recibo> reciboList;
    @JoinColumn(name = "fk_tipo_servicio", referencedColumnName = "pk_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoServicio tipoServicio;

    public Servicio() {
    }

    public Servicio(Integer pkId) {
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

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Recibo> getReciboList() {
        return reciboList;
    }

    public void setReciboList(List<Recibo> reciboList) {
        this.reciboList = reciboList;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
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
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Servicio[ pkId=" + pkId + " ]";
    }
    
}
