package Battle;

import Pokemons.Bulbasaur;
import Pokemons.Caterpie;
import Pokemons.Charmander;
import Pokemons.Kingler;
import Pokemons.Krabby;
import Pokemons.Muk;
import Pokemons.Pidgeotto;
import Pokemons.Pikachu;
import Pokemons.Pokemon;
import Pokemons.Raticate;
import Pokemons.Squirtle;

class PokemonFactory {
    public Pokemon createPokemon(String name) {
        switch (name) {
            case "Pikachu":
                return new Pikachu();
            case "Caterpie":
                return new Caterpie();
            case "Pidgeotto":
                return new Pidgeotto();
            case "Bulbasaur":
                return new Bulbasaur();
            case "Charmander":
                return new Charmander();
            case "Squirtle":
                return new Squirtle();
            case "Krabby":
                return new Krabby();
            case "Raticate":
                return new Raticate();
            case "Muk":
                return new Muk();
            case "Kingler":
                return new Kingler();
            default:
                throw new IllegalArgumentException("Nombre de Pokémon no válido");
        }
    }
}

