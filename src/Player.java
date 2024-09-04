import java.util.ArrayList;

public class Player {
    String name;
    int points;
    ArrayList<Dice> dice;

    public Player(String name, ArrayList<Dice> dice) {
        this.name = name;
        points = 0;
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void rollDice() {
        for (Dice die : dice) {
            die.roll();
        }
    }

    public int getDieValue() {
        int totalValue = 0;
        for (Dice die : dice) {
            totalValue = totalValue += die.getValue();
        }
        return totalValue;
    }

    public void increaseScore() {
        this.points += 1;
    }

    public void addDie(int sides) {
        Dice die = new Dice(sides);
        this.dice.add(die);
    }
}
