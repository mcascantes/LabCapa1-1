/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Cliente;
import java.util.ArrayList;

/**
 *
 * @author M-01
 */
public class ListaClientes {
    private ArrayList<Cliente> lista;

    public ListaClientes() {
        lista = new ArrayList<Cliente>();
    }
    
    public boolean agregar(Cliente c){
        return true;
    }

    public Cliente buscar(int id){
        return null;
    }
    
    public boolean modificar(Cliente c){
        return true;
    }
    
    public boolean eliminar(int id){
        return true;
    }
}
