package com.essadeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void begin(char[][] board) throws IOException {

        if (checkWinner(board, player2, player1)) return;

        if (checkWinner(board, player1, player2)) return;

        if (isDraw(board))
            begin(board);
        else
            System.out.println("DRAW !!");
    }

    private boolean checkWinner(char[][] board, Player player2, Player player1) throws IOException {
        if (!isWinner(player2, board) && isDraw(board)) {
            System.out.println("is " + player1.getName() + " - " + player1.getChoice());
            play(player1, board);
        } else if (!isWinner(player1, board) && isDraw(board)) {
            System.out.println("winner " + player2.getName() + " - " + player2.getChoice());
            return true;
        }
        return false;
    }

    private void play(Player player, char[][] board) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Reading data using readLine
        String position = reader.readLine();
        int i = getY(position);
        int j = getX(position);
        int len = board.length - 1;
        if (position.contains(".") && i != -1 && j != -1) {

            if ((i <= len && j <= len) && board[i][j] == '*') {
                board[i][j] = player.getChoice();
                display(board);
            } else {
                System.out.println("Error, try another position");
                play(player, board);
            }
        } else {
            System.out.println("Error, Incorrect format, try again. EX. x.y");
            play(player, board);
        }

    }

    private boolean isWinner(Player player, char[][] board) {
        boolean winner = false;
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == player.getChoice()) {
                    winner = true;
                } else {
                    winner = false;
                    break;
                }
            }
            if (winner) {
                System.out.println("inside" + player.getChoice());
                player.setScore(player.getScore() + 1);
                return true;
            }
        }

        for (int j = 0; j < board.length; j++) {
            for (char[] chars : board) {
                if (chars[j] == player.getChoice()) {
                    winner = true;
                } else {
                    winner = false;
                    break;
                }
            }
            if (winner) {
                player.setScore(player.getScore() + 1);
                return true;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == player.getChoice()) {
                winner = true;
            } else {
                winner = false;
                break;
            }
        }

        if (winner) {
            player.setScore(player.getScore() + 1);
            return true;
        }

        for (int i = board.length - 1; i >= 0; i--) {
            if (board[(board.length - 1) - i][i] == player.getChoice()) {
                winner = true;
            } else {
                winner = false;
                break;
            }
        }
        if (winner) {
            player.setScore(player.getScore() + 1);
            return true;
        }
        return false;
    }

    private boolean isDraw(char[][] board) {
        boolean draw = false;
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar != '*') {
                    draw = true;
                } else {
                    draw = false;
                    break;
                }
            }
        }
        return !draw;
    }

    private int getX(String position) {
        return getInt(position.split("\\.")[1]);
    }

    private int getY(String position) {
        return getInt(position.split("\\.")[0]);
    }

    private int getInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void display(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }
}
