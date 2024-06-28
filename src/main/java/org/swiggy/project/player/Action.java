package org.swiggy.project.player;

public interface Action {
    int attack();
    int defend();
    void takeDamage(int damage);
    boolean isAlive();
    int getHealth();
}
