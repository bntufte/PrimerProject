package com.revature;

import java.io.InputStream;
import java.util.Scanner;

/**
 * This class is the driver that will begin a game or end the game.
 */
public class Game {
    private int winCount;
    private int lostCount;

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        do {
            outputToConsole("1. enter 1 to start game" +
                    "\n2. enter 2 to exit");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    playGame();
                    break;
                case "2":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true);
    }

    private void playGame() {
        Scanner scanner = new Scanner(System.in);
        outputToConsole("Welcome Electrician, what is your name?");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        do {

        } while (winCount < 3 && lostCount < 5);
        endGame();
    }

    private boolean evaluateRound(String playerSign, String creatureSign) {
        switch () {

        }
    }

    private void endGame() {
        if (winCount >= 3) {
            outputToConsole("You won!");
        } else {
            if (lostCount >= 5) {
                outputToConsole("You lost!");
            }
        }
    }

    private void outputToConsole(String prompt) {
        System.out.println(prompt);
    }


    //TODO: remove these classes once properly implemented
    private class Player {
        private String name;
        private String description;
        private String sign;
        Player(String name) { }
    }

    private abstract class Creature {
        private String name;
        private String description;
        private String sign;

        public Creature(String name, String description, String sign) {
            this.name = name;
            this.description = description;
            this.sign = sign;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
