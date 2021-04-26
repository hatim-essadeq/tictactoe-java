package com.essadeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    Main() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("WELCOME TO TIC TAC TOE CONSOLE GAME BY H@T!M : \t ");
        /*System.out.println("=> For 1 player : Tap '1' , For 2 players : Tap 2 ");

        String answer = reader.readLine();

        if (answer.equals("1")) {
            System.out.print("=> Enter your name : ");
            answer = reader.readLine();

        } else if (answer.equals("2")) {
            System.out.println("=> For 1 player : Tap '1' , For 2 players : Tap 2 ");

        } else {
            new Main();
        }*/

        Player p1 = new Player("hatim", 'X');
        Player p2 = new Player("rhita", 'O');
        Game game = new Game(p1, p2);
        char[][] board = {{'*', '*', '*'}, {'*', '*', '*'}, {'*', '*', '*'}};
//        game.begin(board);

        System.out.println("START GAME ??");
        String answer = reader.readLine();
        while (answer.equals("yes")) {
            game.begin(board);
            board = new char[][]{{'*', '*', '*'}, {'*', '*', '*'}, {'*', '*', '*'}};
            System.out.println("==========================================================================================");
            System.out.println(game);
            System.out.println("==========================================================================================");
            System.out.println("RESTART GAME ??");
            answer = reader.readLine();
        }
        System.out.println("==========================================================================================");
        System.out.println(game);
    }


    public static void main(String[] args) throws IOException {
        new Main();
    }
}
