package player;

import game.Game;

public class Player {
    // Attribute
    private String name;
    private int currentPoint;
    private String defeatPhrase;
    private boolean isWin;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.currentPoint = 0;
        this.defeatPhrase = "Darn it, defeated again! :(";
        this.isWin = false;
    }

    public Player(String name, String defeatPhrase) {
        this(name);
        this.defeatPhrase = defeatPhrase;
        this.isWin = false;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(int currentPoint) {
        this.currentPoint = currentPoint;
    }

    public String getDefeatPhrase() {
        return defeatPhrase;
    }

    public void setDefeatPhrase(String defeatPhrase) {
        this.defeatPhrase = defeatPhrase;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    // Method to add point
    public void addPoint(int point) {
        System.out.println(name + "'s turn");
        System.out.println(name + " got " + point + " points");
        currentPoint += point;
        if (currentPoint > Game.MAX_POINTS) {
            currentPoint = 0;
        }
        System.out.println("Now " + name + " has " + currentPoint + " points");
        if (currentPoint == Game.MAX_POINTS) {
            isWin = true;
        }
    }

    // Method to show when win
    public void winShow() {
        System.out.println(name + " won!!!");
    }

    // Method to show when defeat
    public void defeatShow() {
        System.out.println(name + ": " + defeatPhrase);
    }

    // Override equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player player) {
            return name.equals(player.getName());
        }
        return false;
    }
}
