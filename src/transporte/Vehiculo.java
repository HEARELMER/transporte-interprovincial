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
       public boolean asignarPasajero(Cliente pasajero){
        if(asientosOcupados < asientos.length){
            if(this.asientos[asientosOcupados]!= null ){
                System.out.println("Asineto ocupado");
                return false;
            }
            
            this.asientos[asientosOcupados] = pasajero;
            asientosOcupados++;
            System.out.println("Se registró con éxito");
            return true;
        }else{
            System.out.println("Ya está lleno");
            return false;
        }
    }
       
      public boolean eliminarPasajero(String dni) {
    for (int i = 0; i < asientosOcupados; i++) {
        if (asientos[i].getDni().equals(dni)) {
            // Desplazar los elementos hacia la izquierda para eliminar el pasajero
            for (int j = i; j < asientosOcupados - 1; j++) {
                asientos[j] = asientos[j + 1];
            }
            asientos[asientosOcupados - 1] = null; // Liberar el último asiento
            asientosOcupados--; // Reducir el número de asientos ocupados
            System.out.println("Pasajero eliminado con éxito.");
            return true;
        }
    }
    System.out.println("Pasajero no encontrado.");
    return false;
}

    
public void imprimirPasajeros() {
    if (asientosOcupados == 0) {
        System.out.println("No hay pasajeros en este vehículo.");
        return;
    }

    System.out.println("Lista de pasajeros:");
    for (int i = 0; i < asientosOcupados; i++) {
        Cliente pasajero = asientos[i];
        System.out.println((i + 1) + ". Nombre: " + pasajero.getNombre() + ", DNI: " + pasajero.getDni());
    }
}

}
