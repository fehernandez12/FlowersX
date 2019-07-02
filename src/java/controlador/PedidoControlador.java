/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Pedido;
import entidades.Usuario;
import facade.PedidoFacade;
import facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Aprendiz
 */
@Named(value = "pedidoControlador")
@SessionScoped
public class PedidoControlador implements Serializable {

    /**
     * Creates a new instance of PedidoControlador
     */
    @EJB
    PedidoFacade pedidoFacade;
    Pedido pedido;
    @EJB
    UsuarioFacade usuarioFacade;
    Usuario usuario;
  
    @PostConstruct
    public void init(){
        pedido = new Pedido();
        usuario = new Usuario();
    }
    
    public PedidoControlador() {
    }
    public Pedido getPedido(){
        return pedido;
    }
    
    public void setPedido(Pedido Pedido){
        this.pedido = pedido;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
     public List<Pedido> consultarPedido() {
        return pedidoFacade.findAll();
    }
    
    public String crearPedido() {
        pedido.setUsuarioid(usuarioFacade.find(usuario.getId()));
        pedidoFacade.create(pedido);
        pedido = new Pedido();
        return "gestionar-pedido";
    }

    public String preEditarPedido(Pedido pedido) {
        this.pedido = pedido;
        return "editar-pedido";
    }

    public String editarPedido(){
        pedido.setUsuarioid(usuarioFacade.find(usuario.getId()));
        pedidoFacade.edit(pedido);
        pedido = new Pedido();
        return "gestionar-pedido";
    }

    public void eliminarPedido(Pedido pedido) {
        pedidoFacade.remove(pedido);
        //return "Lista";
    }
    
}
