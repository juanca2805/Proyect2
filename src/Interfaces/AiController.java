package Interfaces;

import Pokemons.*;
import java.util.ArrayList;
import java.util.List;

public class AiController implements Observer {
    public Pokemon choosePokemon() {

    	List<Class<? extends Pokemon>> pokemons = new ArrayList<>();
        pokemons.add(Pikachu.class);
        pokemons.add(Caterpie.class);
        pokemons.add(Pidgeotto.class);
        pokemons.add(Bulbasaur.class);
        pokemons.add(Charmander.class);
        pokemons.add(Squirtle.class);
        pokemons.add(Krabby.class);
        pokemons.add(Raticate.class);
        pokemons.add(Muk.class);
        pokemons.add(Kingler.class);

        int randomIndex = (int) (Math.random() * pokemons.size());

        try {
            return pokemons.get(randomIndex).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(String pokemonName, int health) {
        // Get a list of all the opponent's Pokemons
        List<Pokemon> opponentPokemons = getOpponentPokemons();

        // Loop through the opponent's Pokemons and find the one with the lowest health
        Pokemon weakestOpponentPokemon = null;
        int lowestHealth = Integer.MAX_VALUE;
        for (Pokemon pokemon : opponentPokemons) {
            if (pokemon.getHealth() < lowestHealth) {
                weakestOpponentPokemon = pokemon;
                lowestHealth = pokemon.getHealth();
            }
        }

        // If the AI has a Pokemon that is strong against the opponent's weakest Pokemon, choose that one
        List<Class<? extends Pokemon>> possiblePokemons = new ArrayList<>();
        Class<? extends Pokemon>[] pokemons = null;
		for (Class<? extends Pokemon> clazz : pokemons) {
            try {
                Pokemon pokemon = clazz.getDeclaredConstructor().newInstance();
                if (pokemon.isStrongAgainst(weakestOpponentPokemon)) {
                    possiblePokemons.add(clazz);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!possiblePokemons.isEmpty()) {
            choosePokemon(possiblePokemons);
            return;
        }

        // If there are no suitable Pokemons, just choose a random one
        choosePokemon();
    }

    // Helper method to get the opponent's Pokemons
    private List<Pokemon> getOpponentPokemons() {
		return null;
        // Implement this method based on your specific implementation
        // For example, you could get the opponent's Pokemons from a list of observers
        // or from a separate data structure that keeps track of all the Pokemons in the game
    }

    // Helper method to choose a Pokemon from a list of possible Pokemons
    private void choosePokemon(List<Class<? extends Pokemon>> possiblePokemons) {
        int randomIndex = (int) (Math.random() * possiblePokemons.size());
        try {
            Pokemon pokemon = possiblePokemons.get(randomIndex).newInstance();
            setSelectedPokemon(pokemon);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

	private void setSelectedPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		
	}
}