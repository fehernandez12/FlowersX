/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import facade.SolicitudFacade;
import entidades.Solicitud;
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
    public SolicitudControlador() {
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    public List<Solicitud> consultarSolicitud () {
        return solicitudFacade.findAll();
    }
    
    public String crearSolicitud () {
        solicitudFacade.create(solicitud);
        solicitud = new Solicitud();
        return "Crear";
    }
    
    public String preEditarSolicitud (Solicitud solicitud) {
        this.solicitud = solicitud;
        return "Actualizar";
    }
    
    public String editarSolicitud () {
        solicitudFacade.edit(solicitud);
        solicitud = new Solicitud();
        return "Lista";
    }
    
    public void eliminarSolicitud() {
        solicitudFacade.remove(solicitud);
    }
    
}
