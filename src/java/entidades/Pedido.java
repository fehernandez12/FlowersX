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
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "Pedido.findByFechaDeCreacion", query = "SELECT p FROM Pedido p WHERE p.fechaDeCreacion = :fechaDeCreacion")
    , @NamedQuery(name = "Pedido.findByFechaDeEnvio", query = "SELECT p FROM Pedido p WHERE p.fechaDeEnvio = :fechaDeEnvio")
    , @NamedQuery(name = "Pedido.findByMonto", query = "SELECT p FROM Pedido p WHERE p.monto = :monto")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPedido")
    private Integer idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDeCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaDeCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDeEnvio")
    @Temporal(TemporalType.DATE)
    private Date fechaDeEnvio;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "direccionDeEnvio")
    private String direccionDeEnvio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private int monto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoidPedido", fetch = FetchType.LAZY)
    private List<Novedad> novedadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoidPedido", fetch = FetchType.LAZY)
    private List<OrdenProduccion> ordenProduccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoidPedido", fetch = FetchType.LAZY)
    private List<Solicitud> solicitudList;
    @JoinColumn(name = "Usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoidPedido", fetch = FetchType.LAZY)
    private List<Pago> pagoList;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, Date fechaDeCreacion, Date fechaDeEnvio, String direccionDeEnvio, int monto) {
        this.idPedido = idPedido;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeEnvio = fechaDeEnvio;
        this.direccionDeEnvio = direccionDeEnvio;
        this.monto = monto;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Date getFechaDeEnvio() {
        return fechaDeEnvio;
    }

    public void setFechaDeEnvio(Date fechaDeEnvio) {
        this.fechaDeEnvio = fechaDeEnvio;
    }

    public String getDireccionDeEnvio() {
        return direccionDeEnvio;
    }

    public void setDireccionDeEnvio(String direccionDeEnvio) {
        this.direccionDeEnvio = direccionDeEnvio;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @XmlTransient
    public List<Novedad> getNovedadList() {
        return novedadList;
    }

    public void setNovedadList(List<Novedad> novedadList) {
        this.novedadList = novedadList;
    }

    @XmlTransient
    public List<OrdenProduccion> getOrdenProduccionList() {
        return ordenProduccionList;
    }

    public void setOrdenProduccionList(List<OrdenProduccion> ordenProduccionList) {
        this.ordenProduccionList = ordenProduccionList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    public Usuario getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Usuario usuarioid) {
        this.usuarioid = usuarioid;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
