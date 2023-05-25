/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.persistencia;

import estancias.entidades.Familia;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Usuario
 */
public class FamiliaDAO extends DAO{
    
    public Collection<String> listaFamiliaPuntoA() throws Exception{
        try {
            String sql = "SELECT nombre FROM familias WHERE num_hijos <=3 AND edad_maxima<10";
            consultarBase(sql);
            String familiaNombre = null;
            Collection<String> familias = new ArrayList<>();
            while(resultado.next()){
                familiaNombre=resultado.getString(1);
                familias.add(familiaNombre);               
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
        public Collection<Familia> listaFamiliaPuntoC() throws Exception{
        try {
            String sql = "SELECT * FROM familias WHERE email LIKE '%@hotmail%'";
            consultarBase(sql);
            Familia familia = null;
            Collection<Familia> familias = new ArrayList<>();
            while(resultado.next()){
                familia = new Familia();
                familia.setId_familia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setId_casa_familia(resultado.getInt(7));
                familias.add(familia);               
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
