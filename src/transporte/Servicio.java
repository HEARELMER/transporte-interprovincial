/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporte;
//Primero rutas (Ayacucho Lima 50)
//Segundo servicios TIPO(LUEGO), TARIFA(OBLIGAOTRIO) , RUTA(OBLIGATORIO) ---NECESITMAOS CREAR UN CONSTRUCTOR PARA LOS CAMPOS OBLIGATORIOS
//LUEGO PEDIMOS AL VENDEDOR EL TIPO SERVICIO METODO ACTUALZIAR TARIFA DE ACUERDO AL TIPO DE SERVICIO --YA TENEMOS NUESTRO SERVICIO SELECCIONADO



/**
 *
 * @author ACER
 */
public class Servicio {
    private static  final double precioVip = 50;
    private static  final double precioEjecutivo = 30;

    enum TipoServicio{VIP, EJECUTIVO,  NORMAL};
    private TipoServicio tipo;
    private Ruta ruta;
    private double tarifaActual;

    public Servicio( Ruta ruta) {
        this.tarifaActual = ruta.getPrecio();
        this.ruta = ruta;
    }

    public Servicio(TipoServicio tipo, double tarifaActual, Ruta ruta) {
        this.tipo = tipo;
        this.tarifaActual = tarifaActual;
        this.ruta = ruta;
    }


    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }


    public double getTarifaActual () {
        return tarifaActual;
    }

    public void setTarifaActual(double tarifa) {
        this.tarifaActual = tarifa;
    }

    public void calcularTarifa() {
        if (tipo == TipoServicio.VIP) {
            tarifaActual = ruta.getPrecio() + precioVip;
        } else if (tipo == TipoServicio.EJECUTIVO) {
            tarifaActual = ruta.getPrecio() + precioEjecutivo;
        } else {
            tarifaActual = ruta.getPrecio();
        }

    }
    public void imprimir() {
        if (this.tipo != null) {
            System.out.println("Tipo de servicio: " + tipo);
        }
        System.out.println("Tarifa actual: " + tarifaActual);
        System.out.println("Ruta: " + ruta.getOrigen() + " - " + ruta.getDestino());
    }


}
