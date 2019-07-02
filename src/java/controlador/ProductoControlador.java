/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Catalogo;
import entidades.OrdenProduccion;
import entidades.Producto;
import facade.CatalogoFacade;
import facade.OrdenProduccionFacade;
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
    @EJB
    ProductoFacade productoFacade;
    Producto producto = new Producto();
    
    @EJB
    OrdenProduccionFacade ordenProduccionFacade;
    OrdenProduccion ordenProduccion = new OrdenProduccion();
    
    @EJB
    CatalogoFacade catalogoFacade;
    Catalogo catalogo = new Catalogo();
   
    public ProductoControlador() {
    }
    
    public Producto getProducto(){
        return producto;
    }
    
    public void setProducto(Producto producto){
        this.producto =producto;
    }
    
    public OrdenProduccion getOrdenProduccion() {
        return ordenProduccion;
    }

    public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
        this.ordenProduccion = ordenProduccion;
    }
    
     public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
    
    public List<Producto> consultarProducto() {
        return productoFacade.findAll();
        
    }

    public String crearProducto() {
        producto.setOrdenDeProduccionidOrdenDeProduccion(ordenProduccionFacade.find(ordenProduccion.getIdOrdenDeProduccion()));
        producto.setCatalogoidCatalogo(catalogoFacade.find(catalogo.getIdCatalogo()));
        productoFacade.create(producto);
        producto = new Producto();
        return "gestionar-producto";
    }

    public String preEditarProducto(Producto producto) {
        this.producto = producto;
        return "editar-producto";
    }

    public String editarProducto() {
        producto.setOrdenDeProduccionidOrdenDeProduccion(ordenProduccionFacade.find(ordenProduccion.getIdOrdenDeProduccion()));
        producto.setCatalogoidCatalogo(catalogoFacade.find(catalogo.getIdCatalogo()));
        
        productoFacade.edit(producto);
        producto = new Producto();
        return "gestionar-producto";
    }

    public void eliminarProducto(Producto producto) {
        productoFacade.remove(producto);
        //return "Lista";
    }
    
    
}

