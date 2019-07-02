/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.OrdenProduccion;
import entidades.Pedido;
import entidades.Usuario;
import facade.OrdenProduccionFacade;
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
@Named(value = "ordenProduccionControlador")
@SessionScoped
public class OrdenProduccionControlador implements Serializable {

    /**
     * Creates a new instance of OrdenProduccionControlador
     */
   @EJB
    
    OrdenProduccionFacade ordenProduccionFacade;
    OrdenProduccion ordenProduccion = new OrdenProduccion();
    
    @EJB
    PedidoFacade pedidoFacade;
    Pedido pedido= new Pedido();
    
    @EJB
    UsuarioFacade usuarioFacade;
    Usuario usuario = new Usuario();
    
    public OrdenProduccionControlador() {
    }
    public OrdenProduccion getOrdenProduccion() {
        return ordenProduccion;
    }

    public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
        this.ordenProduccion = ordenProduccion;
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
     public List<OrdenProduccion> consultarOrdenProduccion() {
        return ordenProduccionFacade.findAll();
    }
    
    public String crearOrdenProduccion() {
        ordenProduccion.setPedidoidPedido(pedidoFacade.find(pedido.getIdPedido()));
        ordenProduccion.setUsuarioid(usuarioFacade.find(usuario.getId()));
        ordenProduccionFacade.create(ordenProduccion);
        ordenProduccion = new OrdenProduccion();
        return "gestionar-ordenProduccion";
    }
    
     public String preEditarOrdenProduccion(OrdenProduccion ordenProduccion) {
        this.ordenProduccion = ordenProduccion;
        return "editar-ordenProduccion";
    }

    public String editarOrdenProduccion() {
        ordenProduccion.setPedidoidPedido(pedidoFacade.find(pedido.getIdPedido()));
        ordenProduccion.setUsuarioid(usuarioFacade.find(usuario.getId()));
        ordenProduccionFacade.edit(ordenProduccion);    
        ordenProduccion = new OrdenProduccion();
        return "gestionar-ordenProduccion";
    }

    public void eliminarOrdenProduccion(OrdenProduccion ordenProduccion) {
        
        ordenProduccionFacade.remove(ordenProduccion);
        //return "Lista";
    }
}

