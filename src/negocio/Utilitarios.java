/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Cliente;
import datos.Empresa;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author laboratorio
 */
public class Utilitarios {
    
    
    
    public static void CargaTabla(ArrayList lista,JTable tabla){//Metodo que carga la tabla del formulario
    
        
        DefaultTableModel dtm=(DefaultTableModel)tabla.getModel();//Creamos un Modelo para los datois
        dtm.setRowCount(0);
        Object[] fila= new Object[dtm.getColumnCount()];//Creamos un objeto de tipo vector para cada columna de la fila
        
         for (int i = 0; i < lista.size(); i++) {//Recorremos la lista para formar la fila
            Cliente c=(Cliente) lista.get(i);
             fila[0]=c.getId();
             fila[1]=c.getNombre();
             fila[2]=c.getCorreo();
             fila[3]=c.getTelefono();
             fila[4]=c instanceof Empresa ? ((Empresa)c).getContacto() + "/" +((Empresa)c).getExtension():"";
             fila[5]=c instanceof Empresa ? ((Empresa)c).getFormaPago():"";
             dtm.addRow(fila);
        }
         
         tabla.setModel(dtm);        
        
    }
    
    public static boolean esNumero(String cadena){ //Verifica si una cadena de texto es numerica o no
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }   
    
    
    
    public static boolean esEmailCorrecto(String email) {//Verifica que el correo esté bien escrito y en formato correcto
       
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
    
    public static boolean existeCliente(AdmCliente adm,int id)//Verifica en la Lista si un Cliente Existe para no ingresarlo 2 veces
    {              
       Cliente C=adm.buscar(id);
       return C!=null && C.getId()==id;
        
    }
    
    
}
