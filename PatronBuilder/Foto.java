public class Foto {
    private String fichero;
    private String tamaño;
    
    // Constructor de la clase Foto que recibe 2 parámetros
    public Foto(String fichero, String tamaño) {
        this.fichero = fichero;
        this.tamaño = tamaño;
    }
    
    public String getFichero() { return fichero; }
    public String getTamaño() { return tamaño; }
    
    @Override
    public String toString() {
        return "Foto: " + fichero + " (" + tamaño + ")";
    }
}