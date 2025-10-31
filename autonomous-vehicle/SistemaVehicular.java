/**
 * INTERFAZ SISTEMA VEHICULAR
 * 
 * Define el contrato que todos los componentes del sistema de vehículos autónomos deben seguir.
 * Este es el componente principal del patrón Decorador.
 * 
 * Principio: Interface Segregation - Define operaciones específicas y cohesivas
 */
public interface SistemaVehicular {
    
    /**
     * Obtiene la descripción de todas las funciones del sistema
     * @return Cadena con las funciones disponibles
     */
    String getFunciones();
    
    /**
     * Calcula el costo total del sistema incluyendo todos los módulos
     * @return Costo total en dólares
     */
    double getCosto();
}