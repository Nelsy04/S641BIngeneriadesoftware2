
public class Vikingo extends Personaje {
    public Vikingo(String nombre) {
        super(nombre, "Hacha de Guerra");
    }

    @Override
    public String getFraseInicial() {
        return "¡POR ODÍN! ¡Tu sangre manchará mi hacha hoy!";
    }

    @Override
    public String getFraseFinal() {
        return "¡VALHALLA ME ESPERA! ¡Pero tú irás al infierno!";
    }

    @Override
    public void atacar(Personaje oponente) {
        int dano = (int) (Math.random() * (MAX_DANO - MIN_DANO + 1)) + MIN_DANO;
        if (Math.random() < 0.15) {
            int danoExtra = (int) (Math.random() * (15 - 5 + 1)) + 5;
            dano += danoExtra;
            System.out.println("¡Furia vikinga! " + this.nombre + " realiza un ataque adicional con su " + tipoArma + "!");
        }
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca con " + tipoArma + " a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }
}