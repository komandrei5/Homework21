package game;

import game.dto.Player;
import game.service.Play;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!!!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the number of games: ");
        int numberOfGames = scanner.nextInt();

        Player player = new Player(name);
        Play play = new Play();

        for (int i = 0; i < numberOfGames; i++) {
            System.out.println("Game " + (i + 1));
            int choice;
            int playerChoice;

            do {
                System.out.println("Choose an option:");
                System.out.println("1. Rock");
                System.out.println("2. Scissors");
                System.out.println("3. Paper");
                System.out.println("0. Quit the game");

                choice = scanner.nextInt();
                playerChoice = play.getPlayerChoice(choice);

                if (playerChoice == -2) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (playerChoice == -2);
            if (playerChoice == -1)
                break;

            int computerChoice = play.generateComputerChoice();
            System.out.println("Your choice: " + play.getChoiceName(playerChoice));
            System.out.println("Computer's choice: " + play.getChoiceName(computerChoice));

            String result = play.determineWinner(playerChoice, computerChoice);
            System.out.println(result);

            switch (result) {
                case "Draw":
                    player.incrementDrawGamePlayed();
                    break;
                case "Player":
                    player.incrementWins();
                    break;
                case "Computer":
                    player.incrementLosses();
                    break;
            }

            player.incrementTotalGames();

            System.out.println();
            System.out.println("-------------");
            System.out.println();
        }

        System.out.println(player.getPlayerResult());
    }
}