package Pokemons;

import java.util.ArrayList;
import java.util.List;
import Interfaces.Observer;
import Interfaces.Subject;

public abstract class Pokemon implements Subject {
    public int health;
    public String name;
    protected List<Observer> observers = new ArrayList<>();

    public Pokemon(int health, String name) {
        this.health = health;
        this.name = name;
    }

    public abstract void attack(Pokemon opponent);

    public void register(Observer o) {
        observers.add(o);
    }

    public void unregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String moveName) {
        for (Observer o : observers) {
            o.update(name, health);
        }
    }

	public abstract int getHealth();

	public abstract boolean isStrongAgainst(Pokemon weakestOpponentPokemon);
}
