/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.persistencia;

import estancias.entidades.Cliente;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Usuario
 */
public class ClientesDAO extends DAO{
    
    public Collection<Cliente> listadoClientes() throws Exception{
        try {
            String sql = "SELECT * FROM clientes";
            consultarBase(sql);
            Collection<Cliente> clientes = new ArrayList();
            Cliente cliente = null;
            while(resultado.next()){
                cliente = new Cliente();
                cliente.setId_cliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigo_postal(resultado.getString(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
                cliente.setEmail(resultado.getString(8));
                clientes.add(cliente);
            }
            desconectarBase();
            return clientes;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Cliente datosCliente(int id_cliente) throws Exception{
        try {
            String sql = "SELECT * FROM clientes";
            consultarBase(sql);
            Cliente cliente = new Cliente();
           while(resultado.next()){
               if(resultado.getInt(1)==id_cliente){
                   cliente.setId_cliente(resultado.getInt(1));
                   cliente.setNombre(resultado.getString(2));
                   cliente.setCalle(resultado.getString(3));
                   cliente.setNumero(resultado.getInt(4));
                   cliente.setCodigo_postal(resultado.getString(5));
                   cliente.setCiudad(resultado.getString(6));
                   cliente.setPais(resultado.getString(7));
                   cliente.setEmail(resultado.getString(8));
               }
           }
           desconectarBase();
           return cliente;
        } catch (Exception e) {
            throw e;
        }
    }

}
