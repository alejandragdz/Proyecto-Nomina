/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectonomina;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alega
 */
@Entity
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByIdHorario", query = "SELECT h FROM Horario h WHERE h.idHorario = :idHorario"),
    @NamedQuery(name = "Horario.findByDia", query = "SELECT h FROM Horario h WHERE h.dia = :dia"),
    @NamedQuery(name = "Horario.findByHrEntrada", query = "SELECT h FROM Horario h WHERE h.hrEntrada = :hrEntrada"),
    @NamedQuery(name = "Horario.findByHrSalida", query = "SELECT h FROM Horario h WHERE h.hrSalida = :hrSalida")})
public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_horario")
    private Integer idHorario;
    @Column(name = "dia")
    private Integer dia;
    @Column(name = "hr_entrada")
    @Temporal(TemporalType.DATE)
    private Date hrEntrada;
    @Column(name = "hr_salida")
    @Temporal(TemporalType.DATE)
    private Date hrSalida;
    @JoinColumn(name = "clave_empleado", referencedColumnName = "clave_empleado")
    @ManyToOne
    private Personal claveEmpleado;

    public Horario() {
    }

    public Horario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Date getHrEntrada() {
        return hrEntrada;
    }

    public void setHrEntrada(Date hrEntrada) {
        this.hrEntrada = hrEntrada;
    }

    public Date getHrSalida() {
        return hrSalida;
    }

    public void setHrSalida(Date hrSalida) {
        this.hrSalida = hrSalida;
    }

    public Personal getClaveEmpleado() {
        return claveEmpleado;
    }

    public void setClaveEmpleado(Personal claveEmpleado) {
        this.claveEmpleado = claveEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectonomina.Horario[ idHorario=" + idHorario + " ]";
    }
    
}
