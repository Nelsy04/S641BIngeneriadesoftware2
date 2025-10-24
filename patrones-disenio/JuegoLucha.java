
import java.util.Scanner;

public class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    public JuegoLucha(Personaje jugador1, Personaje jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void iniciarPelea() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           ¡MORTAL KOMBAT - EDICIÓN MEDIEVAL!");
        System.out.println("=".repeat(50));
        
        System.out.println("\n>>> " + jugador1.getNombre() + " dice: " + jugador1.getFraseInicial());
        System.out.println(">>> " + jugador2.getNombre() + " dice: " + jugador2.getFraseInicial());
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println(jugador1.getNombre() + " (" + jugador1.getTipoArma() + ") vs " + 
                          jugador2.getNombre() + " (" + jugador2.getTipoArma() + ")");
        System.out.println("=".repeat(50) + "\n");

        int turno = 1;
        
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            System.out.println("--- Turno " + turno + " ---");
            
            if (jugador1.estaVivo()) {
                turno(jugador1, jugador2);
            }
            
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
            
            turno++;
            System.out.println();
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("              ¡FATALITY!");
        System.out.println("=".repeat(50));
        
        if (jugador1.estaVivo()) {
            System.out.println(">>> " + jugador1.getNombre() + " dice: " + jugador1.getFraseFinal());
            System.out.println("\n¡" + jugador1.getNombre() + " HA GANADO LA PELEA!");
        } else {
            System.out.println(">>> " + jugador2.getNombre() + " dice: " + jugador2.getFraseFinal());
            System.out.println("\n¡" + jugador2.getNombre() + " HA GANADO LA PELEA!");
        }
        System.out.println("=".repeat(50));
    }

    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("Turno de " + atacante.getNombre() + 
                          " | Vida de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida());
        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " puntos de vida.");
    }
}