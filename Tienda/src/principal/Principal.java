package principal;

import java.util.InputMismatchException;
import java.util.Scanner;
import tienda.entidades.Fabricante.FabricanteServicios;
import tienda.entidades.Producto.Producto;
import tienda.entidades.Producto.ProductoServicios;

public class Principal {

    public static void main(String[] args) throws Exception {

        int opcion = 0;
         ProductoServicios ps = new ProductoServicios();
         FabricanteServicios fs = new FabricanteServicios();
        do {
            Scanner leer = new Scanner(System.in);
            System.out.println("Selecciones una de las siguientes opciones");
            System.out.println("1-Lista de productos");
            System.out.println("2-Lista de producto y precio");
            System.out.println("3-Lista de productos con precio entre 120 y 202");
            System.out.println("4-Buscar y listar todos los portatiles");
            System.out.println("5-Mostrar el nombre y el precio del producto mas barato");
            System.out.println("6-Ingresar un producto");
            System.out.println("7-Ingresar un Fabricante");
            System.out.println("8-Modificar un producto");
            System.out.println("9-Salir");
            opcion = leer.nextInt();
           
            switch (opcion) {
                case 1:
                    ps.imprimirProductosPorNombre();
                    break;
                case 2:
                    ps.imprimirProductosPorNombreYPrecio();
                    break;
                case 3:
                    ps.imprimirProductosPorNombreEntre();
                    break;
                case 4:
                    System.out.println("Ingrese el codigo del producto");
                    int codigo = leer.nextInt();
                    System.out.println(ps.buscarProductoPorCodigo(codigo));;
                    break;
                case 5:
                    ps.imprimirProductoMenorPrecio();
                    break;
                case 6:
                    leer.nextLine();
                    System.out.println("Ingrese el nombre del producto");
                    String nombre = leer.nextLine();
                    
                    System.out.println("Ingrese el precio del producto");
                    double precio = leer.nextDouble();
                    System.out.println("Ingrese el codigo del fabricante");
                    int codigoFabricante = leer.nextInt();
                    ps.crearProducto(nombre, precio, codigoFabricante);
                    break;
                case 7:
                    leer.nextLine();
                    System.out.println("Ingrese el nombre del fabricante");
                    String nombreF = leer.nextLine();
                    fs.cargarFabricante(nombreF);
                    break;
                case 8:
                    leer.nextLine();
                    int codigo2;
                    System.out.println("Ingrese el codigo del producto a modificar");
                    try {
                        codigo2 = leer.nextInt();
                    leer.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Error");
                        throw e;
                    }
                    
                    System.out.println("Ingrese el nombre nuevo");
                    String nombre2 = leer.nextLine();
                    System.out.println("Ingrese el precio nuevo");
                    double precio2 = leer.nextDouble();
                    System.out.println("Ingrese el codigo del fabricante");
                    int codigoF = leer.nextInt();
                    ps.modificarCodigoProducto(codigo2, nombre2, precio2, codigoF);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 9);
    }
}
