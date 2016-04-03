package com.example;

import java.util.Random;

public class Joke {

    private static String[] jokes;
    private static Random random;

    public Joke() {
        jokes = new String[8];
        jokes[0] = "A programmer is told to \"go to hell\", he finds the worst part of that statement is the \"go to\"";
        jokes[1] = "There are only 10 kinds of people in this world: those who know binary and those who don’t.";
        jokes[2] = "A programmer walks to the butcher shop and buys a kilo of meat.  An hour later he comes back upset that the butcher shortchanged him by 24 grams.";
        jokes[3] = "Programming is 10% science, 20% ingenuity, and 70% getting the ingenuity to work with the science.";
        jokes[4] = "All programmers are playwrights, and all computers are lousy actors.";
        jokes[5] = "Have you heard about the new Cray super computer?  It’s so fast, it executes an infinite loop in 6 seconds.\n";
        jokes[6] = "The generation of random numbers is too important to be left to chance.";
        jokes[7] = "Programming is like sex,One mistake and you have to support it for the rest of your life.";

        random = new Random();
    }

    public String[] getJokes() {
        return jokes;
    }

    public static String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
