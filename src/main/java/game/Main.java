package game;

import game.dto.Player;
import game.service.Play;

import java.util.Random;
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

            int playerChoice = play.getPlayerChoice(scanner);
            if (playerChoice == -1) {
                break;
            }

            int computerChoice = play.generateComputerChoice();
            System.out.println("Your choice: " + play.getChoiceName(playerChoice));
            System.out.println("Computer's choice: " + play.getChoiceName(computerChoice));

            int result = play.determineWinner(playerChoice, computerChoice);
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
}