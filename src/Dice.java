import java.util.Random;

public class Dice {
    private int sides;
    private int value;
    static Random rng = new Random();

    public Dice(int sides) {
        this.sides = sides;
    }

    public int getSides() {
        return sides;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void roll() {
        this.setValue(rng.nextInt(this.sides) + 1);
    }


}
