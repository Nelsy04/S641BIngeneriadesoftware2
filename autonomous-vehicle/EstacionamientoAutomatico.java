/**
 * MÓDULO DE ESTACIONAMIENTO AUTOMÁTICO - Decorador Concreto
 * 
 * Proporciona capacidad de estacionamiento autónomo en diferentes escenarios:
 * - Estacionamiento en paralelo
 * - Estacionamiento en batería
 * - Estacionamiento perpendicular
 * 
 * Tecnología: Combinación de ultrasonidos, cámaras 360° y machine learning
 */
public class EstacionamientoAutomatico extends ModuloDecorador {
    
    private static final double COSTO_MODULO = 6000;
    private static final String DESCRIPCION = "asistencia de estacionamiento automático";
    
    /**
     * @param sistema Sistema vehicular a decorar
     */
    public EstacionamientoAutomatico(SistemaVehicular sistema) {
        super(sistema);
    }
    
    /**
     * Extiende las funciones con capacidad de estacionamiento automático
     * @return Funciones del sistema más estacionamiento automático
     */
    @Override
    public String getFunciones() {
        return sistema.getFunciones() + ", " + DESCRIPCION;
    }
    
    /**
     * @return Costo total incluyendo módulo de estacionamiento
     */
    @Override
    public double getCosto() {
        return sistema.getCosto() + COSTO_MODULO;
    }
}