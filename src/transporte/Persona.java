/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporte;

/**
 *
 * @author ACER
 */
public abstract class Persona {

    public Persona(String nombre, int edad, String telefono, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.dni = dni;
    }
   protected String nombre;
   protected int edad;
   protected String telefono;
   protected String dni;
    
    public abstract void imprimir();
}
