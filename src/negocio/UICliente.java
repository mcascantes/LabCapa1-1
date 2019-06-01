/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import enumerados.FormaPago;
import interfaz.FRClientes;
import java.util.ArrayList;

/**
 *
 * @author M-01
 */
public class UICliente {

    private AdmCliente adm;
    
    public UICliente() {
        adm = new AdmCliente();
    }
    
    public void agregar(FRClientes ventana){
     
        boolean esEmpresa=ventana.ChkEmpresa.isSelected();
        int codigo=Integer.parseInt(ventana.TxtCodigo.getText());
        String nombre=ventana.TxtNombre.getText();
        String correo=ventana.TxtCorreo.getText();
        String telefono=ventana.TxtTelefono.getText();
        String contacto=ventana.TxtContacto.getText();
        int ext=0;
        if(esEmpresa)
        {
            ext=Integer.parseInt(ventana.TxtExt.getText());
        }
        FormaPago formaPago=(FormaPago)ventana.ComboFP.getSelectedItem();       
               
        boolean resultado =adm.agregar(esEmpresa,codigo, nombre, correo, telefono, contacto, ext,formaPago);
        
        
        
        
    }
    public ArrayList Listar(){
        
        return adm.Listar();
    }
    public void buscar(FRClientes ventana){}
    public void modificar(FRClientes ventana){}
    public void eliminar(FRClientes ventana){}
    
}
