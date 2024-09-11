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
public class Venta {


    private String codigoVenta;
    private Salida salida;
    private Cliente cliente;
    private Servicio servicio;
    private int asiento;
    
     public Venta(String codigoVenta,Salida salida, Cliente cliente, Servicio servicio, int asiento) {
        this.salida = salida;
        this.cliente = cliente;
        this.servicio = servicio;
        this.asiento = asiento;
        this.codigoVenta = codigoVenta;
    }

   

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }
        public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }
    public void imprimirComprobante(){
        System.out.println("==================================");
        System.out.println("N°" + codigoVenta);
        System.out.println("Cliente: ");
        cliente.imprimir();
        System.out.println("Servicio: ");
       servicio.imprimirDetalles();
        System.out.println("Asiento: ");
        System.out.println(asiento);
        System.out.println("Detalles de salida ");
        salida.imprimirSalida();
    }

 
   
}
