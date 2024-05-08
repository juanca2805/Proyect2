package Battle;

import java.util.Scanner;

import Interfaces.AiController;
import Pokemons.Pokemon;

public class Battle {
    private Pokemon p1;
    private Pokemon p2;
    private Scanner sc;

    public void start() {
        System.out.println("Ingresa el nombre del primer Pokémon (escribe 'AI' para controlado por computadora): ");
        sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("AI")) {
            p1 = new AiController().choosePokemon();
        } else {
            p1 = new PokemonFactory().createPokemon(input);
        }

        System.out.println("Ingresa el nombre del segundo Pokémon (escribe 'AI' para controlado por computadora): ");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("AI")) {
            p2 = new AiController().choosePokemon();
        } else {
            p2 = new PokemonFactory().createPokemon(input);
        }

        while (p1.health > 0 && p2.health > 0) {
            p1.attack(p2);
            if (p2.health > 0) {
                p2.attack(p1);
            }
        }

        if (p1.health > 0) {
            System.out.println("El ganador es: " + p1.name);
        } else {
            System.out.println("El ganador es: " + p2.name);
        }
    }
}
