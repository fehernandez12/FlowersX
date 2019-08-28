/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Producto;
import facade.ProductoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Aprendiz
 */
@Named(value = "productoControlador")
@SessionScoped
public class ProductoControlador implements Serializable {

    /**
     * Creates a new instance of ProductoControlador
     */
    public ProductoControlador() {
    }
    
    @EJB
    ProductoFacade productoFacade;
    Producto producto = new Producto();
    private List<Producto> ListaProducto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
     public List<Producto> consultarProducto() {
        return productoFacade.findAll();
    }
     
      public String crearProducto() {
        productoFacade.create(producto);
        producto = new Producto();
        return "gestionar-producto.xhtml";
    }
      
      
       public String preEditarProducto(Producto producto) {
        this.producto = producto;
        return "editar-producto.xhtml";
    }
      public String editarProducto() {
        productoFacade.edit(producto);
        producto = new Producto();
        return "gestionar-producto.xhtml";
    }
      
       public void eliminarProducto(Producto producto) {
        productoFacade.remove(producto);        
    }
}
