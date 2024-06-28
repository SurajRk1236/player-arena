package org.swiggy.project.playing_area;

import org.swiggy.project.player.BasePlayer;

public class Arena {
    public void fight(BasePlayer playerA, BasePlayer playerB) {
        while (playerA.isAlive() && playerB.isAlive()) { // Game ends when any player's health reaches 0

            BasePlayer attacker = determineAttacker(playerA, playerB);
            BasePlayer defender = (attacker == playerA) ? playerB : playerA;

            executeRound(attacker, defender);
            printRoundSummary(playerA, playerB);
        }
        printWinner(playerA);
    }

    private BasePlayer determineAttacker(BasePlayer playerA, BasePlayer playerB) {
        // Player with lower health attacks first at the start of a match.
        return (playerA.getHealth() <= playerB.getHealth()) ? playerA : playerB;
    }

    private void executeRound(BasePlayer attacker, BasePlayer defender) {
        int attackDamage = attacker.attack();
        int defendDamage = defender.defend();
        int damageDealt = calculateDamage(attackDamage, defendDamage);

        if (damageDealt > 0) {
            defender.takeDamage(damageDealt); // Damage created by attacker which is in excess of the damage defended by the defender will reduce the health of the defender
        }

        printRoundDetails(attacker, defender, attackDamage, defendDamage, damageDealt);
    }

    private int calculateDamage(int attackDamage, int defendDamage) {
        return attackDamage - defendDamage;
    }

    private void printRoundDetails(BasePlayer attacker, BasePlayer defender, int attackDamage, int defendDamage, int damageDealt) {
        System.out.println(attacker + " attacks and deals " + attackDamage + " damage.");
        System.out.println(defender + " defends and blocks " + defendDamage + " damage.");
        System.out.println(defender + " takes " + damageDealt + " damage.");
    }

    private void printRoundSummary(BasePlayer playerA, BasePlayer playerB) {
        System.out.println("Player A health: " + playerA.getHealth() + ", Player B health: " + playerB.getHealth());
    }

    private void printWinner(BasePlayer playerA) {
        if (!playerA.isAlive()) {
            System.out.println("Player A is dead. Player B wins!");
        } else {
            System.out.println("Player B is dead. Player A wins!");
        }
    }
}
