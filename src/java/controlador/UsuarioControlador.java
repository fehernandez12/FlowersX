/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Rol;
import entidades.Usuario;
import facade.RolFacade;
import facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Guillermo
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class UsuarioControlador implements Serializable {

    /**
     * Creates a new instance of UsuarioControlador
     */
    public UsuarioControlador() {
    }

    @EJB
    UsuarioFacade usuarioFacade;
    Usuario usuario = new Usuario();
    private List<Usuario> listaUsuarios;
    @EJB
    RolFacade rolFacade;
    Rol rol = new Rol();

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

    public String preEditarUsuario(Usuario usuario) {
        this.usuario = usuario;
        return "editar-usuario";
    }

    public String editarUsuario() {
        usuario.setRolidRol(rolFacade.find(rol.getIdRol()));
        usuarioFacade.edit(usuario);
        usuario = new Usuario();
        return "gestionar-usuarios";
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarioFacade.remove(usuario);
        //return "Lista";
    }

    public String validarLogin() {
        String redireccionar = "";
        try {
            Usuario usuarioLogueado = usuarioFacade.login(usuario);
            if (usuarioLogueado != null) {
                System.out.println("Usuario Logueado: " + usuarioLogueado.getTitular());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sesionLogin", usuarioLogueado);
                switch (usuarioLogueado.getRolidRol().getIdRol()) {
                    case 1:
                        redireccionar = "SI/1-admin/index-admin.xhtml";
                        break;
                    case 3:
                        redireccionar = "SI/2-ingeniero/index-ingeniero.xhtml";
                        break;
                    case 4:
                        redireccionar = "SI/3-vendedor/index-vendedor.xhtml";
                        break;
                    case 5:
                        redireccionar = "SI/4-cliente/index-cliente.xhtml";
                        break;
                    default:
                        throw new AssertionError();
                }
            } else {
                redireccionar = "index";
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return redireccionar;
    }
    
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
 
    public void setListaSolicitudes(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}
