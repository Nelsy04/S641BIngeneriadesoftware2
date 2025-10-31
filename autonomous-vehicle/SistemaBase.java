/**
 * SISTEMA BASE - Componente Concreto
 * 
 * Representa el sistema mínimo de conducción autónoma sin módulos adicionales.
 * Este es el objeto que será decorado con funcionalidades adicionales.
 * 
 * Principio: Single Responsibility - Solo maneja la funcionalidad básica
 */
public class SistemaBase implements SistemaVehicular {
    
    // Costo base del sistema de conducción autónoma
    private static final double COSTO_BASE = 50000;
    private static final String DESCRIPCION_BASE = "Conducción básica autónoma";
    
    /**
     * @return Descripción de las funciones básicas del vehículo
     */
    @Override
    public String getFunciones() {
        return DESCRIPCION_BASE;
    }
    
    /**
     * @return Costo base del sistema sin módulos adicionales
     */
    @Override
    public double getCosto() {
        return COSTO_BASE;
    }
}