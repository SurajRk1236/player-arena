package org.swiggy.project.playing_requirements;

public class Die {
    private static final int SIDES = 6;

    public static int roll() {
        return (int) (Math.random() * SIDES) + 1;
    }
}
