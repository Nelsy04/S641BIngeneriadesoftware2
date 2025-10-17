import java.util.Date;
import java.util.List;

public class Pedido {
    private Date fecha;
    private String numeroTarjetaCredito;
    private List<Producto> productos;
    private Cliente cliente;
    
    // Constructor privado que solo puede ser llamado por PedidoBuilder
    Pedido(PedidoBuilder builder) {
        this.fecha = builder.getFecha();
        this.numeroTarjetaCredito = builder.getNumeroTarjetaCredito();
        this.productos = builder.getProductos();
        this.cliente = builder.getCliente();
    }
    
    // Método para calcular el total del pedido
    public double getTotal() {
        return productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }
    
    // Método para mostrar los detalles del pedido en consola
    public void mostrarPedido() {
        System.out.println("=== DETALLE DEL PEDIDO ===");
        System.out.println(cliente);
        System.out.println("Fecha: " + fecha);
        System.out.println("Tarjeta: ****" + numeroTarjetaCredito.substring(12));
        System.out.println("\nProductos:");
        
        // Bucle para mostrar cada producto numerado
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getDescripcion());
        }
        
        System.out.println("\nTOTAL: $" + getTotal());
        System.out.println("==========================");
    }
    
    // Getters para acceder a los atributos
    public Date getFecha() { return fecha; }
    public String getNumeroTarjetaCredito() { return numeroTarjetaCredito; }
    public List<Producto> getProductos() { return productos; }
    public Cliente getCliente() { return cliente; }
}