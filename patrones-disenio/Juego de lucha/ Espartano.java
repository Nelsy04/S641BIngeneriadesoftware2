

public class Espartano extends Personaje {
    public Espartano(String nombre) {
        super(nombre, "Lanza Espartana");
    }

    @Override
    public String getFraseInicial() {
        return "¡POR ESPARTA! ¡Hoy beberé hidromiel del cráneo de mi enemigo!";
    }

    @Override
    public String getFraseFinal() {
        return "¡Esto... ES... ESPARTA!";
    }

    @Override
    public void atacar(Personaje oponente) {
        int dano = (int) (Math.random() * (MAX_DANO - MIN_DANO + 1)) + MIN_DANO;
        System.out.println(this.nombre + " blande su " + tipoArma + " con ferocidad!");
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }
}