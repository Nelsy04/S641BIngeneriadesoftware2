import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Primer y segundo pedido (código existente)
        Date fechaEspecifica = new Date(125, 9, 16, 17, 16, 10);
        
        Cliente cliente2 = new Cliente("87654321", "María García");
        Camara camaraSony = new Camara(4, 500.0, "Sony", "Alpha A7");
        
        Impresion impresionColor = new Impresion(5, "Color");
        impresionColor.agregarFoto(new Foto("vacaciones1.jpg", "10x15"));
        impresionColor.agregarFoto(new Foto("vacaciones2.jpg", "15x20"));
        impresionColor.agregarFoto(new Foto("familia.jpg", "20x30"));
        
        // Construye el pedido usando el patrón Builder
        Pedido pedido2 = new PedidoBuilder(cliente2)
                .setFecha(fechaEspecifica)
                .setTarjetaCredito("8765432187654321")
                .agregarProducto(camaraSony)
                .agregarProducto(impresionColor)
                .build();
        
        pedido2.mostrarPedido();

        // ========== TERCER PEDIDO CON INPUTS ==========
        System.out.println("\n--- CREAR TERCER PEDIDO (INPUTS) ---");
        
        // Inputs para Cliente
        System.out.print("Ingrese cédula del cliente: ");
        String cedula = scanner.nextLine();
        
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine();
        Cliente cliente3 = new Cliente(cedula, nombre);
        
        // Inputs para Tarjeta de Crédito
        System.out.print("Ingrese número de tarjeta (16 dígitos): ");
        String tarjeta = scanner.nextLine();
        
        // Crear Builder inicial con cliente y tarjeta
        PedidoBuilder builder = new PedidoBuilder(cliente3)
                .setTarjetaCredito(tarjeta);
        
        // Inputs para Productos
        boolean agregarMasProductos = true;
        int contadorProductos = 6; // Continuar numeración desde 6
        
        // Bucle principal para agregar productos
        while (agregarMasProductos) {
            System.out.println("\n--- Agregar Producto ---");
            System.out.println("1. Cámara");
            System.out.println("2. Impresión");
            System.out.print("Seleccione tipo de producto (1-2): ");
            int tipoProducto = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            // Switch para manejar los diferentes tipos de productos
            switch (tipoProducto) {
                case 1: // Cámara
                    System.out.print("Ingrese marca de la cámara: ");
                    String marca = scanner.nextLine();
                    
                    System.out.print("Ingrese modelo de la cámara: ");
                    String modelo = scanner.nextLine();
                    
                    System.out.print("Ingrese precio de la cámara: ");
                    double precioCamara = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer
                    
                      // Crea la cámara y la agrega al builder
                    Camara camara = new Camara(contadorProductos++, precioCamara, marca, modelo);
                    builder.agregarProducto(camara);
                    System.out.println("✅ Cámara agregada al pedido");
                    break;
                    
                case 2: // Impresión
                    System.out.print("Ingrese color de impresión (Color/Blanco y Negro): ");
                    String color = scanner.nextLine();
                    
                    Impresion impresion = new Impresion(contadorProductos++, color);
                    
                    // Agregar fotos a la impresión
                    boolean agregarMasFotos = true;
                    System.out.println("\nAgregando fotos a la impresión:");
                    
                      // Bucle para agregar múltiples fotos
                    while (agregarMasFotos) {
                        System.out.print("Ingrese nombre del fichero de la foto: ");
                        String fichero = scanner.nextLine();
                        
                        System.out.print("Ingrese tamaño de la foto (ej: 10x15): ");
                        String tamaño = scanner.nextLine();
                        
                        Foto foto = new Foto(fichero, tamaño);
                        impresion.agregarFoto(foto);
                        System.out.println("✅ Foto '" + fichero + "' agregada");
                        
                        System.out.print("¿Agregar otra foto? (s/n): ");
                        String respuesta = scanner.nextLine();
                        agregarMasFotos = respuesta.equalsIgnoreCase("s");
                    }
                    
                     // Agrega la impresión al builder
                    builder.agregarProducto(impresion);
                    System.out.println("✅ Impresión agregada al pedido");
                    break;
                    
                default:
                    System.out.println("❌ Opción inválida");
                    continue; // Vuelve al inicio del bucle
            }
            
            System.out.print("¿Agregar otro producto al pedido? (s/n): ");
            String respuesta = scanner.nextLine();
            agregarMasProductos = respuesta.equalsIgnoreCase("s");
        }
        
        // Construir y mostrar el pedido final
        try {
            Pedido pedido3 = builder.build();
            System.out.println("\n--- TERCER PEDIDO CREADO ---");
            pedido3.mostrarPedido();
        } catch (Exception e) {
            // Maneja cualquier error durante la construcción
            System.out.println("❌ Error al crear el pedido: " + e.getMessage());
        }
        
        scanner.close(); // Cierra el scanner para liberar recursos
    }
}