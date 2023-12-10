package game;

import dice.Dice;
import player.Player;
import player.VirtualPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    // Attribute
    public static final int MAX_PLAYERS = 4;
    public static final int MAX_DICES = 4;
    public static final int MAX_POINTS = 21;
    private List<Player> playerList = new ArrayList<>();
    private List<Dice> diceList = new ArrayList<>();
    private int turn;
    private boolean isEnd;

    // Constructor
    public Game() {
        turn = 1;
        isEnd = false;
    }

    // Getter and Setter

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    // Method to add a player
    public void addPlayer(String name) throws Exception{
        Player newPlayer = new Player(name);
        boolean isExist = playerList.contains(newPlayer);
        if (isExist) {
            throw new Exception("Player is already exist!\n");
        }
        playerList.add(newPlayer);
        System.out.println("Added");
    }

    // Method to add a virtual player
    public void addVirtualPlayer(int id) throws Exception{
        Player newVirtualPlayer = new VirtualPlayer(id);
        playerList.add(newVirtualPlayer);
    }

    // Method to add a dice
    public void addDice(int []ratioList) {
        diceList.add(new Dice(ratioList));
    }

    // Method to go next turn
    public void nextTurn() {
        turn++;
    }

    // Method to make a player roll
    public void roll() {
        System.out.println("Turn " + turn);
        Player player = playerList.get(turn % Game.MAX_PLAYERS == 0 ? 3 : turn % Game.MAX_PLAYERS - 1);
        Random random = new Random();
        Dice dice = diceList.get(random.nextInt(4));
        int result = dice.roll();
        player.addPoint(result);
        if (player.isWin()) {
            isEnd = true;
            endGame(player);
        }
    }

    // Method to end game
    public void endGame(Player player) {
        player.winShow();
        playerList.remove(player);
        for (Player defeatedPlayer: playerList) {
            if (defeatedPlayer instanceof VirtualPlayer) {
                defeatedPlayer.defeatShow();
            }
        }
    }
}
