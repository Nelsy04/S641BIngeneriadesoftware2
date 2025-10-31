/**
 * INTERFAZ SISTEMA VEHICULAR
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