/**
 * DECORADOR ABSTRACTO - Clase Base para todos los módulos
 */
public abstract class ModuloDecorador implements SistemaVehicular {
    
    /**
     * Referencia al sistema vehicular que está siendo decorado
     * Protected para que las subclases puedan acceder
     */
    protected SistemaVehicular sistema;
    
    /**
     * Constructor que recibe el sistema a decorar
     * @param sistema Sistema vehicular que será ampliado
     */
    public ModuloDecorador(SistemaVehicular sistema) {
        this.sistema = sistema;
    }
    
    /**
     * Comportamiento por defecto: delega al sistema decorado
     * @return Funciones del sistema base
     */
    @Override
    public String getFunciones() {
        return sistema.getFunciones();
    }
    
    /**
     * Comportamiento por defecto: delega al sistema decorado
     * @return Costo del sistema base
     */
    @Override
    public double getCosto() {
        return sistema.getCosto();
    }
}