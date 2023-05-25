
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto.Producto;

public final class ProductoDao extends DAO{


    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }
            String sql = "INSERT INTO producto ( nombre, precio, codigo_fabricante) "
                    + "VALUES ( '" + producto.getNombre() + "' ," + producto.getPrecio()+","+producto.getCodigoFabricante() + ");";
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            System.out.println("Ingreso en dao");
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            
            String sql = "UPDATE producto SET "
                    + " codigo = " + producto.getCodigo() + " , nombre = '" + producto.getNombre()+ "', precio = "+producto.getPrecio()+" , codigo_fabricante = " + producto.getCodigoFabricante()
                    + " WHERE codigo = " + producto.getCodigo();
            
            
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM Producto WHERE cdigo = " + codigo + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM Producto WHERE codigo = " + codigo + "";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    

    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM producto ";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
   public Producto productoMenorPrecio() throws Exception {
        try {
            String sql = "SELECT * FROM producto ORDER BY producto.precio ASC LIMIT 1;";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    } 
    

}
