/**
 *
 */
public class DeteccionPeatones extends ModuloDecorador {
    
    // Costo adicional de este módulo
    private static final double COSTO_MODULO = 8000;
    // Descripción de la funcionalidad agregada
    private static final String DESCRIPCION = "detección de peatones mediante IA";
    
    /**
     * Constructor que recibe el sistema a decorar
     * @param sistema Sistema vehicular base
     */
    public DeteccionPeatones(SistemaVehicular sistema) {
        super(sistema);
    }
    
    /**
     * Agrega la descripción de detección de peatones a las funciones existentes
     * @return Cadena con todas las funciones incluyendo este módulo
     */
    @Override
    public String getFunciones() {
        // Delegamos al sistema base y agregamos nuestra funcionalidad
        return sistema.getFunciones() + ", " + DESCRIPCION;
    }
    
    /**
     * Calcula el costo total incluyendo este módulo
     * @return Costo base más el costo de este módulo
     */
    @Override
    public double getCosto() {
        return sistema.getCosto() + COSTO_MODULO;
    }
}