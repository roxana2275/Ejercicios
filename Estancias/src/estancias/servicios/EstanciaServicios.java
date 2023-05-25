/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.servicios;

import estancias.entidades.Casa;
import estancias.entidades.Cliente;
import estancias.entidades.Estancia;
import estancias.persistencia.EstanciasDAO;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Usuario
 */
public class EstanciaServicios {
    
    private EstanciasDAO dao;
    ClienteServicios cls = new ClienteServicios();
    CasaServicios cs = new CasaServicios();
    
     public EstanciaServicios(){
        this.dao = new EstanciasDAO();
    } 
    
    public void resultadoEstancias(){
        
        try {
            Collection<Estancia> estancias = new ArrayList();
            estancias = dao.listaEstancias();
            
            for (Estancia estancia : estancias) {
                Casa casa = new Casa();
                casa = cs.casaPorId(estancia.getId_casa());
                
                Cliente cliente = new Cliente();
                
                cliente = cls.clientePorId(estancia.getId_cliente());
                System.out.print(estancia.getNombre_huesped()+", ");
                System.out.print(cliente.getCiudad()+", ");
                System.out.print(cliente.getPais()+", ");
                System.out.print(casa.getCalle()+", ");
                System.out.print(casa.getNumero()+", ");
                System.out.print(casa.getCiudad()+", ");
                System.out.print(casa.getPais());
                System.out.println("");
            }
            
        } catch (Exception e) {
        }
    }
    
    public void resultadoEstanciasPorCliente(int id_cliente){
        
        try {
            Collection<Estancia> estancias = new ArrayList();
            estancias = dao.listaEstancias();
            
            for (Estancia estancia : estancias) {
                if(estancia.getId_cliente()==id_cliente){
                Casa casa = new Casa();
                casa = cs.casaPorId(estancia.getId_casa());
                
                Cliente cliente = new Cliente();
                
                cliente = cls.clientePorId(estancia.getId_cliente());
                System.out.print(estancia.getNombre_huesped()+", ");
                System.out.print(cliente.getCiudad()+", ");
                System.out.print(cliente.getPais()+", ");
                System.out.print(casa.getCalle()+", ");
                System.out.print(casa.getNumero()+", ");
                System.out.print(casa.getCiudad()+", ");
                System.out.print(casa.getPais());
                System.out.println("");
                }
            }
            
        } catch (Exception e) {
        }
    }
}
