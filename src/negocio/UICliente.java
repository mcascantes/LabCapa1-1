/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Cliente;
import datos.Empresa;
import enumerados.FormaPago;
import interfaz.FRClientes;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        
        if(!Utilitarios.esNumero(ventana.TxtCodigo.getText()))
            {
                JOptionPane.showMessageDialog(ventana,"El código debe ser numérico","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }              
        
        if(!Utilitarios.esEmailCorrecto(ventana.TxtCorreo.getText()))
            {
                JOptionPane.showMessageDialog(ventana,"El correo no es válido","Error",JOptionPane.ERROR_MESSAGE);
                return; 
            }
        
        
       if(!Utilitarios.existeCliente(adm,Integer.parseInt(ventana.TxtCodigo.getText())))
         {              
              
            int codigo=Integer.parseInt(ventana.TxtCodigo.getText());
            String nombre=ventana.TxtNombre.getText();
            String correo=ventana.TxtCorreo.getText();
            String telefono=ventana.TxtTelefono.getText();
            String contacto=ventana.TxtContacto.getText();
            int ext=0;
            if(esEmpresa)
            {
                if(!Utilitarios.esNumero(ventana.TxtExt.getText()))
                {
                    JOptionPane.showMessageDialog(ventana,"La extensión debe ser numérica","Error",JOptionPane.ERROR_MESSAGE);
                    return; 
                }
                ext=Integer.parseInt(ventana.TxtExt.getText());
            }
            FormaPago formaPago=(FormaPago)ventana.ComboFP.getSelectedItem();       

            boolean resultado =adm.agregar(esEmpresa,codigo, nombre, correo, telefono, contacto, ext,formaPago); 
             if(resultado)   
             {
                    JOptionPane.showMessageDialog(ventana,"Cliente Agregado correctamente","Info",JOptionPane.INFORMATION_MESSAGE);
                    Limpiar(ventana);
             }
                else
                    JOptionPane.showMessageDialog(ventana,"Error al Agregar Cliente","Error",JOptionPane.ERROR_MESSAGE);
             
         }else{
        JOptionPane.showMessageDialog(ventana,"El Cliente ya Existe","Error",JOptionPane.ERROR_MESSAGE);
       }
    }
    
    
    
    public void buscar(FRClientes ventana)
    {
        int codigo=Integer.parseInt(ventana.TxtCodigo.getText());        
        Cliente C=adm.buscar(codigo);
        
        if(C!=null)
        {
            ventana.TxtCodigo.setText(String.valueOf(C.getId()));
            ventana.TxtNombre.setText(C.getNombre());
            ventana.TxtCorreo.setText(C.getCorreo());
            ventana.TxtTelefono.setText(C.getTelefono());
            ventana.TxtContacto.setText(((Empresa)C).getContacto());
            ventana.TxtExt.setText(String.valueOf(((Empresa)C).getExtension()));
            ventana.ComboFP.setSelectedItem(((Empresa)C).getFormaPago());
            if(!((Empresa)C).getContacto().isEmpty())
            {
                ventana.ChkEmpresa.setSelected(true);
            }
            
        }else{
         JOptionPane.showMessageDialog(ventana,"No existe Cliente","Error",JOptionPane.ERROR_MESSAGE);
        }
        
       
        
        
    }
    
    public ArrayList Listar(){
        
        return adm.Listar();
    }  
    public void modificar(FRClientes ventana){
        
        //Se obtienen todos los valores de las Componentes del Formulario Jtexfield, ComboBox, etc
        boolean esEmpresa=ventana.ChkEmpresa.isSelected();
        int codigo=Integer.parseInt(ventana.TxtCodigo.getText());
        String nombre=ventana.TxtNombre.getText();
        String correo=ventana.TxtCorreo.getText();
        String telefono=ventana.TxtTelefono.getText();
        String contacto=ventana.TxtContacto.getText();
        FormaPago formaPago=(FormaPago)ventana.ComboFP.getSelectedItem();
        int ext=0;
        
        if(esEmpresa)//Se verifica si es una Empresa
        {            
            ext=Integer.parseInt(ventana.TxtExt.getText());//Se establece la extension en la variable
            //Se llama al Metodo en AdmCliente para Modificar una Empresa
            boolean resultado=adm.modificarEmpresa(codigo, nombre, correo, telefono, contacto, ext, formaPago);
            
            if(resultado)  //Si la modificación es exitosa de muestra mensaje de Alerta de exito o error al usuario      
                JOptionPane.showMessageDialog(ventana,"Empresa Modificada","Info",JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(ventana,"Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);
            
        }else{//Si no es una Empresa se Modifica una Persona y solo se envían los campos relacionado a personas
             //Se llama al Metodo en AdmCliente para Modificar una Persona
            boolean resultado=adm.modificarPersona(codigo, nombre, correo, telefono, formaPago);
            
            if(resultado) //Si la modificación es exitosa de muestra mensaje de Alerta de exito o error al usuario       
                JOptionPane.showMessageDialog(ventana,"Cliente Modificado","Info",JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(ventana,"Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);
        }
              
    
    }
    public void eliminar(FRClientes ventana){
    
    int codigo=Integer.parseInt(ventana.TxtCodigo.getText()); //Se obtiene el codigo de la Caja de Texto       
        
    if(adm.eliminar(codigo))    //Se envía el codigo a AdmCliente y Si la eliminación es exitosa de muestra mensaje de Alerta de exito o error al usuario
            JOptionPane.showMessageDialog(ventana,"Cliente Eliminado","Info",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(ventana,"Error al Eliminar","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void Limpiar(FRClientes ventana)//Metodo que limpia las cajas de texto
    {
    
            ventana.TxtCodigo.setText("");
            ventana.TxtNombre.setText("");
            ventana.TxtCorreo.setText("");
            ventana.TxtTelefono.setText("");
            ventana.TxtContacto.setText("");
            ventana.TxtExt.setText("");
            ventana.ComboFP.setSelectedItem("");
    }
    
}
