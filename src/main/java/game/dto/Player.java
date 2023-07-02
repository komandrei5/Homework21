package game.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Player {
    private String name;
    private Integer totalGames = 0;
    private Integer wins = 0;
    private Integer losses = 0;
    private Integer drawGamePlayed = 0;

    public Player(String name) {
        this.name = name;
    }

    public void incrementTotalGames() {
        totalGames++;
    }

    public void incrementWins() {
        wins++;
    }

    public void incrementLosses() {
        losses++;
    }

    public String getPlayerResult() {
        return "Game Results: \n" + "Player " + name + " win " + wins + " games from " + totalGames +
                ", and losses " + losses + ", and draw game played " + drawGamePlayed + ".";
    }
}
