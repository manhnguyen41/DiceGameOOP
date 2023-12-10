package dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
    // Attribute
    private List<Integer> ratioList = new ArrayList<>();

    // Constructor
    public Dice(int []ratioList) {
        for (int j : ratioList) {
            this.ratioList.add(j);
        }
    }

    // Getter and Setter
    public List<Integer> getRatioList() {
        return ratioList;
    }

    public void setRatioList(List<Integer> ratioList) {
        this.ratioList = ratioList;
    }

    // Method to roll
    public int roll() {
        Random random = new Random();
        int result = random.nextInt(100) + 1;
        for (int i = 0; i < ratioList.size(); i++) {
            result -= ratioList.get(i);
            if (result < 0) {
                return i + 1;
            }
        }
        return 0;
    }
}
