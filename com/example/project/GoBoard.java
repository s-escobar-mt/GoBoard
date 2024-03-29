package com.example.project;

import java.util.Scanner;

public class GoBoard {
    // go pieces ◯ ●
    static String[][] goBoard = new String[9][9];
    static Scanner scn = new Scanner(System.in);
    // keep track of what pieces are white or black
    static String white = "◯";
    static String black = "●";

    public static void main(String[] args) {
        Boolean flipper = false;    // Used to switch turns
        String curTurn = black;     // starts with black
        Boolean quit = false;       // exit condition
        while (quit == false){

            // Horizontal and vertical labeling
            System.out.println("    1  2  3  4  5  6  7  8  9");
            for (int i = 0; i < goBoard[0].length; i++) {
                System.out.print(i + 1);
                System.out.print(" ");
                for (int j = 0; j < goBoard[i].length; j++) {
                    if (goBoard[i][j] == null) {
                        System.out.print("--|");

                    } else {
                        System.out.print("--" + goBoard[i][j]);
                    }
                }
                // Will make a new row at the end of each j itteration
                System.out.println();
            }

            // Start of game play loop
            System.out.println("Enter x coordinate to place your piece:");
            int coorX = scn.nextInt();
            System.out.println("Enter y coordinate to place your piece:");
            int coorY = scn.nextInt();
            if (coorY > 9 || coorX >9){
                // determines out of bounds condition
                System.out.println("Out of bounds");
                continue;
            }
            
            if (goBoard[coorY-1][coorX-1] == null)
            {
                // determines the player's color
                if (flipper == true){
                    curTurn  = white;
                } else {
                    curTurn = black;
                }
                goBoard[coorY-1][coorX-1] = curTurn;
            }else {
                System.out.println("Placement unavailable, space is not empty");
                continue; // restarts turn
            }
            // Can quit here
            System.out.println("Continue to next turn? (y/n)");
            String ans = scn.next();
            if (ans.equals("n")){
                quit = true;
            }
            // Changes to opponents turn
            flipper = !flipper;

        }
        // Closes stream
        scn.close();
    }
}