package com.revature.view;

import com.revature.exceptions.IncorrectInputException;
import com.revature.exceptions.TieException;
import com.revature.model.*;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/** This class is the driver that will begin a game or end the game. */
public class Game {
  private int winCount;
  private int lostCount;
  private List<String> inputs;
  private static final String YOU_WIN = "YOU WIN!";

  public Game() {
    inputs = getInputList();
  }

  /** Starts the game */
  public void startGame() {
    Scanner scanner = new Scanner(System.in);
    do {
      outputToConsole("1. enter 1 to start game" + "\n2. enter 2 to exit");
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

  private List<String> getInputList() {
    try (Scanner scanner =
        new Scanner(
            new File(
                "C:\\Users\\mattd\\IdeaProjects\\revature-practice\\PrimerProject\\src\\main\\resources\\inputs.txt"))) {
      return Arrays.asList(scanner.nextLine().split(","));
    } catch (Exception e) {
      outputToConsole("No input file found!\n" + e.getMessage());
    }
    return Collections.emptyList();
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
    Creature creature = getCreature();
    outputToConsole(
        String.format(
            "%s encounters a %s. It looks like %s. Prepare to battle!",
            player.getName(), creature.getName(), creature.getDescription()));
    beginBattle(player, creature);
  }

  private Creature getCreature() {
    String creatureNum = Integer.toString((int) ((Math.random() * (2 - 0)) + 0));
    switch (creatureNum) {
      case "0":
        return new Boomba();
      case "1":
        return new Chainchew();
      case "2":
        return new AxeBro();
      default:
        return new Trouser();
    }
  }

  private void beginBossEncounter(Player player) {
    Creature creature = new Trouser();
    outputToConsole(
        String.format(
            "%s encounters the BOSS %s. It looks like %s. Prepare to battle!",
            player.getName(), creature.getName(), creature.getDescription()));
    beginBattle(player, creature);
  }

  private void beginBattle(Player player, Creature creature) {
    int roundsWon = 0;
    int roundsTotal = 0;
    do {
      try {
        outputToConsole(String.format("BEGIN ROUND %s", roundsTotal + 1));
        player.setSign(getPlayerSign());
        boolean result = evaluateRound(player.getSign(), creature.getSign(inputs));
        if (result) {
          roundsWon += 1;
        }
        roundsTotal += 1;
      } catch (Exception e) {
        outputToConsole(
            "You and the creature resulted in a tie. A new round will start. Enter any key to continue.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
      }
    } while (roundsTotal < 3);

    if (roundsWon >= 2) {
      winCount++;
      outputToConsole(creature.die());
      outputToConsole("Press enter to continue");
      new Scanner(System.in).nextLine();
    } else {
      lostCount += 1;
      winCount = 0;
    }
  }

  private String getPlayerSign() {
    outputToConsole("What do you draw? (p = paper, r = rock, s = scissor)");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  private boolean evaluateRound(String playerSign, String creatureSign)
      throws IncorrectInputException, TieException {
    switch (playerSign.toUpperCase()) {
      case "P":
        return isPlayerWon(creatureSign, "R", "S");
      case "R":
        return isPlayerWon(creatureSign, "S", "P");
      case "S":
        return isPlayerWon(creatureSign, "P", "R");
      default:
        throw new IncorrectInputException("Incorrect input!");
    }
  }

  private boolean isPlayerWon(String creatureSign, String winningSign, String losingSign)
      throws TieException {
    if (creatureSign.equalsIgnoreCase(winningSign)) {
      outputToConsole(String.format("You won this round"));
      return true;
    } else {
      if (creatureSign.equalsIgnoreCase(losingSign)) {
        outputToConsole(String.format("You lost this round"));
        return false;
      } else {
        throw new TieException("A tie occured!");
      }
    }
  }

  private void endGame() {
    if (winCount >= 3) {
      outputToConsole(YOU_WIN);
    } else {
      if (lostCount >= 5) {
        outputToConsole("You lost!");
      }
    }
  }

  private void outputToConsole(String prompt) {
    System.out.println(prompt);
  }
}
