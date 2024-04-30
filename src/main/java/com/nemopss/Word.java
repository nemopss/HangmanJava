package com.nemopss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Word {
    private int errorCount;
    private final int WORD_LENGTH;
    private List<String> words = getWords();
    private final String word;
    private Set<Character> guessedLetters;
    private Scanner in = new Scanner(System.in);

    public Word() throws IOException {
        this.errorCount = 0;
        this.word = chooseRandomWord(words);
        this.WORD_LENGTH = word.length();
        this.guessedLetters = new HashSet<>();
    }

    public void displayWord() {
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (!guessedLetters.contains(this.word.charAt(i))) {
                System.out.print("_");
            } else {
                System.out.print(this.word.charAt(i));
            }
        }
        System.out.println();
    }

    private List<String> getWords() throws IOException {
        List<String> words = new ArrayList<>();
        FileReader fr = new FileReader("/Users/nemopss/dev/pet/Hangman/src/main/java/com/nemopss/words.txt");
        Scanner in = new Scanner(fr);
        while (in.hasNextLine()) {
            words.add(in.nextLine());
        }
        fr.close();
        return words;
    }

    private static String chooseRandomWord(List<String> words) {
        Random random = new Random();
        return words.get(random.nextInt(0, 81)).toLowerCase();
    }

    public boolean guessed() {
        return this.word.chars().distinct().count() == guessedLetters.size();
    }

    public boolean tryGuessChar() {
        Character c = in.next().charAt(0);
        if (this.word.contains(c.toString().toLowerCase())) {
            guessedLetters.add(c);
            return true;
        } else {
            errorCount += 1;
            return false;
        }
    }
}
