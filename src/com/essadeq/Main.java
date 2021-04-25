package com.essadeq;

import java.io.IOException;

public class Main {

    Main() throws IOException {
        System.out.println("WELCOME TO TIC TAC TOE CONSOLE GAME BY H@T!M : \t ");
        Player p1 = new Player("hatim", 'X');
        Player p2 = new Player("rhita", 'O');
        Game game = new Game(p1, p2);
        char[][] board = {{'*', '*', '*'}, {'*', '*', '*'}, {'*', '*', '*'}};
        game.begin(board);
        System.out.println(game);
    }


    public static void main(String[] args) throws IOException {
        new Main();
    }
}
