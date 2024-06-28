package org.swiggy.project.player;

import org.swiggy.project.playing_requirements.Die;

abstract public class BasePlayer implements Action {
    private int health;
    private final int strength;
    private final int attack;

    public BasePlayer(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public int attack() {
        return this.attack * Die.roll();
    }

    @Override
    public int defend() {
        return this.strength * Die.roll();
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0)
            health = 0; // check for health does not go below 0
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
