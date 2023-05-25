/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.persistencia;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import estancias.entidades.Casa;
import estancias.entidades.ResultadoConsulta;
import java.util.ArrayList;
import java.util.Collection;


/**
 *
 * @author Usuario
 */
public class CasasDAO extends DAO{
    
    public Collection<String> listaCasasB() throws Exception{
        
        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde>='2020-08-01'AND fecha_hasta <='2020-08-31' AND pais = 'Reino Unido'";
            consultarBase(sql);
            String casa = null;
            Collection<String> casas = new ArrayList<>();
            while(resultado.next()){
                casa=resultado.getString(1);
                casas.add(casa);               
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
        public Casa datosCasa(int id_casa) throws Exception{
        try {
            String sql = "SELECT * FROM casas";
            consultarBase(sql);
            Casa casa = new Casa();
           while(resultado.next()){
               if(resultado.getInt(1)==id_casa){
                   casa.setId_casa(resultado.getInt(1));
                   casa.setCalle(resultado.getString(2));
                   casa.setNumero(resultado.getInt(3));
                   casa.setCodigo_postal(resultado.getString(4));
                   casa.setCiudad(resultado.getString(5));
                   casa.setPais(resultado.getString(6));
                   casa.setFecha_desde(resultado.getDate(7));
                   casa.setFecha_hasta(resultado.getDate(8));
                   casa.setTiempo_minimo(resultado.getInt(9));
                   casa.setTiempo_minimo(resultado.getInt(10));
                   casa.setPrecio_habitacion(resultado.getDouble(11));
                   casa.setTipo_vivienda(resultado.getString(12));
               }
           }
           desconectarBase();
           return casa;
        } catch (Exception e) {
            throw e;
        }
    }
        
      public Collection<Casa> listadoCasas() throws Exception{
          try {
              Collection<Casa> casas = new ArrayList();
              Casa casa = null;
              String sql = "SELECT * FROM casas";
              consultarBase(sql);
              while(resultado.next()){
                  casa = new Casa();
                  casa.setId_casa(resultado.getInt(1));
                   casa.setCalle(resultado.getString(2));
                   casa.setNumero(resultado.getInt(3));
                   casa.setCodigo_postal(resultado.getString(4));
                   casa.setCiudad(resultado.getString(5));
                   casa.setPais(resultado.getString(6));
                   casa.setFecha_desde(resultado.getDate(7));
                   casa.setFecha_hasta(resultado.getDate(8));
                   casa.setTiempo_minimo(resultado.getInt(9));
                   casa.setTiempo_minimo(resultado.getInt(10));
                   casa.setPrecio_habitacion(resultado.getDouble(11));
                   casa.setTipo_vivienda(resultado.getString(12));
                  casas.add(casa);
              }
              desconectarBase();
              return casas;
          } catch (Exception e) {
              throw e;
          }
      }
      
      public ArrayList<ResultadoConsulta> casasPorPais() throws Exception{
          try {
              String sql = "SELECT casas.pais, COUNT(*) FROM casas GROUP BY casas.pais";
              consultarBase(sql);
              ArrayList<ResultadoConsulta> lista = new ArrayList<>();
              while(resultado.next()){
                  ResultadoConsulta consulta = new ResultadoConsulta();
                  consulta.setPais(resultado.getString(1));
                  consulta.setCantidad(resultado.getInt(2));
                  lista.add(consulta);
              }
              desconectarBase();
              return lista;
  
          } catch (Exception e) {
              throw e;
          }
      }

      public Collection<Casa> casasLimpias() throws Exception{
          
          try {
              Collection<Casa> casas = new ArrayList();
              Casa casa = null;
              String sql = "SELECT * FROM casas INNER JOIN comentarios ON casas.id_casa=comentarios.id_casa WHERE comentario like '%limpia%' AND pais = 'Reino Unido'";
              consultarBase(sql);
              while(resultado.next()){
                  casa = new Casa();
                  casa.setId_casa(resultado.getInt(1));
                   casa.setCalle(resultado.getString(2));
                   casa.setNumero(resultado.getInt(3));
                   casa.setCodigo_postal(resultado.getString(4));
                   casa.setCiudad(resultado.getString(5));
                   casa.setPais(resultado.getString(6));
                   casa.setFecha_desde(resultado.getDate(7));
                   casa.setFecha_hasta(resultado.getDate(8));
                   casa.setTiempo_minimo(resultado.getInt(9));
                   casa.setTiempo_minimo(resultado.getInt(10));
                   casa.setPrecio_habitacion(resultado.getDouble(11));
                   casa.setTipo_vivienda(resultado.getString(12));
                  casas.add(casa);
              }
              desconectarBase();
              return casas;
          } catch (Exception e) {
              throw e;
          }
      }
    }
    

