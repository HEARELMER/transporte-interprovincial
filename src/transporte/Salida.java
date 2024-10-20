/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporte;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class Salida {
private Vehiculo vehiculo;
    private Ruta ruta;
    private Date fecha;
    public Salida(Vehiculo vehiculo, Date fecha) {
        this.vehiculo = vehiculo;
        this.fecha = fecha;
    }



    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void imprimirSalida() {
    System.out.println("Vehículo: " + vehiculo.getIdentificador()); 
    System.out.println("Conductor: " + vehiculo.getConductor());
    System.out.println("Ruta: " + ruta.getOrigen() + " - " + ruta.getDestino());
    System.out.println("Fecha de salida: " + fecha.toString());
}

}
