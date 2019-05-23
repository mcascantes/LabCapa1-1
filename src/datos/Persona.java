/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author M-01
 */
public class Persona extends Cliente{
    
private float porcentajeBeca;
private int numLetraCambio;

    public Persona() {
    }

    public Persona(int id, String nombre, String correo, String telefono, float porcentajeBeca, int numLetraCambio ) {
        super(id, nombre, correo, telefono);
        this.porcentajeBeca = porcentajeBeca;
        this.numLetraCambio = numLetraCambio;
    }

    public int getNumLetraCambio() {
        return numLetraCambio;
    }

    public void setNumLetraCambio(int numLetraCambio) {
        this.numLetraCambio = numLetraCambio;
    }

    public float getPorcentajeBeca() {
        return porcentajeBeca;
    }

    public void setPorcentajeBeca(float porcentajeBeca) {
        this.porcentajeBeca = porcentajeBeca;
    }

    @Override
    public String toString() {
        return "Persona{" + super.toString()+ " porcentajeBeca=" + porcentajeBeca + ", numLetraCambio=" + numLetraCambio + '}';
    }


}
