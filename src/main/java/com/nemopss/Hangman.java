package com.nemopss;

public class Hangman {
    private int state;
    private final int HEAD = 1;
    private final int BODY = 2;
    private final int LEFT_HAND = 3;
    private final int RIGHT_HAND = 4;
    private final int LEFT_LEG = 5;
    private final int RIGHT_LEG = 6;
    private final int STATES_COUNT = 7;

    public Hangman() {
        this.state = 0;
    }

    public int getState() {
        return state;
    }

    public void draw(int state) {
        switch (state) {
            case 0:
                System.out.println("   ------|");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("|-------|");
                break;
            case 1:
                System.out.println("   ------|");
                System.out.println("   |     O");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("|-------|");
                break;
            case 2:
                System.out.println("   ------|");
                System.out.println("   |     O");
                System.out.println("   |     |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("|-------|");
                break;
            case 3:
                System.out.println("   ------|");
                System.out.println("   |     O");
                System.out.println("   |    /|");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("|-------|");
                break;
            case 4:
                System.out.println("   ------|");
                System.out.println("   |     O");
                System.out.println("   |    /|\\");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("|-------|");
                break;
            case 5:
                System.out.println("   ------|");
                System.out.println("   |     O");
                System.out.println("   |    /|\\");
                System.out.println("   |    /");
                System.out.println("   |");
                System.out.println("|-------|");
                break;
            case 6:
                System.out.println("   ------|");
                System.out.println("   |     O");
                System.out.println("   |    /|\\");
                System.out.println("   |    / \\");
                System.out.println("   |");
                System.out.println("|-------|");
                System.out.println("ВЫ ПРОИГРАЛИ! Гойда!");
                break;
            default:
                System.out.println("Illegal state!");;
        }
    }

    public void drawAllStates() {
        for (int i = 0; i < STATES_COUNT; i++) {
            draw(i);
        }
    }

    public boolean alive() {
        return this.state != 6;
    }
    public void badGuess() {
        this.state += 1;
    }
}
