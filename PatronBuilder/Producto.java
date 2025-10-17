import java.util.Objects;

public abstract class Producto {
    private int numero;
    private double precio;
    
    public Producto(int numero, double precio) {
        this.numero = numero;
        this.precio = precio;
    }
    
    public int getNumero() { return numero; }
    public double getPrecio() { return precio; }
    
    public abstract String getDescripcion();
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return numero == producto.numero;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}