public class Cliente {
    private String cedula;// Almacena el número de cédula del cliente
    private String nombre;
    
    // Constructor que recibe los datos básicos del cliente
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula; // Asigna el parámetro 'cedula' al atributo 
        this.nombre = nombre;
    }
    
     // Métodos getter para acceso a los atributos
    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
}