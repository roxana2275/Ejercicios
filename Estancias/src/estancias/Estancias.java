package estancias;

import estancias.servicios.CasaServicios;
import estancias.servicios.ClienteServicios;
import estancias.servicios.EstanciaServicios;
import estancias.servicios.FamiliaServicios;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Estancias {

    public static void main(String[] args) throws Exception {
        /*) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.
b) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 
2020 y el 31 de agosto de 2020 en Reino Unido.
c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
d) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada 
y un número de días específico.
e) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la 
descripción de la casa donde la realizaron.
17
f) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y 
ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a 
la anterior
g) Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el 
precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios 
actualizados.
h) Obtener el número de casas que existen para cada uno de los países diferentes.
i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) 
que están ‘limpias’.
j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas*/
        String opcion = "a";
        FamiliaServicios fs = new FamiliaServicios();
        CasaServicios cs = new CasaServicios();
        ClienteServicios cls = new ClienteServicios();
        EstanciaServicios es = new EstanciaServicios();
        Scanner leer = new Scanner (System.in);
        do {
            System.out.println("Seleccione una de las siguientes opciones");
            System.out.println("a) Familias hasta 3 hijos y edad máxima 10 años");
            System.out.println("b) Casas disponibles entre el 1/08/2020 y 31/08/2020 en Reino Unido");
            System.out.println("c) Familias con mail Hotmail");
            System.out.println("d) Casas disponibles a partir de una fecha dada y un número de días específico.");
            System.out.println("e) Datos de clientes con estancia y descripción de la casa");
            System.out.println("f) Estancias que han sido reservadas por un cliente con nombre, país, ciudad y además la información de la casa que reservó.");
            System.out.println("g) Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.");
            System.out.println("h) Obtener el número de casas que existen para cada uno de los países diferentes.");
            System.out.println("i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios)que están ‘limpias’.");
            System.out.println("j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas");
            opcion = leer.next().toLowerCase();
            switch (opcion) {
                case "a":
                    fs.listadoFamilias();
                    break;
                case "b":
                    System.out.println(cs.listadoCasas());
                    break;
                case "c":
                    fs.listdoFamiliasC();
                    break;
                case "d":
                    System.out.println("Ingrese el día de ingreso");
                    int dia = leer.nextInt();
                    System.out.println("Ingrese el mes de ingreso");
                    int mes = leer.nextInt();
                    System.out.println("Ingrese el año de ingreso");
                    int anio = leer.nextInt();
                    LocalDate diaComp = LocalDate.of(anio, mes, dia);    
                    Date date = java.sql.Date.valueOf(diaComp);
                    System.out.println("Ingrese la cantidad de días de alojamiento");
                    int diasAlojamiento = leer.nextInt();
                    // No me sale comparar las fechas en java con mysql
                    
                    cs.casasDesdeTiempo(date, diasAlojamiento);
                    break;
                case "e":
                    es.resultadoEstancias();
                    break;
                case "f":
                    System.out.println("Ingrese el id del cliente");
                    int cliente = leer.nextInt();
                    es.resultadoEstanciasPorCliente(cliente);
                    break;
                case "g":
                    break;
                case "h":
                    cs.casasPorPais();
                    break;
                case "i":
                    cs.casasLimpias();
                    break;
                default:
                    System.out.println("Opcion no valida");;
            }
        } while (!"z".equals(opcion));

    }

}