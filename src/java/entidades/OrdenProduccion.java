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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "ordendeproduccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenProduccion.findAll", query = "SELECT o FROM OrdenProduccion o")
    , @NamedQuery(name = "OrdenProduccion.findByIdOrdenDeProduccion", query = "SELECT o FROM OrdenProduccion o WHERE o.idOrdenDeProduccion = :idOrdenDeProduccion")
    , @NamedQuery(name = "OrdenProduccion.findByCantidad", query = "SELECT o FROM OrdenProduccion o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenProduccion.findByFechainicio", query = "SELECT o FROM OrdenProduccion o WHERE o.fechainicio = :fechainicio")
    , @NamedQuery(name = "OrdenProduccion.findByFechaFin", query = "SELECT o FROM OrdenProduccion o WHERE o.fechaFin = :fechaFin")})
public class OrdenProduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrdenDeProduccion")
    private Integer idOrdenDeProduccion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descipcionArreglo")
    private String descipcionArreglo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "Pedido_idPedido", referencedColumnName = "idPedido")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido pedidoidPedido;
    @JoinColumn(name = "Usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenDeProduccionidOrdenDeProduccion", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public OrdenProduccion() {
    }

    public OrdenProduccion(Integer idOrdenDeProduccion) {
        this.idOrdenDeProduccion = idOrdenDeProduccion;
    }

    public OrdenProduccion(Integer idOrdenDeProduccion, String descipcionArreglo, int cantidad, String estado, Date fechainicio, Date fechaFin) {
        this.idOrdenDeProduccion = idOrdenDeProduccion;
        this.descipcionArreglo = descipcionArreglo;
        this.cantidad = cantidad;
        this.estado = estado;
        this.fechainicio = fechainicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdOrdenDeProduccion() {
        return idOrdenDeProduccion;
    }

    public void setIdOrdenDeProduccion(Integer idOrdenDeProduccion) {
        this.idOrdenDeProduccion = idOrdenDeProduccion;
    }

    public String getDescipcionArreglo() {
        return descipcionArreglo;
    }

    public void setDescipcionArreglo(String descipcionArreglo) {
        this.descipcionArreglo = descipcionArreglo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Pedido getPedidoidPedido() {
        return pedidoidPedido;
    }

    public void setPedidoidPedido(Pedido pedidoidPedido) {
        this.pedidoidPedido = pedidoidPedido;
    }

    public Usuario getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Usuario usuarioid) {
        this.usuarioid = usuarioid;
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
        hash += (idOrdenDeProduccion != null ? idOrdenDeProduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenProduccion)) {
            return false;
        }
        OrdenProduccion other = (OrdenProduccion) object;
        if ((this.idOrdenDeProduccion == null && other.idOrdenDeProduccion != null) || (this.idOrdenDeProduccion != null && !this.idOrdenDeProduccion.equals(other.idOrdenDeProduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.OrdenProduccion[ idOrdenDeProduccion=" + idOrdenDeProduccion + " ]";
    }
    
}
