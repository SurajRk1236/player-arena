package org.swiggy.project;


import org.swiggy.project.playing_area.Arena;
import org.swiggy.project.player.BasePlayer;
import org.swiggy.project.player.Player;

public class Main {
    public static void main(String[] args) {
        BasePlayer playerA = new Player(50, 5, 10);
        BasePlayer playerB = new Player(100, 10, 5);
        Arena arena = new Arena();
        arena.fight(playerA, playerB);
    }
}