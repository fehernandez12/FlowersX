/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Aprendiz
 */
@Named(value = "pagoControlador")
@SessionScoped
public class PagoControlador implements Serializable {

    /**
     * Creates a new instance of PagoControlador
     */
    public PagoControlador() {
    }
    
}