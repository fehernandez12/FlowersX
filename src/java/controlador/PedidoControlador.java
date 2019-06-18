/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import facade.PedidoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
    
    public PedidoControlador() {
    }
    
}
