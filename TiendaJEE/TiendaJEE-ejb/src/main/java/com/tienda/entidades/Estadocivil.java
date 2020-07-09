/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dennis
 */
@Entity
@Table(name = "Estado_civil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadocivil.findAll", query = "SELECT e FROM Estadocivil e")
    , @NamedQuery(name = "Estadocivil.findByCodigoEC", query = "SELECT e FROM Estadocivil e WHERE e.codigoEC = :codigoEC")
    , @NamedQuery(name = "Estadocivil.findByNombre", query = "SELECT e FROM Estadocivil e WHERE e.nombre = :nombre")})
public class Estadocivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_e_c")
    private Integer codigoEC;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEstadoCivil")
    private Collection<Empleado> empleadoCollection;

    public Estadocivil() {
    }

    public Estadocivil(Integer codigoEC) {
        this.codigoEC = codigoEC;
    }

    public Integer getCodigoEC() {
        return codigoEC;
    }

    public void setCodigoEC(Integer codigoEC) {
        this.codigoEC = codigoEC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEC != null ? codigoEC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocivil)) {
            return false;
        }
        Estadocivil other = (Estadocivil) object;
        if ((this.codigoEC == null && other.codigoEC != null) || (this.codigoEC != null && !this.codigoEC.equals(other.codigoEC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.entidades.Estadocivil[ codigoEC=" + codigoEC + " ]";
    }
    
}
