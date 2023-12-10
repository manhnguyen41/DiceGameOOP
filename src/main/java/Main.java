import game.Game;
import referee.Referee;

public class Main {
    public static void main(String[] args) throws Exception {
        Referee referee = new Referee();
        Game game = referee.initGame();
        referee.startGame(game);
    }
}
