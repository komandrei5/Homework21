package game.service;

import java.util.Random;

public class Play {
    public int getPlayerChoice(int choice) {
        if (choice == 0) {
            return -1;
        } else if (choice < 1 || choice > 3) {
            return -2;
        } else
        return choice;
    }

    public int generateComputerChoice() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    public String getChoiceName(int choice) {
        if (choice == 1) {
            return "Rock";
        } else if (choice == 2) {
            return "Scissors";
        } else {
            return "Paper";
        }
    }

    public String determineWinner(int playerChoice, int computerChoice) {
        String[][] resultGame = {
                {"Draw", "Player", "Computer"},
                {"Computer", "Draw", "Player"},
                {"Player", "Computer", "Draw"}
        };

        String winner = resultGame[playerChoice - 1][computerChoice - 1];
        return winner;
    }
}

