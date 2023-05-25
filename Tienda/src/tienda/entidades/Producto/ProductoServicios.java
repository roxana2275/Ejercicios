
package tienda.entidades.Producto;

import java.util.Collection;
import tienda.persistencia.ProductoDao;

public class ProductoServicios {
     
    private ProductoDao dao;

    public ProductoServicios() {
        this.dao = new ProductoDao();
    }


    public void crearProducto(String nombre, double precio, int codigoFabricante) throws Exception {

        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (precio<0) {
                throw new Exception("Debe indicar un precio mayor a cero");
            }

            if (codigoFabricante <0) {
                throw new Exception("Debe indicar el Fabricante");
            }

            //Creamos el mascota
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);


            dao.guardarProducto(producto);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarCodigoProducto(int codigo, String nombre, Double precio, int codigo_fabricante) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (precio<0) {
                throw new Exception("Debe indicar el precio");
            }

            if (codigo_fabricante < 0) {
                throw new Exception("Debe indicar el fabricante");
            }

            //Buscamos
            Producto producto = buscarProductoPorCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigo_fabricante);
            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(int codigo) throws Exception {

        try {

            //Validamos 
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el id");
            }
            Producto producto = dao.buscarProductoPorCodigo(codigo);
            //Verificamos
            if (producto == null) {
                throw new Exception("No se econtró un producto con ese codigo");
            }

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProducto() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {

        try {

            Collection<Producto> productos = listarProducto();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirProductosPorNombre() throws Exception {

        try {


            Collection<Producto> productos = listarProducto();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void imprimirProductosPorNombreYPrecio() throws Exception {

        try {

            //Listamos los mascotas
            Collection<Producto> productos = listarProducto();

            //Imprimimos los mascotas
            if (productos.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                for (Producto p : productos) {
                    System.out.println("Nombre= "+p.getNombre()+" Precio= "+p.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirProductosPorNombreEntre() throws Exception {

        try {

            //Listamos los mascotas
            Collection<Producto> productos = listarProducto();

            //Imprimimos los mascotas
            if (productos.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                for (Producto p : productos) {
                    if(p.getPrecio()>=120 && p.getPrecio()<=202){
                        System.out.println("Nombre= "+p.getNombre()+" Precio= "+p.getPrecio());
                    }
                    
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirProductoMenorPrecio() throws Exception{
        try {
            Producto producto = new Producto();
            producto = dao.productoMenorPrecio();
            if(producto == null){
                throw new Exception("No existen productos");
            }
            System.out.println(producto);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
