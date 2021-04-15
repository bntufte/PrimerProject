package com.revature;

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
            if (winCount < 2) {
                beginCreatureEncounter(player);
            } else {
                beginBossEncounter(player);
            }
        } while (winCount < 3 && lostCount < 5);
        endGame();
    }

    private void beginCreatureEncounter(Player player) {
        //TODO: Generate a creature randomly
        Creature creature = new Creature();
        beginBattle(player, creature);
    }


    private void beginBossEncounter(Player player) {
        //TODO: Generate a boss creature
        Creature creature = new Creature();
        beginBattle(player, creature);
    }

    private void beginBattle(Player player, Creature creature) {
        int roundsWon = 0;
        int roundsTotal = 0;
        outputToConsole(String.format("%s encounters a %s. It looks like %s. Prepare to battle!", player.name, creature.name, creature.description));
        do {
            //TODO: Call player to throw a sign
            player.sign = "scissors";
            //TODO: Call creature to throw a sign
            creature.sign = "paper";
            try {
                boolean result = evaluateRound(player.sign, creature.sign);
                if (result) {
                    roundsWon += 1;
                }
                roundsTotal += 1;
                //TODO: Change generic Exception to TIE exception
            } catch (Exception e) {
                outputToConsole("You and the creature resulted in a tie. A new round will start. Enter any key to continue.");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
        } while (roundsTotal < 3);

        if (roundsWon >= 2) {
            winCount ++;
        } else {
            lostCount += 1;
            winCount = 0;
        }
    }

    private boolean evaluateRound(String playerSign, String creatureSign) throws Exception {
        switch (playerSign.toUpperCase()) {
            case "P":
                return isPlayerWon(creatureSign, "R", "S");
            case "R":
                return isPlayerWon(creatureSign, "S", "P");
            case "S":
                return isPlayerWon(creatureSign, "P", "R");
            default:
                //TODO: handle input other than r, p, and s
                return false;
        }
    }

    private boolean isPlayerWon(String creatureSign, String winningSign, String losingSign) throws Exception {
        if (creatureSign.equalsIgnoreCase(winningSign)) {
            return true;
        } else {
            if (creatureSign.equalsIgnoreCase(losingSign)) {
                return false;
            } else {
                //TODO: Throw a "TIE" exception
                throw new Exception();
            }
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

    private class Creature {
        private String name;
        private String description;
        private String sign;

        public Creature() { }

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
