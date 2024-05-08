package Pokemons;

import java.util.Scanner;

public class Caterpie extends Pokemon {
    public Caterpie() {
        super(50, "Caterpie");
        moves = new String[]{"Placaje", "Tacleada", "Supersónico", "Drenadoras"};
    }

    private String[] moves;

	@Override
	public void attack(Pokemon opponent) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige un ataque para " + name);
        for (int i = 0; i < moves.length; i++) {
            System.out.println((i + 1) + ". " + moves[i]);
        }
        int choice = sc.nextInt() - 1;
        int damage = 10; // Placeholder damage value, feel free to modify

        if (opponent.health - damage <= 0) {
            opponent.health = 0;
            System.out.println(opponent.name + " ha sido derrotado!");
        } else {
            opponent.health -= damage;
            System.out.println("La salud de: "+opponent.name +" es de: "+ opponent.health);
            notifyObservers(moves[choice]);
        }
    }

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isStrongAgainst(Pokemon weakestOpponentPokemon) {
		// TODO Auto-generated method stub
		return false;
	}
}