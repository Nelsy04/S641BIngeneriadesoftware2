import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoBuilder {
    private Date fecha;
    private String numeroTarjetaCredito;
    private List<Producto> productos;
    private Cliente cliente;
    
    public PedidoBuilder(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.fecha = new Date(); // Fecha actual por defecto
    }
    
    public PedidoBuilder setFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }
    
    public PedidoBuilder setTarjetaCredito(String numero) {
        // Validación básica de tarjeta de crédito
        if (numero != null && numero.matches("\\d{16}")) {
            this.numeroTarjetaCredito = numero;
        } else {
            throw new IllegalArgumentException("Número de tarjeta inválido");
        }
        return this;
    }
    
    public PedidoBuilder agregarProducto(Producto producto) {
        productos.add(producto);
        return this;
    }
    
    public Pedido build() {
        // Validaciones antes de construir
        if (cliente == null) {
            throw new IllegalStateException("Cliente es requerido");
        }
        if (numeroTarjetaCredito == null) {
            throw new IllegalStateException("Número de tarjeta de crédito es requerido");
        }
        if (productos.isEmpty()) {
            throw new IllegalStateException("El pedido debe tener al menos un producto");
        }
        
        return new Pedido(this);
    }
    
    // Getters para que Pedido pueda acceder a los atributos
    public Date getFecha() { return fecha; }
    public String getNumeroTarjetaCredito() { return numeroTarjetaCredito; }
    public List<Producto> getProductos() { return new ArrayList<>(productos); }
    public Cliente getCliente() { return cliente; }
}