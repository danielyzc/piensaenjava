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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "consolidado_mes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsolidadoMes.findAll", query = "SELECT c FROM ConsolidadoMes c")
    , @NamedQuery(name = "ConsolidadoMes.findByPkId", query = "SELECT c FROM ConsolidadoMes c WHERE c.pkId = :pkId")
    , @NamedQuery(name = "ConsolidadoMes.findByNumMes", query = "SELECT c FROM ConsolidadoMes c WHERE c.numMes = :numMes")
    , @NamedQuery(name = "ConsolidadoMes.findByAnio", query = "SELECT c FROM ConsolidadoMes c WHERE c.anio = :anio")
    , @NamedQuery(name = "ConsolidadoMes.findByMontoTotal", query = "SELECT c FROM ConsolidadoMes c WHERE c.montoTotal = :montoTotal")})
public class ConsolidadoMes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numMes")
    private int numMes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Anio")
    private String anio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MontoTotal")
    private BigDecimal montoTotal;

    public ConsolidadoMes() {
    }

    public ConsolidadoMes(Integer pkId) {
        this.pkId = pkId;
    }

    public ConsolidadoMes(Integer pkId, int numMes, String anio, BigDecimal montoTotal) {
        this.pkId = pkId;
        this.numMes = numMes;
        this.anio = anio;
        this.montoTotal = montoTotal;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public int getNumMes() {
        return numMes;
    }

    public void setNumMes(int numMes) {
        this.numMes = numMes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
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
        if (!(object instanceof ConsolidadoMes)) {
            return false;
        }
        ConsolidadoMes other = (ConsolidadoMes) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ConsolidadoMes[ pkId=" + pkId + " ]";
    }
    
}
