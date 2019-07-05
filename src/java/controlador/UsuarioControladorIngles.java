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
import javax.faces.context.FacesContext;

/**
 *
 * @author Aprendiz
 */
@Named(value = "usuarioControladorIngles")
@SessionScoped
public class UsuarioControladorIngles implements Serializable {

    /**
     * Creates a new instance of UsuarioControladorIngles
     */
    public UsuarioControladorIngles() {
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

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
                        redireccionar = "EN/Admin/index-admin.xhtml";
                        break;
                    case 3:
                        redireccionar = "EN/Ingeniero/index-ingeniero.xhtml";
                        break;
                    case 4:
                        redireccionar = "EN/Vendedor/index-vendedor.xhtml";
                        break;
                    case 5:
                        redireccionar = "EN/Cliente/index-cliente.xhtml";
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return redireccionar;
    }
    
}
