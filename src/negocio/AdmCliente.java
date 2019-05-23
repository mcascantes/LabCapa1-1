/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Cliente;
import enumerados.FormaPago;

/**
 *
 * @author M-01
 */
public class AdmCliente {

    private ListaClientes lClientes;
    
    public AdmCliente() {
        lClientes = new ListaClientes();
    }
    
    public boolean agregar ( int id, String n, String c, String t, 
                        float pb, int lc ){
        return true;
    }

    public boolean agregar ( int id, String n, String c, String t, 
                        int e, int contacto, FormaPago fp){
        return true;
    }

    public Cliente buscar(int id){
        return null;
    }
    
    public boolean modificar ( int id, String n, String c, String t, 
                        float pb, int lc ){
        return true;
    }

    public boolean modificar ( int id, String n, String c, String t, 
                        int e, int contacto, FormaPago fp){
        return true;
    }
    
    public boolean eliminar(int id){
        return true;
    }
    
}
