
package estancias.servicios;

import estancias.entidades.Cliente;
import estancias.persistencia.ClientesDAO;
import java.util.Collection;

public class ClienteServicios {
    
    private ClientesDAO dao;
    
     public ClienteServicios(){
        this.dao = new ClientesDAO();
    } 
     
    public void listadoClientes() throws Exception{
        try {
            Collection<Cliente> clientes = dao.listadoClientes();
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
                
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Cliente clientePorId(int id_cliente) throws Exception{
        try {
            Cliente cliente = new Cliente();
            cliente = dao.datosCliente(id_cliente);
            return cliente;
        } catch (Exception e) {
            throw e;
        }
    }
}
