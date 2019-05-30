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
     public ArrayList getLista()
     {
        return lista;
     }
    
    public boolean agregar(Cliente c){
        
        try{
            lista.add(c);
            return true;
        }catch(Exception e)
        {
            return false;
        }
        
    }

    public Cliente buscar(int id){
        int _id=0;
        
        for (Cliente cliente : lista) {
            _id=cliente.getId();
            if(_id==id)
            {
                return cliente;
            }
        }
        return null;
    }
    
    public boolean modificar(Cliente c){
        
        int index=lista.indexOf(c);
        
        if(index != -1)        
        {
            lista.set(index, c);
            return true;
        }else{
            return false;
        }
        
        
    }
    
    public boolean eliminar(int id){
        int _id=0; 
        
        for (Cliente cliente : lista) {
            _id=cliente.getId();
            if(_id==id)
            {               
                return lista.remove(cliente);               
            }
            
        }
        
        return false;
    }
}
