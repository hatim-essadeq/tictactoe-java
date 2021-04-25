package com.essadeq;

public class Player {
    private String name;
    private char choice;
    private int score;

    public Player() {
    }

    public Player(String name, char choice) {
        this.name = name;
        this.choice = choice;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getChoice() {
        return choice;
    }

    public void setChoice(char choice) {
        this.choice = choice;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", choice=" + choice +
                ", score=" + score +
                '}';
    }
}
