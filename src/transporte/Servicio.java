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
public class Servicio {
     enum TipoServicio{VIP, EJECUTIVO, REAL, NORMAL};
 private TipoServicio tipo;
    private double tarifa;
    public Servicio(TipoServicio tipo, double tarifa) {
        this.tipo = tipo;
        this.tarifa = tarifa;
    }
   

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
     public void imprimirDetalles() {
        System.out.println("Tipo de Servicio: " + tipo);
        System.out.println("Tarifa: " + tarifa);
    }
}
