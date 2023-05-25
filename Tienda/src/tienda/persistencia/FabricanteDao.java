package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante.Fabricante;
import tienda.entidades.Fabricante.FabricanteServicios;

public final class FabricanteDao extends DAO {


    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }
            String sql = "INSERT INTO fabricante (nombre) "
                    + "VALUES ( '" + fabricante.getNombre() + " ');";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Fabricante buscarFabricantePorCodibo(Integer codigo) throws Exception {
        try {

            String sql = "SELECT * FROM fabricante "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);

            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));

            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }      

    public void modificarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE Producto SET "
                    + " codigo = '" + fabricante.getCodigo() + "' , nombre = '" + fabricante.getNombre()
                    + " WHERE codigo = '" + fabricante.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarFabricante(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM Fabricante WHERE cdigo = " + codigo + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<Fabricante> listarFabricante() throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante ";
            consultarBase(sql);
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo"));
                fabricante.setNombre(resultado.getString("nombre"));
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}


