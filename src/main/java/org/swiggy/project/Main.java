package org.swiggy.project;


import org.swiggy.project.playing_area.Arena;
import org.swiggy.project.player.BasePlayer;
import org.swiggy.project.player.Player;

public class Main {
    public static void main(String[] args) {
        if (args.length < 6) {
            System.out.println("Usage: java Main <healthA> <powerA> <defenseA> <healthB> <powerB> <defenseB>");
            return;
        }

        // Parse command line arguments
        int healthA = Integer.parseInt(args[0]);
        int powerA = Integer.parseInt(args[1]);
        int defenseA = Integer.parseInt(args[2]);
        int healthB = Integer.parseInt(args[3]);
        int powerB = Integer.parseInt(args[4]);
        int defenseB = Integer.parseInt(args[5]);

        // Create players
        BasePlayer playerA = new Player(healthA, powerA, defenseA);
        BasePlayer playerB = new Player(healthB, powerB, defenseB);
        Arena arena = new Arena();
        arena.fight(playerA, playerB);
    }
}