

public class Romano extends Personaje {
    public Romano(String nombre) {
        super(nombre, "Gladius");
    }

    @Override
    public String getFraseInicial() {
        return "¡AVE CÉSAR! ¡La legión romana triunfará!";
    }

    @Override
    public String getFraseFinal() {
        return "¡SIC SEMPER TYRANNIS! ¡Roma victoriosa!";
    }

    @Override
    public void atacar(Personaje oponente) {
        int dano = (int) (Math.random() * (MAX_DANO - MIN_DANO + 1)) + MIN_DANO;
        if (Math.random() < 0.2) {
            System.out.println("¡Ataque rápido de la legión! " + this.nombre + " golpea con agilidad con su " + tipoArma);
            dano += 3;
        }
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }
}