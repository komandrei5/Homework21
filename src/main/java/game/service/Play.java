package game.service;

import game.dto.Player;

import java.util.Random;
import java.util.Scanner;

public class Play {
    public void play() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the number of games: ");
        int numberOfGames = scanner.nextInt();

        Player player = new Player(name);


        for (int i = 0; i < numberOfGames; i++) {
            System.out.println("Game " + (i + 1));

            int playerChoice = getPlayerChoice(scanner);
            if (playerChoice == -1) {
                break;
            }

            int computerChoice = generateComputerChoice();
            System.out.println("Your choice: " + getChoiceName(playerChoice));
            System.out.println("Computer's choice: " + getChoiceName(computerChoice));

            int result = determineWinner(playerChoice, computerChoice);
            if (result == 1) {
                System.out.println("You win!");
                player.incrementWins();
            } else if (result == -1) {
                System.out.println("You lose!");
                player.incrementLosses();
            } else {
                System.out.println("It's a tie!");
            }
            player.incrementTotalGames();

            System.out.println();
            System.out.println("-------------");
            System.out.println();
        }

        System.out.println(player.getPlayerResult());
    }

    private int getPlayerChoice(Scanner scanner) {
        System.out.println("Choose an option:");
        System.out.println("1. Rock");
        System.out.println("2. Scissors");
        System.out.println("3. Paper");
        System.out.println("0. Quit the game");

        int choice = scanner.nextInt();
        if (choice == 0) {
            return -1;
        } else if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice. Please try again.");
            return getPlayerChoice(scanner);
        }

        return choice;
    }

    private int generateComputerChoice() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    private String getChoiceName(int choice) {
        if (choice == 1) {
            return "Rock";
        } else if (choice == 2) {
            return "Scissors";
        } else {
            return "Paper";
        }
    }

    private int determineWinner(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return 0;
        } else if (
                (playerChoice == 1 && computerChoice == 2) ||
                        (playerChoice == 2 && computerChoice == 3) ||
                        (playerChoice == 3 && computerChoice == 1)
        ) {
            return 1;
        } else {
            return -1;
        }
    }
}
