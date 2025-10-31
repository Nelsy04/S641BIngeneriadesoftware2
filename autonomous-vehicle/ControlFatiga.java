/**
 * MÓDULO DE CONTROL DE FATIGA - Decorador Concreto
 
 */
public class ControlFatiga extends ModuloDecorador {
    
    private static final double COSTO_MODULO = 4000;
    private static final String DESCRIPCION = "monitoreo de fatiga del conductor";
    
    /**
     * @param sistema Sistema a decorar con control de fatiga
     */
    public ControlFatiga(SistemaVehicular sistema) {
        super(sistema);
    }
    
    /**
     * Agrega capacidad de monitoreo de fatiga a las funciones
     * @return Funciones existentes más control de fatiga
     */
    @Override
    public String getFunciones() {
        return sistema.getFunciones() + ", " + DESCRIPCION;
    }
    
    /**
     * @return Costo total con módulo de control de fatiga
     */
    @Override
    public double getCosto() {
        return sistema.getCosto() + COSTO_MODULO;
    }
}