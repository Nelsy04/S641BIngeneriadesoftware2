

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║          MORTAL KOMBAT MEDIEVAL        ║");
        System.out.println("║              ⚔️ 🛡️ ⚔️                ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        System.out.println("\n¡ELIGE A TUS GUERREROS!");
        System.out.println("1. 🗡️  Samurai (Katana) - Golpes críticos");
        System.out.println("2. 🛡️  Espartano (Lanza) - Defensa épica");
        System.out.println("3. 🪓  Vikingo (Hacha) - Furia vikinga");
        System.out.println("4. ⚔️  Caballero (Espada) - Ataque consistente");
        System.out.println("5. 🦅  Romano (Gladius) - Ataque rápido");
        
        Personaje jugador1 = seleccionarPersonaje(scanner, 1);
        Personaje jugador2 = seleccionarPersonaje(scanner, 2);
        
        System.out.println("\n" + "═".repeat(55));
        System.out.println("¡COMBATIENTES CONFIRMADOS!");
        System.out.println("JUGADOR 1: " + jugador1.getNombre() + " - " + jugador1.getTipoArma());
        System.out.println("JUGADOR 2: " + jugador2.getNombre() + " - " + jugador2.getTipoArma());
        System.out.println("═".repeat(55));
        
        System.out.print("\n¿Listos para comenzar? (presiona Enter...)");
        scanner.nextLine();
        
        JuegoLucha juego = new JuegoLucha(jugador1, jugador2);
        juego.iniciarPelea();
        
        System.out.println("\n¡Gracias por jugar!");
        scanner.close();
    }
    
    private static Personaje seleccionarPersonaje(Scanner scanner, int numeroJugador) {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("JUGADOR " + numeroJugador + ", ES TU TURNO:");
        System.out.print("Elige tu personaje (1-5): ");
        
        int opcion;
        try {
            opcion = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Se asignará Samurai.");
            opcion = 1;
            scanner.nextLine();
        }
        
        System.out.print("Ingresa el nombre para tu guerrero: ");
        String nombre = scanner.nextLine();
        
        switch (opcion) {
            case 1: return new Samurai(nombre);
            case 2: return new Espartano(nombre);
            case 3: return new Vikingo(nombre);
            case 4: return new Caballero(nombre);
            case 5: return new Romano(nombre);
            default: return new Samurai(nombre);
        }
    }
}