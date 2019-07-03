
package facade;

import entidades.Catalogo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CatalogoFacade extends AbstractFacade<Catalogo> {

    @PersistenceContext(unitName = "FlowersXPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogoFacade() {
        super(Catalogo.class);
    }
    
}
