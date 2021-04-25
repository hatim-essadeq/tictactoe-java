package com.essadeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    Main() throws IOException {
        Game game = new Game();
        Player p1 = new Player("hatim", 'X');
        Player p2 = new Player("rhita", 'O');
        game.setPlayer1(p1);
        game.setPlayer2(p2);
        char[][] board = {{'*', '*', '*'}, {'*', '*', '*'}, {'*', '*', '*'}};
        beginGame(game, board);

        System.out.println(game);


    }

    private void beginGame(Game game, char[][] board) throws IOException {

        if (!isWinner(game.getPlayer2(), board)) {
            System.out.println("is " + game.getPlayer1().getName() + " - " + game.getPlayer1().getChoice());
            play(game.getPlayer1(), board);
        } else {
            System.out.println("winner " + game.getPlayer2().getName() + " - " + game.getPlayer2().getChoice());
            return;
        }

        if (!isWinner(game.getPlayer1(), board)) {
            System.out.println("is " + game.getPlayer2().getName() + " - " + game.getPlayer2().getChoice());
            play(game.getPlayer2(), board);
        } else {
            System.out.println("winner " + game.getPlayer1().getName() + " - " + game.getPlayer1().getChoice());
            return;
        }

        beginGame(game, board);
    }

    private void play(Player player, char[][] board) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Reading data using readLine
        String position = reader.readLine();
        if (board[getY(position)][getX(position)] == '*') {
            board[getY(position)][getX(position)] = player.getChoice();
            display(board);
        } else {
            System.out.println("Error, try another position");
            play(player, board);
        }
    }

    private boolean isWinner(Player player, char[][] board) {
        boolean winner = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player.getChoice()) {
                    winner = true;
                } else {
                    winner = false;
                    break;
                }
            }
            if (winner) {
                player.setScore(player.getScore() + 1);
                break;
            }
        }

        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == player.getChoice()) {
                    winner = true;
                } else {
                    winner = false;
                    break;
                }
            }
            if (winner) {
                player.setScore(player.getScore() + 1);
                break;
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
            return winner;
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
            return winner;
        }


        return winner;
    }


    private int getX(String position) {
        return Integer.parseInt(position.split(",")[1]);
    }

    private int getY(String position) {
        return Integer.parseInt(position.split(",")[0]);
    }

    private void display(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
