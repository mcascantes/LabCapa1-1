/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import enumerados.FormaPago;

/**
 *
 * @author M-01
 */
public class Empresa  extends Cliente{
    private int extension;
    private String contacto;
    private FormaPago formaPago;

    public Empresa() {
    }

    public Empresa(int id, String nombre, String correo, String telefono,int extension, String contacto, FormaPago formaPago ) {
        super(id, nombre, correo, telefono);
        this.extension = extension;
        this.contacto = contacto;
        this.formaPago = formaPago;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public String toString() {
        return "Empresa{" + super.toString() +" extension=" + extension + ", contacto=" + contacto + ", formaPago=" + formaPago + '}';
    }
    
    
    
}
