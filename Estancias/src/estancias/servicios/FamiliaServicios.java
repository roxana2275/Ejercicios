
package estancias.servicios;

import estancias.entidades.Familia;
import estancias.persistencia.FamiliaDAO;
import java.util.Collection;

public class FamiliaServicios {
    
    private FamiliaDAO dao;

    
    
    public FamiliaServicios(){
        this.dao = new FamiliaDAO();
    }
    
    public void listadoFamilias() throws Exception{
        try {
            Collection<String> familias = dao.listaFamiliaPuntoA();

            for (String familia : familias) {
                System.out.println(familia);
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void listdoFamiliasC() throws Exception{
        try {
            Collection<Familia> familias = dao.listaFamiliaPuntoC();
            for (Familia familia : familias) {
                System.out.println(familia.getNombre());
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
}
