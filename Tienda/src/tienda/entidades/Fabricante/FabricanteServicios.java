
package tienda.entidades.Fabricante;

import tienda.persistencia.FabricanteDao;

public class FabricanteServicios {
 
    private FabricanteDao dao;

    public FabricanteServicios() {
        this.dao = new FabricanteDao();
    }

    
    public void cargarFabricante(String nombre) throws Exception{
        try {
            if(nombre == null ||nombre.trim().isEmpty()){
                throw new Exception ("Debe ingresar el nombre");
            }
            
            Fabricante fabricante = new Fabricante();
            
            fabricante.setNombre(nombre);
            dao.guardarFabricante(fabricante);
            
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarFabricantePorCodigo(int codigo, String nombre) throws Exception{
        try {
            if(codigo<0){
                throw  new Exception ("Debe ingresar el codigo");
            }
            if(nombre == null || nombre.trim().isEmpty()){
                throw new Exception ("Debe ingresar un nombre");
            }
            
            
        } catch (Exception e) {
        }
    }
    
    public void eliminarFabricantePorCodigo(int codigo) throws Exception{
            try {
                if(codigo<0){
                    throw  new Exception ("Debe ingresar un codigo valido");
                }
                
                dao.eliminarFabricante(codigo);
            } catch (Exception e) {
                throw e;
            }
    }
    
    public Fabricante buscarFabricantePorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            Fabricante fabricante = dao.buscarFabricantePorCodibo(codigo);
            //Verificamos
            if (fabricante == null) {
                throw new Exception("No se econtró un fabricante con ese codigo");
            }

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
