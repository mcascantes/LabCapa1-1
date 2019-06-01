/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Cliente;
import datos.Empresa;
import enumerados.FormaPago;
import java.util.ArrayList;

/**
 *
 * @author M-01
 */
public class AdmCliente {

    private ListaClientes lClientes;
    
    public AdmCliente() {
        lClientes = new ListaClientes();
    }
    
    public boolean agregar ( boolean esEmpresa,int codigo, String nombre, String correo, String telefono, 
                        String contacto, int ext,FormaPago FormaPago ){
        
        
        
        if(esEmpresa){
        Empresa E=new Empresa();
            E.setId(codigo);
            E.setNombre(nombre);
            E.setCorreo(correo);
            E.setContacto(contacto);
            E.setExtension(ext);
            E.setFormaPago(FormaPago); 
             return lClientes.agregar(E);
        }else{
            Cliente C=new Cliente();
            C.setId(codigo);
            C.setNombre(nombre);
            C.setCorreo(correo);
            C.setTelefono(telefono);
            return lClientes.agregar(C);
        }    
        
        
        
    }
    
    public ArrayList Listar(){
        return lClientes.getLista();
    
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
