/**
 * MÓDULO DE CONTROL DE CLIMA AUTOMÁTICO - Decorador Concreto
*
 */
public class ControlClima extends ModuloDecorador {
    
    private static final double COSTO_MODULO = 3000;
    private static final String DESCRIPCION = "control automático de clima";
    
    /**
     * @param sistema Sistema vehicular base
     */
    public ControlClima(SistemaVehicular sistema) {
        super(sistema);
    }
    
    /**
     * Extiende funciones con control automático de clima
     * @return Funciones incluyendo control de clima
     */
    @Override
    public String getFunciones() {
        return sistema.getFunciones() + ", " + DESCRIPCION;
    }
    
    /**
     * @return Costo total con módulo de clima
     */
    @Override
    public double getCosto() {
        return sistema.getCosto() + COSTO_MODULO;
    }
}