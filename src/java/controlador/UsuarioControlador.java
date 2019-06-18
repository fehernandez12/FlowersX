/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import facade.RolFacade;
import facade.UsuarioFacade;
import entidades.Rol;
import entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Aprendiz
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class UsuarioControlador implements Serializable {

    /**
     * Creates a new instance of UsuarioControlador
     */
    @EJB
    UsuarioFacade usuarioFacade;
    Usuario usuario = new Usuario();
    @EJB
    RolFacade rolFacade;
    Rol rol = new Rol();
    
    public UsuarioControlador() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public List<Usuario> consultarUsuario() {
        return usuarioFacade.findAll();
    }
    
    public String crearUsuario() {
        usuario.setRolidRol(rolFacade.find(rol.getIdRol()));
        usuarioFacade.create(usuario);
        usuario = new Usuario();
        return "gestionar-usuarios";
    }
    
    public void preEditarUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void editarUsuario() {
        usuarioFacade.edit(usuario);
        usuario = new Usuario();
    }
    
    public void eliminarCiudad(Usuario usuario) {
        usuarioFacade.remove(usuario);
        //return "Lista";
    }
    
}
