package com.nemopss;

import java.io.IOException;

public class Game {
    public Game() throws IOException {
        startGameLoop();
    }
    public void startGameLoop() throws IOException {
        Hangman hangman = new Hangman();
        Word wordToGuess = new Word();
        hangman.draw(hangman.getState());
        wordToGuess.displayWord();
        while (!(wordToGuess.guessed()) && (hangman.alive())) {
            System.out.println(wordToGuess.getWord());
            if (!wordToGuess.tryGuessChar()) {
                hangman.badGuess();
                hangman.draw(hangman.getState());
                if (!hangman.alive()) {
                    break;
                }
                wordToGuess.displayWord();
            }
            else {
                wordToGuess.displayWord();
            }
        }
    }
}
