public class Camara extends Producto {
    private String marca;
    private String modelo;
    
    public Camara(int numero, double precio, String marca, String modelo) {
        super(numero, precio);
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    
    @Override
    public String getDescripcion() {
        return "Cámara " + marca + " " + modelo + " - $" + getPrecio();
    }
    
    @Override
    public String toString() {
        return getDescripcion();
    }
}