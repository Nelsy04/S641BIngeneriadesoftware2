
public class Samurai extends Personaje {
    public Samurai(String nombre) {
        super(nombre, "Katana");
    }

    @Override
    public String getFraseInicial() {
        return "¡El honor guía mi espada! ¡Prepárate para el corte definitivo!";
    }

    @Override
    public String getFraseFinal() {
        return "¡La katana ha hablado! El bushido prevalece.";
    }

    @Override
    public void atacar(Personaje oponente) {
        int dano = (int) (Math.random() * (MAX_DANO - MIN_DANO + 1)) + MIN_DANO;
        if (Math.random() < 0.1) {
            dano *= 1.5;
            System.out.println("¡Golpe crítico de " + this.nombre + " con su " + tipoArma + "!");
        }
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca con " + tipoArma + " a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }
}