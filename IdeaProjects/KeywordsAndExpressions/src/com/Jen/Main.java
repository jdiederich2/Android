package com.Jen;

public class Main {

    public static void main(String[] args) {

        // a mile is equal to 1.609344 kilometers
        double kilometers = (100 * 1.609344);  // Expression starts at kilometers to end minus ;

        int highScore = 50;
        if (highScore == 50) {  // Expression is "highScore == 50

        }

        highScore = calculateScore(true, 800, 5, 100);

        System.out.println("Your final score is: " + highScore);

        int highScorePosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Tim", highScorePosition);

        highScorePosition = calculateHighScorePosition(900);
        displayHighScorePosition("Jack", highScorePosition);

        highScorePosition = calculateHighScorePosition(400);
        displayHighScorePosition("Jill", highScorePosition);

        highScorePosition = calculateHighScorePosition(90);
        displayHighScorePosition("Jen", highScorePosition);

        int newScore = calculateScore("jen", 500);
        System.out.println("New score is " + newScore);

        double test1 = calcFeetAndInchesToCentimeters(2, 6);
        double test2 = calcFeetAndInchesToCentimeters(-1, 6);
        calcFeetAndInchesToCentimeters(6,0);
        calcFeetAndInchesToCentimeters(6,13);

        double test3 = calcFeetAndInchesToCentimeters(7.5);
        double test4 = calcFeetAndInchesToCentimeters(18);
        calcFeetAndInchesToCentimeters(52);

        calcFeetAndInchesToCentimeters(157);
    }



    public static int calculateScore(String playerName, int score) {
        System.out.println("Player name is: " + playerName + " Score is: " + score);
        return score * 1000;
    }


    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if(gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            return finalScore;
        }
        return -1;
    }

    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println(playerName + " managed to get into position " + position);
    }

    public static int calculateHighScorePosition(int playerScore) {
        if(playerScore >= 1000) {
            return 1;
        } else if(playerScore >= 500 && playerScore < 1000) {
            return 2;
        } else if(playerScore >=100 && playerScore < 500) {
            return 3;
        } else {
            return 4;
        }
    }


    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if(feet >= 0 && inches >= 0 && inches <= 12) {
            double centimeters = (inches * 2.54) + (feet * 12) * 2.54;
            System.out.println(feet + " feet & " + inches + "inches = " + centimeters + " centimeters");
            return centimeters;
        }
        System.out.println("Please enter a positive value");
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {

        double feet;

        if(inches >= 0 && inches < 12 ) {
            return calcFeetAndInchesToCentimeters(0, inches);

        } else if(inches > 12){
            feet = (int)inches / 12;
            inches = (int)inches % 12;

            return calcFeetAndInchesToCentimeters(feet, inches);
        }

        System.out.println("Please enter a positive number");
        return -1;
    }


}
