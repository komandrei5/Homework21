package game.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlayTest {
    Play play = new Play();
    @Test
    void getPlayerChoiceValid() {

        Assertions.assertEquals(2,play.getPlayerChoice(2));
    }
    @Test
    void getPlayerChoiceInvalid() {
        Assertions.assertEquals(-1, play.getPlayerChoice(0));
    }
    @Test
    void getPlayerChoiceQuitGame() {
        Assertions.assertEquals(-2, play.getPlayerChoice(5));
    }


    @Test
    void generateComputerChoiceInRange() {
        int computerChoice = play.generateComputerChoice();
        Assertions.assertTrue(computerChoice >= 1 && computerChoice <= 3);
    }


    @Test
    void getChoiceNameRock() {
        int choice = 1;
        String expected = "Rock";
        String actual = play.getChoiceName(choice);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getChoiceNameScissors() {
        int choice = 2;
        String expected = "Scissors";
        String actual = play.getChoiceName(choice);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getChoiceNamePaper() {
        int choice = 3;
        String expected = "Paper";
        String actual = play.getChoiceName(choice);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void determineWinnerPlayerRockComputerScissors() {
        int playerChoice = 1; // Rock
        int computerChoice = 2; // Scissors
        String expected = "Player";
        String actual = play.determineWinner(playerChoice, computerChoice);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void determineWinnerPlayerScissorsComputerPaper() {
        int playerChoice = 2; // Scissors
        int computerChoice = 3; // Paper
        String expected = "Player";
        String actual = play.determineWinner(playerChoice, computerChoice);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void determineWinnerPlayerPaperComputerRock() {
        int playerChoice = 3; // Paper
        int computerChoice = 1; // Rock
        String expected = "Player";
        String actual = play.determineWinner(playerChoice, computerChoice);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void determineWinnerDraw() {
        int playerChoice = 1; // Rock
        int computerChoice = 1; // Rock
        String expected = "Draw";
        String actual = play.determineWinner(playerChoice, computerChoice);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void determineWinnerComputerWins() {
        int playerChoice = 2; // Scissors
        int computerChoice = 1; // Rock
        String expected = "Computer";
        String actual = play.determineWinner(playerChoice, computerChoice);
        Assertions.assertEquals(expected, actual);
    }
}