package com.Jen;

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2;

        int previousResult = result;
        result = result - 1;

        System.out.println(previousResult + " - 1 = " + result);

        previousResult = result;
        result = result * 10;
        System.out.println(previousResult + " * 10 = " + result);

        boolean isAlien = false;
        if (isAlien == false) {
            System.out.println("It is not an alien!");
        } else {
            System.out.println("It's an alien... RUN !!!");
        }

        int topScore = 100;
        if (topScore != 100)
            System.out.println("You got the high score!");

        int secondTopScore = 80;
        if ((topScore > secondTopScore) && (topScore <= 100))
            System.out.println("Your score is topScore!");


    }
}
