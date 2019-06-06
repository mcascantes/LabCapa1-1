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
        lClientes = new ListaClientes();//Variable de Tipo Lista Clientes usuado para acceder a la Lista
    }
    
    public boolean agregar ( boolean esEmpresa,int codigo, String nombre, String correo, String telefono, 
                        String contacto, int ext,FormaPago FormaPago ){//Metodo que agrega un un Cliente a la Lista
        
        
        
        if(esEmpresa){//Verifica si es una Empresa
            Empresa E=new Empresa();//Creamos un nuevo Cliente de tipo Empresa
            //Seteamos los valores enviados por Parámetros al objeto Empresa desde UICliente
            E.setId(codigo);
            E.setNombre(nombre);
            E.setCorreo(correo);
            E.setTelefono(telefono);
            E.setContacto(contacto);
            E.setExtension(ext);
            E.setFormaPago(FormaPago); 
             return lClientes.agregar(E);//Enviamos el Cliente Completo a Ser agregado a la lista
        }else{
            Cliente C=new Cliente();//Creamos un nuevo Cliente de tipo Cliente desde UICliente 
            //Seteamos los valores enviados por Parámetros al objeto Cliente
            C.setId(codigo);
            C.setNombre(nombre);
            C.setCorreo(correo);
            C.setTelefono(telefono);
            return lClientes.agregar(C);//Enviamos el Cliente Completo a Ser agregado a la lista
        }    
               
        
    }
    
    public ArrayList Listar(){
        return lClientes.getLista();//Obtiene Toda la Lista de Clientes y los Envía a UIClintes
    
    }   

    public Cliente buscar(int id){//Metodo para Obtener un Cliente por su Id
        return lClientes.buscar(id);//Retorna el Cliente Obtenido de ListaClientes mediante la Busqueday los Envía a UICleintes
    }
    
    public boolean modificarPersona ( int codigo, String nombre, String correo, String telefono ,FormaPago fp){
               //Obtiene por Parametros todos los valores de un cliente por parámetros
            Cliente C=new Cliente();//Se crea un Nuevo cliente y se setean sus valores
            C.setId(codigo);
            C.setNombre(nombre);
            C.setCorreo(correo);
            C.setTelefono(telefono);
            return lClientes.modificar(C);//Se envía todo el Cliente a Modificar a ListaClientes, si lo hace retorna true de lo contrario false
    }

    public boolean modificarEmpresa ( int codigo, String nombre, String correo, String telefono, 
                        String contacto, int ext,FormaPago FormaPago){
        //Obtiene por Parametros todos los valores de un cliente por parámetros
        Empresa E=new Empresa();//Se crea un Nuevo cliente de tipo Empresa y se setean sus valores
            E.setId(codigo);
            E.setNombre(nombre);
            E.setCorreo(correo);
            E.setContacto(contacto);
            E.setExtension(ext);
            E.setFormaPago(FormaPago); 
             
        return lClientes.modificar((Cliente)E);//Se envía todo el Cliente a Modificar a ListaClientes, si lo hace retorna true de lo contrario false
    }
    
    public boolean eliminar(int id){//Metodo para eliminar un Cliente por su ID
        
        return lClientes.eliminar(id);//Se llama al metodo eliminar de Lista Clientes para que busque y retorne un boleano de verificacion
    }
    
}
