package org.example;

import org.example.dao.*;
import org.example.model.*;
import org.example.util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Connection connection = ConexionBD.obtenerconexionTALLER_MOTOS()) {

            ClientesDAO clientesDAO = new ClientesDAOImpl(connection);
            MotosDAO motosDAO = new MotosDAOImpl(connection);
            OrdenesDAO ordenesDAO = new OrdenesDAOImpl(connection);
            RepuestosDAO repuestosDAO = new RepuestosDAOImpl(connection);
            ProveedoresDAO proveedoresDAO = new ProveedoresDAOImpl(connection);
            DetalleOrdenDAO detalleOrdenDAO = new DetalleOrdenDAOImpl(connection);

            Scanner scanner = new Scanner(System.in);

            int opcion;

            do {

                System.out.println("\n===== MENU TALLER MOTOS =====");
                System.out.println("1. Registrar Cliente");
                System.out.println("2. Registrar Moto");
                System.out.println("3. Registrar Proveedor");
                System.out.println("4. Registrar Repuesto");
                System.out.println("5. Registrar Orden");
                System.out.println("6. Registrar Detalle Orden");
                System.out.println("7. Ver Clientes");
                System.out.println("8. Ver Motos");
                System.out.println("9. Ver Proveedores");
                System.out.println("10. Ver Repuestos");
                System.out.println("11. Ver Ordenes");
                System.out.println("12. Ver Detalle Orden");
                System.out.println("0. Salir");

                System.out.print("Elige una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {

                    case 1: {

                        System.out.print("ID Cliente: ");
                        int idCliente = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nombre: ");
                        String nombreCliente = scanner.nextLine();

                        System.out.print("Telefono: ");
                        String telefonoCliente = scanner.nextLine();

                        clientesDAO.crear(
                                new Clientes(idCliente, nombreCliente, telefonoCliente)
                        );

                        System.out.println("Cliente registrado.");
                        break;
                    }

                    case 2: {

                        System.out.print("ID Moto: ");
                        int idMoto = scanner.nextInt();

                        System.out.print("ID Cliente: ");
                        int clienteIdMoto = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Placa: ");
                        String placaMoto = scanner.nextLine();

                        System.out.print("Modelo: ");
                        String modeloMoto = scanner.nextLine();

                        motosDAO.crear(
                                new Motos(idMoto, clienteIdMoto, placaMoto, modeloMoto)
                        );

                        System.out.println("Moto registrada.");
                        break;
                    }

                    case 3: {

                        System.out.print("ID Proveedor: ");
                        int idProveedor = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nombre: ");
                        String nombreProveedor = scanner.nextLine();

                        System.out.print("Telefono: ");
                        String telefonoProveedor = scanner.nextLine();

                        System.out.print("Direccion: ");
                        String direccionProveedor = scanner.nextLine();

                        proveedoresDAO.crear(
                                new Proveedores(
                                        idProveedor,
                                        nombreProveedor,
                                        telefonoProveedor,
                                        direccionProveedor
                                )
                        );

                        System.out.println("Proveedor registrado.");
                        break;
                    }

                    case 4: {

                        System.out.print("ID Repuesto: ");
                        int idRepuesto = scanner.nextInt();

                        System.out.print("ID Proveedor: ");
                        int proveedorId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nombre: ");
                        String nombreRepuesto = scanner.nextLine();

                        System.out.print("Precio: ");
                        double precioRepuesto = scanner.nextDouble();

                        System.out.print("Stock: ");
                        int stockRepuesto = scanner.nextInt();

                        repuestosDAO.crear(
                                new Repuestos(
                                        idRepuesto,
                                        proveedorId,
                                        nombreRepuesto,
                                        precioRepuesto,
                                        stockRepuesto
                                )
                        );

                        System.out.println("Repuesto registrado.");
                        break;
                    }

                    case 5: {

                        System.out.print("ID Orden: ");
                        int idOrden = scanner.nextInt();

                        System.out.print("ID Moto: ");
                        int motoIdOrden = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Descripcion: ");
                        String descripcionOrden = scanner.nextLine();

                        System.out.print("Costo Total: ");
                        double costoOrden = scanner.nextDouble();

                        ordenesDAO.crear(
                                new Ordenes(
                                        idOrden,
                                        motoIdOrden,
                                        descripcionOrden,
                                        costoOrden
                                )
                        );

                        System.out.println("Orden registrada.");
                        break;
                    }

                    case 6: {

                        System.out.print("ID Detalle: ");
                        int idDetalle = scanner.nextInt();

                        System.out.print("ID Orden: ");
                        int ordenId = scanner.nextInt();

                        System.out.print("ID Repuesto: ");
                        int repuestoId = scanner.nextInt();

                        System.out.print("Cantidad: ");
                        int cantidadDetalle = scanner.nextInt();

                        System.out.print("Subtotal: ");
                        double subtotalDetalle = scanner.nextDouble();

                        detalleOrdenDAO.crear(
                                new DetalleOrden(
                                        idDetalle,
                                        ordenId,
                                        repuestoId,
                                        cantidadDetalle,
                                        subtotalDetalle
                                )
                        );

                        System.out.println("Detalle orden registrado.");
                        break;
                    }

                    case 7: {

                        List<Clientes> clientes = clientesDAO.Listar();

                        for (Clientes c : clientes) {
                            System.out.println(c);
                        }

                        break;
                    }

                    case 8: {

                        List<Motos> motos = motosDAO.Listar();

                        for (Motos m : motos) {
                            System.out.println(m);
                        }

                        break;
                    }

                    case 9: {

                        List<Proveedores> proveedores = proveedoresDAO.Listar();

                        for (Proveedores p : proveedores) {
                            System.out.println(p);
                        }

                        break;
                    }

                    case 10: {

                        List<Repuestos> repuestos = repuestosDAO.Listar();

                        for (Repuestos r : repuestos) {
                            System.out.println(r);
                        }

                        break;
                    }

                    case 11: {

                        List<Ordenes> ordenes = ordenesDAO.Listar();

                        for (Ordenes o : ordenes) {
                            System.out.println(o);
                        }

                        break;
                    }

                    case 12: {

                        List<DetalleOrden> detalles = detalleOrdenDAO.Listar();

                        for (DetalleOrden d : detalles) {
                            System.out.println(d);
                        }

                        break;
                    }

                    case 0:

                        System.out.println("Saliendo del sistema...");
                        break;

                    default:

                        System.out.println("Opcion invalida.");
                }

            } while (opcion != 0);

        } catch (SQLException e) {

            System.out.println("Error de conexion: " + e.getMessage());
        }
    }
}