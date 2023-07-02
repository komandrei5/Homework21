package game.service;

import game.dto.Player;

import java.util.Random;
import java.util.Scanner;

public class Play {
        public int getPlayerChoice(Scanner scanner){
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

        public int generateComputerChoice() {
            Random random = new Random();
            return random.nextInt(3) + 1;
        }

        public String getChoiceName(int choice){
            if (choice == 1) {
                return "Rock";
            } else if (choice == 2) {
                return "Scissors";
            } else {
                return "Paper";
            }
        }

        public int determineWinner(int playerChoice, int computerChoice){
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
