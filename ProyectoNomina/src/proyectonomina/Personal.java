/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectonomina;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alega
 */
@Entity
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findByClaveEmpleado", query = "SELECT p FROM Personal p WHERE p.claveEmpleado = :claveEmpleado"),
    @NamedQuery(name = "Personal.findByNombre", query = "SELECT p FROM Personal p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Personal.findByApellidoPaterno", query = "SELECT p FROM Personal p WHERE p.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Personal.findByApellidoMaterno", query = "SELECT p FROM Personal p WHERE p.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Personal.findByRfc", query = "SELECT p FROM Personal p WHERE p.rfc = :rfc")})
public class Personal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "clave_empleado")
    private Integer claveEmpleado;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Column(name = "rfc")
    private String rfc;
    @OneToMany(mappedBy = "claveEmpleado")
    private List<Horario> horarioList;
    @OneToMany(mappedBy = "claveEmpleado")
    private List<Permiso> permisoList;

    public Personal() {
    }

    public Personal(Integer claveEmpleado) {
        this.claveEmpleado = claveEmpleado;
    }

    public Integer getClaveEmpleado() {
        return claveEmpleado;
    }

    public void setClaveEmpleado(Integer claveEmpleado) {
        this.claveEmpleado = claveEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @XmlTransient
    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveEmpleado != null ? claveEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.claveEmpleado == null && other.claveEmpleado != null) || (this.claveEmpleado != null && !this.claveEmpleado.equals(other.claveEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectonomina.Personal[ claveEmpleado=" + claveEmpleado + " ]";
    }
    
}
