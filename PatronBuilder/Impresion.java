import java.util.ArrayList;
import java.util.List;

// Declaración de la clase Impresion que hereda de Producto
public class Impresion extends Producto {
     // Atributos de la clase
    private String color;
    private List<Foto> fotos;
    // Constantes estáticas para el cálculo de precios
    private static final double PRECIO_BASE = 5.0;// precio fijo
    private static final double PRECIO_POR_FOTO = 0.5;// precio adicional por foto
    
    public Impresion(int numero, String color) {
        // Llama al constructor de la clase padre (Producto) con número y precio base
        super(numero, PRECIO_BASE); // Precio inicial base
        this.color = color;
        this.fotos = new ArrayList<>(); // Inicializa la lista de fotos como un ArrayList vacío
    }
     // Método para agregar una foto a la impresión

    public void agregarFoto(Foto foto) {
        fotos.add(foto);
        // CORREGIDO: Actualizar el precio real basado en número de fotos
        // Usamos reflexión para actualizar el precio (en producción usaríamos setter protegido)
        try {
            var field = Producto.class.getDeclaredField("precio");
            field.setAccessible(true); // Hace el campo accesible aunque sea privado
            double nuevoPrecio = PRECIO_BASE + (fotos.size() * PRECIO_POR_FOTO);
            field.set(this, nuevoPrecio);
        } catch (Exception e) {
             // Maneja cualquier error que ocurra durante la reflexión
            System.err.println("Error al actualizar precio: " + e.getMessage());
        }
    }
    
      // Método getter que devuelve una copia de la lista de fotos
    public List<Foto> getFotos() { return new ArrayList<>(fotos); }
    public String getColor() { return color; }
    
    @Override
    public String getDescripcion() {
        return "Impresión " + color + " con " + fotos.size() + " fotos - $" + getPrecio();
    }
    
    @Override
    public String toString() {
        return getDescripcion();
    }
}