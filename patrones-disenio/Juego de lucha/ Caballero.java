

public class Caballero extends Personaje {
    public Caballero(String nombre) {
        super(nombre, "Espada Larga");
    }

    @Override
    public String getFraseInicial() {
        return "¡Por el rey y la corona! ¡Que Dios juzgue al vencido!";
    }

    @Override
    public String getFraseFinal() {
        return "¡La justicia ha sido servida! ¡Caballerosidad ante todo!";
    }

    @Override
    public void atacar(Personaje oponente) {
        int dano = (int) (Math.random() * (MAX_DANO - MIN_DANO + 1)) + MIN_DANO;
        dano = Math.max(MIN_DANO, Math.min(MAX_DANO, dano + 5));
        System.out.println(this.nombre + " ejecuta un elegante ataque con su " + tipoArma);
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }
}