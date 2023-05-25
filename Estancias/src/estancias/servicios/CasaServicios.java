/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.servicios;

import estancias.entidades.Casa;
import estancias.entidades.ResultadoConsulta;
import estancias.persistencia.CasasDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class CasaServicios {
   private CasasDAO dao;
    
    public CasaServicios(){
        this.dao = new CasasDAO();
    }
    
    public Collection<String> listadoCasas() throws Exception{
        try {
            Collection<String> casas = dao.listaCasasB();

            return casas;
        } catch (Exception e) {
            throw e;
        }
        
    } 
    
    public Casa casaPorId(int id_casa) throws Exception{
        try {
            Casa  casa = new Casa();
            casa  = dao.datosCasa(id_casa);
            
            return casa;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void casasDesdeTiempo(Date dia, int diasEstancia) throws Exception{

        try {
            Collection<Casa> casas = new ArrayList();
            casas=dao.listadoCasas();
            //String dia2 = dia.toString();
            
            for (Casa casa : casas) {
                
                if(casa.getFecha_desde().before(dia)==true
                        && casa.getTiempo_maximo()>=diasEstancia 
                        && diasEstancia<=casa.getTiempo_maximo()){
                    System.out.println(casa);
                }else{
                    System.out.println("No hay casas");
                }
                
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void casasPorPais() throws Exception{
        try {
            ArrayList<ResultadoConsulta> lista = new ArrayList<>();
            lista=dao.casasPorPais();
            
            for (ResultadoConsulta resultadoConsulta : lista) {
                System.out.println("Pais = "+resultadoConsulta.getPais()+" Cantidad = "+resultadoConsulta.getCantidad());
                
            }
        } catch (Exception e) {
            throw e;
        }
        
    }

    public Collection<Casa> casasLimpias() throws Exception{
        try {
            Collection<Casa> casas = new ArrayList();
            casas=dao.casasLimpias();
            for (Casa casa : casas) {
                System.out.println(casa);   
            }
            return casas;
        } catch (Exception e) {
            throw e;
        }
        
    } 

}
