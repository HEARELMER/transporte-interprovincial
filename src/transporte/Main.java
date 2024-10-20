package transporte;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import transporte.Servicio.TipoServicio;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Venta> ventas = new ArrayList<>();
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        ArrayList<Servicio> servicios = new ArrayList<>();
        // Creación de vehículos y rutas de ejemplo
        Conductor conductor1 = new Conductor("Carlos Perez", 35, "987654321", "12345678");
        Vehiculo vehiculo1 = new Vehiculo("ABC123", conductor1, 10);
        Vehiculo vehiculo2 = new Vehiculo("DEF456", conductor1, 20);

        vehiculos.add(vehiculo1);
        Ruta ruta1 = new Ruta("Ayacucho", "Lima", 50.0);
        Ruta ruta2 = new Ruta("Ayacucho", "Abancay", 40.0);
        Ruta ruta3 = new Ruta("Ayacucho", "Cusco", 60.0);
        Ruta ruta4 = new Ruta("Ayacucho", "Huancayo", 30.0);

        Date fecha1 = new Date();
        Salida salida1 = new Salida(vehiculo1, fecha1);

        // creacmos servicios
        servicios.add(new Servicio(ruta1));
        servicios.add(new Servicio(ruta2));
        servicios.add(new Servicio(ruta3));
        servicios.add(new Servicio(ruta4));

        int opcion;

        do {
            System.out.println("=======================================");
            System.out.println("BIENVENIDOS AL SISTEMA ");
            System.out.println("=======================================");
            System.out.println("1. Realizar Venta");
            System.out.println("2. Mostrar Ventas");
            System.out.println("3. Mostrar Pasajeros");
            System.out.println("4. Modificar Venta");
            System.out.println("5. Eliminar Pasajero");
            System.out.println("6. Mostrar Mapa de Asientos");
            System.out.println("7. Salir");
            System.out.println("=======================================");
            System.out.print("Elije una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("=======================================");

            switch (opcion) {
                case 1: {
                    // Realizar una venta
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la edad del cliente: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el teléfono del cliente: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese el DNI del cliente: ");
                    String dni = scanner.nextLine();

                    Cliente cliente = new Cliente(nombre, edad, telefono, dni);

                    System.out.println("Servicios Disponibles: ");
                    int c = 1;
                    for (Servicio servicio : servicios) {
                        System.out.println("==============================");
                        System.out.print(c++ + " - ");
                        servicio.imprimir();
                    }
                    int servicioSeleccionado = 0;
                    do {
                        System.out.print("Seleccione el servicio: ");
                        servicioSeleccionado = scanner.nextInt();
                    } while (servicioSeleccionado < 1 || servicioSeleccionado > servicios.size());
                    Servicio servicioSeleccionadoObjeto = servicios.get(servicioSeleccionado - 1);
                    System.out.println("Servicio seleccionado: ");
                    servicioSeleccionadoObjeto.imprimir();

                    System.out.println("Tipos de servicio: 1. VIP, 2. EJECUTIVO, 3. REAL, 4. NORMAL");
                    System.out.print("Elija el tipo de servicio: ");
                    int tipoServicio = scanner.nextInt();
                    Servicio.TipoServicio tipo = Servicio.TipoServicio.NORMAL;
                    switch (tipoServicio) {
                        case 1:
                            tipo = Servicio.TipoServicio.VIP;
                            break;
                        case 2:
                            tipo = Servicio.TipoServicio.EJECUTIVO;
                            break;
                        case 3:
                            tipo = Servicio.TipoServicio.NORMAL;
                            break;
                        default:
                            System.out.println("Opción inválida. Asignando NORMAL.");
                            break;
                    }

                    servicioSeleccionadoObjeto.setTipo(tipo);
                   // servicioSeleccionadoObjeto.calcularTarifa();
                    System.out.println("Tarifa actual: " + servicioSeleccionadoObjeto.getTarifaActual());

                    salida1.setRuta(servicioSeleccionadoObjeto.getRuta());
                    // Mostrar mapa de asientos antes de pedir el número de asiento
                    vehiculo1.imprimirMapaAsientos();
                    System.out.print("Ingrese el número de asiento: ");
                    int asiento = scanner.nextInt();
                    scanner.nextLine();

                    String codigoVenta = "V" + (ventas.size() + 1);
                    Venta nuevaVenta = new Venta(codigoVenta, salida1, cliente, servicioSeleccionadoObjeto, asiento);

                    if (vehiculo1.asignarPasajero(cliente)) {
                        ventas.add(nuevaVenta);
                        System.out.println("Venta realizada con éxito.");
                        System.out.println("===========================");
                        nuevaVenta.imprimirComprobante();
                        System.out.println("===========================");
                    } else {
                        System.out.println("No se pudo realizar la venta. Vehículo lleno.");
                    }

                    break;
                }
                case 2: {

                    if (ventas.isEmpty()) {
                        System.out.println("No hay ventas registradas.");
                    } else {
                        for (Venta venta : ventas) {
                            venta.imprimirComprobante();
                        }
                    }
                    break;
                }
                case 3: {
                    // Mostrar pasajeros del vehículo
                    vehiculo1.imprimirPasajeros();
                    break;
                }
                case 4: {
                    // Modificar una venta (simple ejemplo para modificar asiento)
                    if (ventas.isEmpty()) {
                        System.out.println("No hay ventas registradas.");
                    } else {
                        for (Venta venta : ventas) {
                            venta.imprimirComprobante();
                        }
                    }
                    System.out.print("Ingrese el codigo de venta a modificar: ");
                    String codigoVenta = scanner.nextLine();

                    Venta ventaAModificar = null;
                    for (Venta venta : ventas) {
                        if (venta.getCodigoVenta().equals(codigoVenta)) {
                            ventaAModificar = venta;
                            break;
                        }
                    }

                    if (ventaAModificar != null) {
                        System.out.print("Ingrese el nuevo número de asiento: ");
                        int nuevoAsiento = scanner.nextInt();
                        ventaAModificar.setAsiento(nuevoAsiento);
                        System.out.println("Venta modificada con éxito.");
                    } else {
                        System.out.println("Venta no encontrada.");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Ingrese el DNI del pasajero a eliminar:");
                    String dni = scanner.nextLine();

                    boolean pasajeroEliminado = false;
                    // Recorrer los vehículos para intentar eliminar al pasajero
                    for (Vehiculo vehiculo : vehiculos) {
                        if (vehiculo.eliminarPasajero(dni)) {
                            pasajeroEliminado = true;
                            break;
                        }
                    }

                    if (!pasajeroEliminado) {
                        System.out.println("No se encontró ningún pasajero con ese DNI en ningún vehículo.");
                    }
                    break;
                }
                case 6: {
                    // Mostrar mapa de asientos
                    vehiculo1.imprimirMapaAsientos();
                    break;
                }
                case 7: {
                    System.out.println("Saliendo...");
                    System.exit(0);
                }
                default: {
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            }
        } while (true);
    }
}