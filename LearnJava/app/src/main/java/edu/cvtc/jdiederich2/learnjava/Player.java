package edu.cvtc.jdiederich2.learnjava;

public class Player {
    private String handleName;
    private int lives;
    private int level;
    private int score;

    public Player() {
        this("Unknown player");
    }

    public Player(String handle) {
        this(handle, 1);
//        this.handleName = handle;
//        lives = 3;
//        level = 1;
//        score = 0;

    }

    public Player(String handle, int startingLevel) {
//        this.handleName = handle;
//        this.lives = 3;
//        this.level = startingLevel;
//        this.score = 0;
        setHandleName(handle);
        setLives(3);
        setLevel(startingLevel);
        setScore(0);
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handle) {
        if(handle.length() < 3) {
            System.out.println("Please enter a name with 4 or more characters");
            return;
        }
        this.handleName = handle;
    }

    public void setNameAndLevel(String name, int level) {
//        this.handleName = name;
//        this.level = level;
        setHandleName(name);
        setLevel(level);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
