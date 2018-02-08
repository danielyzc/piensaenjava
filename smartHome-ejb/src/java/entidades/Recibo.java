/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "recibo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recibo.findAll", query = "SELECT r FROM Recibo r")
    , @NamedQuery(name = "Recibo.findByPkId", query = "SELECT r FROM Recibo r WHERE r.pkId = :pkId")
    , @NamedQuery(name = "Recibo.findByMonto", query = "SELECT r FROM Recibo r WHERE r.monto = :monto")
    , @NamedQuery(name = "Recibo.findByNumMes", query = "SELECT r FROM Recibo r WHERE r.numMes = :numMes")})
public class Recibo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumMes")
    private short numMes;
    @JoinColumn(name = "fk_servicio", referencedColumnName = "pk_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Servicio servicio;

    public Recibo() {
    }

    public Recibo(Integer pkId) {
        this.pkId = pkId;
    }

    public Recibo(Integer pkId, BigDecimal monto, short numMes) {
        this.pkId = pkId;
        this.monto = monto;
        this.numMes = numMes;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public short getNumMes() {
        return numMes;
    }

    public void setNumMes(short numMes) {
        this.numMes = numMes;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
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
        if (!(object instanceof Recibo)) {
            return false;
        }
        Recibo other = (Recibo) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Recibo[ pkId=" + pkId + " ]";
    }
    
}
