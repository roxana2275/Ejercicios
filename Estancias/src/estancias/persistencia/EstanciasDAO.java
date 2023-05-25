/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.persistencia;

import estancias.entidades.Estancia;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Usuario
 */
public class EstanciasDAO extends DAO {

    public Collection<Estancia> listaEstancias() throws Exception {

        try {
            String sql = "SELECT * FROM estancias";
            consultarBase(sql);
            Collection<Estancia> estancias = new ArrayList<>();
            while (resultado.next()) {
                Estancia estancia = new Estancia();
                estancia.setId_estancia(resultado.getInt(1));
                estancia.setId_cliente(resultado.getInt(2));
                estancia.setId_casa(resultado.getInt(3));
                estancia.setNombre_huesped(resultado.getString(4));
                estancia.setFecha_desde(resultado.getDate(5));
                estancia.setFecha_hasta(resultado.getDate(6));
                estancias.add(estancia);
            }
            desconectarBase();
            return estancias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
