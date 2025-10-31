/**
 * CLASE MAIN - Cliente del Patrón Decorador
 * 
 * Demuestra cómo usar el patrón decorador para construir
 * diferentes configuraciones de vehículos autónomos.
 * 
 * Propósito: Mostrar la flexibilidad del patrón para crear
 * combinaciones dinámicas de funcionalidades
 */
public class Main {
    
    /**
     * Punto de entrada de la aplicación
     * @param args Argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {
        System.out.println("🚗 === SISTEMA DE VEHÍCULOS AUTÓNOMOS ===\n");
        
        // --------------------------------------------------
        // CONFIGURACIÓN 1: VEHÍCULO BÁSICO
        // --------------------------------------------------
        SistemaVehicular vehiculoBase = new SistemaBase();
        mostrarVehiculo("Vehículo Base", vehiculoBase);
        
        // --------------------------------------------------
        // CONFIGURACIÓN 2: VEHÍCULO CON SEGURIDAD AVANZADA
        // Combinación: Base + Detección Peatones + Control Fatiga
        // --------------------------------------------------
        SistemaVehicular vehiculoSeguro = new ControlFatiga(
                            new DeteccionPeatones(
                                new SistemaBase()));
        mostrarVehiculo("Vehículo Seguro", vehiculoSeguro);
        
        // --------------------------------------------------
        // CONFIGURACIÓN 3: VEHÍCULO PREMIUM
        // Todos los módulos combinados
        // --------------------------------------------------
        SistemaVehicular vehiculoPremium = new ControlClima(
                              new ControlFatiga(
                                  new EstacionamientoAutomatico(
                                      new DeteccionPeatones(
                                          new SistemaBase()))));
        mostrarVehiculo("Vehículo Premium", vehiculoPremium);
        
        // --------------------------------------------------
        // CONFIGURACIÓN 4: VEHÍCULO PERSONALIZADO
        // Solo estacionamiento automático y control de clima
        // --------------------------------------------------
        SistemaVehicular vehiculoPersonalizado = new EstacionamientoAutomatico(
                                    new ControlClima(
                                        new SistemaBase()));
        mostrarVehiculo("Vehículo Personalizado", vehiculoPersonalizado);
        
        // --------------------------------------------------
        // CONFIGURACIÓN 5: VEHÍCULO DE LUJO
        // Múltiples instancias del mismo módulo (no recomendado en realidad)
        // Demuestra la flexibilidad del patrón
        // --------------------------------------------------
        SistemaVehicular vehiculoLujo = new ControlClima(
                           new ControlClima( // Doble sistema de clima (ejemplo)
                               new EstacionamientoAutomatico(
                                   new DeteccionPeatones(
                                       new SistemaBase()))));
        mostrarVehiculo("Vehículo de Lujo", vehiculoLujo);
    }
    
    /**
     * Método auxiliar para mostrar información del vehículo de forma consistente
     * @param nombre Nombre de la configuración del vehículo
     * @param vehiculo Instancia del sistema vehicular
     */
    private static void mostrarVehiculo(String nombre, SistemaVehicular vehiculo) {
        System.out.println("🔧 " + nombre + ":");
        System.out.println("   📋 Funciones: " + vehiculo.getFunciones());
        System.out.println("   💰 Costo total: $" + String.format("%,.2f", vehiculo.getCosto()));
        System.out.println("   " + "-".repeat(50));
    }
}