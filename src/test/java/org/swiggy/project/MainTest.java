package org.swiggy.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.swiggy.project.player.BasePlayer;
import org.swiggy.project.player.Player;
import org.swiggy.project.playing_area.Arena;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private BasePlayer playerA;
    private BasePlayer playerB;
    private Arena arena;

    //this setup is regarding given example in question
    @BeforeEach
    void setUp() {
        playerA = new Player(50, 5, 10);
        playerB = new Player(100, 10, 5);
        arena = new Arena();
    }

    @Test
    void testArenaFightAtLeastOnePlayerDies() {
        arena.fight(playerA, playerB);
        assertTrue(playerA.getHealth() == 0 || playerB.getHealth() == 0);
    }
}