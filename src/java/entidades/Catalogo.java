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
 * @author Aprendiz
 */
@Entity
@Table(name = "catalogo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c")
    , @NamedQuery(name = "Catalogo.findByIdCatalogo", query = "SELECT c FROM Catalogo c WHERE c.idCatalogo = :idCatalogo")
    , @NamedQuery(name = "Catalogo.findByNombreProducto", query = "SELECT c FROM Catalogo c WHERE c.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Catalogo.findByDescripcion", query = "SELECT c FROM Catalogo c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Catalogo.findByTiempoDeCultivo", query = "SELECT c FROM Catalogo c WHERE c.tiempoDeCultivo = :tiempoDeCultivo")})
public class Catalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCatalogo")
    private Integer idCatalogo;
    @Basic(optional = false)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "tiempoDeCultivo")
    private String tiempoDeCultivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogoidCatalogo", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public Catalogo() {
    }

    public Catalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Catalogo(Integer idCatalogo, String nombreProducto, String descripcion, String tiempoDeCultivo) {
        this.idCatalogo = idCatalogo;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.tiempoDeCultivo = tiempoDeCultivo;
    }

    public Integer getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTiempoDeCultivo() {
        return tiempoDeCultivo;
    }

    public void setTiempoDeCultivo(String tiempoDeCultivo) {
        this.tiempoDeCultivo = tiempoDeCultivo;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatalogo != null ? idCatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.idCatalogo == null && other.idCatalogo != null) || (this.idCatalogo != null && !this.idCatalogo.equals(other.idCatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Catalogo[ idCatalogo=" + idCatalogo + " ]";
    }
    
}
