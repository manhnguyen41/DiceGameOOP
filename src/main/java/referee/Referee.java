package referee;

import game.Game;
import player.Player;
import player.VirtualPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Referee {
    // Constructor
    public Referee() {

    }

    // Method to init a game
    public Game initGame() throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Get number of players
        System.out.println("Enter the number of players (0-" + Game.MAX_PLAYERS + "):");
        int n = scanner.nextInt();
        if (n < 0 || n > Game.MAX_PLAYERS) {
            throw new Exception("Number of players must between 0 and "
                    + Game.MAX_PLAYERS + "\n");
        }
        Game game = new Game();

        // Add players
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the name of player " + i);
            if (i == 1) {
                scanner.nextLine();
            }
            String name = scanner.nextLine();
            if (name.equals("\n")) {
                throw new Exception("Name must not be empty\n");
            }
            game.addPlayer(name);
        }

        // Add virtual players
        for (int i = 1; i <= Game.MAX_PLAYERS - n; i++) {
            game.addVirtualPlayer(i);
        }

        // Add dices
        game.addDice(new int[]{20, 16, 16, 16, 16, 16});
        game.addDice(new int[]{16, 20, 16, 16, 16, 16});
        game.addDice(new int[]{16, 16, 20, 16, 16, 16});
        game.addDice(new int[]{16, 16, 16, 20, 16, 16});

        return game;
    }

    // Method to start a game
    public void startGame(Game game) throws IOException {
        do {
            game.roll();
            if (game.isEnd()) {
                break;
            }
            game.nextTurn();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Press any key for next turn");
            input.readLine();
        } while (true);
    }
}
