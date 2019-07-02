
package controlador;

import entidades.Catalogo;
import facade.CatalogoFacade;
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
@Named(value = "catalogoControlador")
@SessionScoped
public class CatalogoControlador implements Serializable {

    @EJB
    CatalogoFacade catalogoFacade;
    Catalogo catalogo = new Catalogo();
    @PostConstruct
    public void init() {
        catalogo = new Catalogo();
    }

public CatalogoControlador() {
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public List<Catalogo> consultarCatalogo() {
        return catalogoFacade.findAll();
    }

    public String crearCatalogo() {
        catalogoFacade.create(catalogo);
        this.catalogo = new Catalogo();
        return "gestionar-catalogo";
    }

    public void preEditarCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public void editarCatalogo() {
        catalogoFacade.edit(catalogo);
        catalogo = new Catalogo();
    }

    public void eliminarCatalogo(Catalogo catalogo) {
        catalogoFacade.remove(catalogo);
        //return "Lista";
    }

}
