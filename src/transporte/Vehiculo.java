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

public class Vehiculo {

    private String identificador;
    private Conductor conductor;
    private int capacidad;
    private Cliente[] asientos;

    private int asientosOcupados;

    public Vehiculo(String identificador, Conductor conductor, int capacidad) {
        this.identificador = identificador;
        this.conductor = conductor;
        this.capacidad = capacidad;
        this.asientos = new Cliente[capacidad];
        this.asientosOcupados = 0;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getAsientosOcupados() {
        return asientosOcupados;
    }

    public void setAsientosOcupados(int asientosOcupados) {
        this.asientosOcupados = asientosOcupados;
    }

    public void mostrarConductor(){
        conductor.imprimir();
    }
    public boolean asignarPasajero(Cliente pasajero) {
        if (asientosOcupados < asientos.length) {
            if (this.asientos[asientosOcupados] != null) {
                System.out.println("Asineto ocupado");
                return false;
            }

            this.asientos[asientosOcupados] = pasajero;
            asientosOcupados++;
            System.out.println("Se registró con éxito");
            return true;
        } else {
            System.out.println("Ya está lleno");
            return false;
        }
    }

    public boolean eliminarPasajero(String dni) {
        for (int i = 0; i < asientosOcupados; i++) {
            if (asientos[i] != null && asientos[i].getDni().equals(dni)) {
                asientos[i] = null;
                System.out.println("Pasajero eliminado con éxito.");
                return true;
            }
        }
        System.out.println("Pasajero no encontrado.");
        return false;
    }

    public void imprimirPasajeros() {
        System.out.println("Lista de pasajeros:");
        for (int i = 0; i < asientosOcupados; i++) {
            if (asientos[i] != null) { 
                System.out.println("Pasajero " + (i + 1) + ":");
                System.out.println("Nombre: " + asientos[i].getNombre());
                System.out.println("DNI: " + asientos[i].getDni());
                System.out.println("Edad: " + asientos[i].getEdad());
                System.out.println("Teléfono: " + asientos[i].getTelefono());
                System.out.println("-------------------------");
            }
        }
    }

    public void imprimirMapaAsientos() {
        System.out.println("Mapa de asientos:");
        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i] != null) {
                System.out.println("Asiento " + (i + 1) + ": Ocupado por " + asientos[i].getNombre());
            } else {
                System.out.println("Asiento " + (i + 1) + ": Libre");
            }
        }
    }
}
