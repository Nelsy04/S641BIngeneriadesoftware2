
import java.util.Scanner;

/**
 * CLASE MAIN CON MENÚ INTERACTIVO
 * Permite seleccionar diferentes configuraciones de vehículos
 */
public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("🚗 === SISTEMA DE CONFIGURACIÓN DE VEHÍCULOS AUTÓNOMOS ===\n");
        
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            int opcion = obtenerOpcion();
            
            switch (opcion) {
                case 1:
                    configuracionBase();
                    break;
                case 2:
                    configuracionSegura();
                    break;
                case 3:
                    configuracionPremium();
                    break;
                case 4:
                    configuracionPersonalizada();
                    break;
                case 5:
                    configuracionLujo();
                    break;
                case 6:
                    configuracionPersonalizadaAvanzada();
                    break;
                case 0:
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema! 👋");
                    break;
                default:
                    System.out.println("❌ Opción no válida. Intente nuevamente.");
            }
            
            if (!salir) {
                System.out.println("\n" + "=".repeat(60) + "\n");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Muestra el menú de opciones
     */
    private static void mostrarMenu() {
        System.out.println("📋 CONFIGURACIONES DISPONIBLES:");
        System.out.println("1. 🚗 Vehículo Base");
        System.out.println("2. 🛡️  Vehículo Seguro");
        System.out.println("3. ⭐ Vehículo Premium");
        System.out.println("4. 🎨 Vehículo Personalizado");
        System.out.println("5. 💎 Vehículo de Lujo");
        System.out.println("6. 🔧 Configuración Personalizada Avanzada");
        System.out.println("0. ❌ Salir");
        System.out.print("\nSeleccione una opción (0-6): ");
    }
    
    /**
     * Obtiene y valida la opción del usuario
     */
    private static int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    // =============================================
    // CONFIGURACIONES PREDEFINIDAS
    // =============================================
    
    /**
     * Configuración 1: Vehículo Base
     */
    private static void configuracionBase() {
        System.out.println("\n🔧 CONFIGURANDO: VEHÍCULO BASE");
        SistemaVehicular vehiculo = new SistemaBase();
        mostrarVehiculoDetallado("Vehículo Base", vehiculo);
    }
    
    /**
     * Configuración 2: Vehículo Seguro
     */
    private static void configuracionSegura() {
        System.out.println("\n🔧 CONFIGURANDO: VEHÍCULO SEGURO");
        SistemaVehicular vehiculo = new ControlFatiga(
                                    new DeteccionPeatones(
                                        new SistemaBase()));
        mostrarVehiculoDetallado("Vehículo Seguro", vehiculo);
    }
    
    /**
     * Configuración 3: Vehículo Premium
     */
    private static void configuracionPremium() {
        System.out.println("\n🔧 CONFIGURANDO: VEHÍCULO PREMIUM");
        SistemaVehicular vehiculo = new ControlClima(
                                    new ControlFatiga(
                                        new EstacionamientoAutomatico(
                                            new DeteccionPeatones(
                                                new SistemaBase()))));
        mostrarVehiculoDetallado("Vehículo Premium", vehiculo);
    }
    
    /**
     * Configuración 4: Vehículo Personalizado Básico
     */
    private static void configuracionPersonalizada() {
        System.out.println("\n🔧 CONFIGURANDO: VEHÍCULO PERSONALIZADO");
        SistemaVehicular vehiculo = new EstacionamientoAutomatico(
                                    new ControlClima(
                                        new SistemaBase()));
        mostrarVehiculoDetallado("Vehículo Personalizado", vehiculo);
    }
    
    /**
     * Configuración 5: Vehículo de Lujo
     */
    private static void configuracionLujo() {
        System.out.println("\n🔧 CONFIGURANDO: VEHÍCULO DE LUJO");
        SistemaVehicular vehiculo = new ControlClima(
                                    new ControlClima(
                                        new EstacionamientoAutomatico(
                                            new DeteccionPeatones(
                                                new SistemaBase()))));
        mostrarVehiculoDetallado("Vehículo de Lujo", vehiculo);
    }
    
    // =============================================
    // CONFIGURACIÓN INTERACTIVA AVANZADA
    // =============================================
    
    /**
     * Configuración 6: Personalizada Avanzada
     */
    private static void configuracionPersonalizadaAvanzada() {
        System.out.println("\n🔧 CONFIGURACIÓN PERSONALIZADA AVANZADA");
        System.out.println("Seleccione los módulos que desea incluir:\n");
        
        SistemaVehicular vehiculo = new SistemaBase();
        
        // Menú de módulos disponibles
        boolean[] modulosSeleccionados = seleccionarModulos();
        
        // Aplicar los módulos seleccionados en el orden especificado
        if (modulosSeleccionados[0]) { // Detección de Peatones
            vehiculo = new DeteccionPeatones(vehiculo);
            System.out.println("✅ Módulo de Detección de Peatones agregado");
        }
        
        if (modulosSeleccionados[1]) { // Estacionamiento Automático
            vehiculo = new EstacionamientoAutomatico(vehiculo);
            System.out.println("✅ Módulo de Estacionamiento Automático agregado");
        }
        
        if (modulosSeleccionados[2]) { // Control de Fatiga
            vehiculo = new ControlFatiga(vehiculo);
            System.out.println("✅ Módulo de Control de Fatiga agregado");
        }
        
        if (modulosSeleccionados[3]) { // Control de Clima
            vehiculo = new ControlClima(vehiculo);
            System.out.println("✅ Módulo de Control de Clima agregado");
        }
        
        mostrarVehiculoDetallado("Su Vehículo Personalizado", vehiculo);
    }
    
    /**
     * Permite al usuario seleccionar qué módulos incluir
     */
    private static boolean[] seleccionarModulos() {
        boolean[] modulos = new boolean[4];
        
        System.out.println("¿Incluir Detección de Peatones? (+$8,000) (s/n): ");
        modulos[0] = scanner.nextLine().equalsIgnoreCase("s");
        
        System.out.println("¿Incluir Estacionamiento Automático? (+$6,000) (s/n): ");
        modulos[1] = scanner.nextLine().equalsIgnoreCase("s");
        
        System.out.println("¿Incluir Control de Fatiga? (+$4,000) (s/n): ");
        modulos[2] = scanner.nextLine().equalsIgnoreCase("s");
        
        System.out.println("¿Incluir Control de Clima? (+$3,000) (s/n): ");
        modulos[3] = scanner.nextLine().equalsIgnoreCase("s");
        
        return modulos;
    }
    
    // =============================================
    // MÉTODOS AUXILIARES DE VISUALIZACIÓN
    // =============================================
    
    /**
     * Muestra información detallada del vehículo
     */
    private static void mostrarVehiculoDetallado(String nombre, SistemaVehicular vehiculo) {
        System.out.println("\n" + "✨".repeat(25));
        System.out.println("🚗 " + nombre.toUpperCase());
        System.out.println("✨".repeat(25));
        
        System.out.println("📋 FUNCIONALIDADES:");
        String[] funciones = vehiculo.getFunciones().split(", ");
        for (String funcion : funciones) {
            System.out.println("   ✓ " + funcion);
        }
        
        System.out.println("\n💰 COSTO TOTAL: $" + String.format("%,.2f", vehiculo.getCosto()));
        
        // Mostrar desglose de costos
        mostrarDesgloseCostos(vehiculo);
        
        System.out.println("\n🎯 RESUMEN:");
        System.out.println("   • " + funciones.length + " funcionalidades incluidas");
        System.out.println("   • Sistema listo para operar");
        System.out.println("   • Configuración aplicada exitosamente");
    }
    
    /**
     * Muestra el desglose detallado de costos
     */
    private static void mostrarDesgloseCostos(SistemaVehicular vehiculo) {
        System.out.println("\n📊 DESGLOSE DE COSTOS:");
        
        // Este es un ejemplo simplificado - en una implementación real
        // podrías tener métodos para obtener el desglose
        
        double costoBase = 50000;
        double costoModulos = vehiculo.getCosto() - costoBase;
        
        System.out.println("   • Sistema Base: $" + String.format("%,.2f", costoBase));
        System.out.println("   • Módulos Adicionales: $" + String.format("%,.2f", costoModulos));
        System.out.println("   • TOTAL: $" + String.format("%,.2f", vehiculo.getCosto()));
    }
    
    /**
     * Método original mejorado
     */
    private static void mostrarVehiculo(String nombre, SistemaVehicular vehiculo) {
        System.out.println("🔧 " + nombre + ":");
        System.out.println("   📋 Funciones: " + vehiculo.getFunciones());
        System.out.println("   💰 Costo total: $" + String.format("%,.2f", vehiculo.getCosto()));
        
        // Crear separador manualmente
        StringBuilder separador = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            separador.append("-");
        }
        System.out.println("   " + separador.toString());
    }
}