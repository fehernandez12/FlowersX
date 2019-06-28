/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Pedido;
import facade.SolicitudFacade;
import entidades.Solicitud;
import entidades.Usuario;
import facade.PedidoFacade;
import facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Aprendiz
 */
@Named(value = "solicitudControlador")
@SessionScoped
public class SolicitudControlador implements Serializable {

    /**
     * Creates a new instance of SolicitudControlador
     */
    @EJB
    SolicitudFacade solicitudFacade;
    Solicitud solicitud = new Solicitud();
    private List<Solicitud> listaSolicitudes;
    @EJB
    PedidoFacade pedidoFacade;
    Pedido pedido = new Pedido();
    @EJB
    UsuarioFacade usuarioFacade;
    Usuario usuario = new Usuario();
    
    
    public SolicitudControlador() {
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    public List<Solicitud> consultarSolicitud () {
        return solicitudFacade.findAll();
    }
    
    public String crearSolicitud () {
        solicitud.setPedidoidPedido(pedidoFacade.find(pedido.getIdPedido()));
        solicitud.setUsuarioid(usuarioFacade.find(usuario.getId()));
        solicitudFacade.create(solicitud);
        solicitud = new Solicitud();
        return "gestionar-solicitudes.xhtml";
    }
    
    public String preEditarSolicitud (Solicitud solicitud) {
        this.solicitud = solicitud;
        return "editar-solicitud.xhtml";
    }
    
    public String editarSolicitud () {
        solicitudFacade.edit(solicitud);
        solicitud = new Solicitud();
        return "gestionar-solicitudes.xhtml";
    }
    
    public void eliminarSolicitud(Solicitud solicitud) {
        solicitudFacade.remove(solicitud);
    }
    
    public List<Solicitud> getListaSolicitudes() {
        return listaSolicitudes;
    }
 
    public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }
    
}
