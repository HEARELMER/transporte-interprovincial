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
public class Conductor extends Persona {


    Conductor(String nombre, int edad, String telefono, String dni) {
        super(nombre, edad, telefono, dni);
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Telefono: " + telefono);
        System.out.println("DNI " + dni);
    }

    @Override
   public String toString() {
    return "nombres: " + nombre + " telefono: " + telefono + " dni: " + dni;
}
}
