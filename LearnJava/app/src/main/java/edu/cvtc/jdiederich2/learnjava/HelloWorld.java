package edu.cvtc.jdiederich2.learnjava;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("My first java program");

        int lives = 3;
        boolean isGameOver = (lives < 1);
        System.out.println(isGameOver);

        if(isGameOver) {
            System.out.println("Game over!");
        } else {
            System.out.println("Not dead yet!");
        }

    }
}
