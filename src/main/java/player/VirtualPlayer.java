package player;

public class VirtualPlayer extends Player{
    // Attribute
    private static final String[] DEFEAT_PHRASES = {
            "Oh no, defeated once more!",
            "Back to the drawing board...",
            "Four-gone conclusion, I lost!",
            "Defeat snatched from the jaws of victory."
    };

    // Constructor
    public VirtualPlayer(int id) {
        super("Virtual Player " + id, DEFEAT_PHRASES[id - 1]);
    }
}
