import java.io.Console;
import java.util.ArrayList;


public class App {

    static Console c = System.console();

    private static ArrayList<Player> initialize() {
        ArrayList<Player> playerList = new ArrayList<Player>();
        int noPlayers = Integer.parseInt(c.readLine("How many players? \n"));
        for (int i = 1; i <= noPlayers; i++) {
            String name = c.readLine("Enter player name: \n");
            ArrayList<Dice> dice = new ArrayList<Dice>();
            int noDice = Integer.parseInt(c.readLine("How many dice? \n"));
            for (int j = 1; j <= noDice; j++) {
                int sides = Integer.parseInt(c.readLine("How many sides for die %d: \n", j));
                Dice die = new Dice(sides);
                dice.add(die);
            }
            Player player = new Player(name, dice);
            playerList.add(player);
        }
        return playerList;
    }

    private static void takeTurn(ArrayList<Player> players) {
        for (Player player : players) {
            int totalValue = 0;
            player.rollDice();
            for (Dice die : player.dice) {
                totalValue = totalValue += die.getValue();
            }
            int guess = Integer.parseInt(c.readLine("%s, what is your guess? \n", player.name));
            System.out.printf("The actual value was %d!\n", totalValue);
            if (guess == totalValue) {
                player.increaseScore();
            }
        }
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        int maxScore = 1;
        ArrayList<Player> returnList = new ArrayList<>();
        for (Player player : players) {
            if (player.points > maxScore) {
                returnList.clear();
                returnList.add(player);
                maxScore = player.points;
            }
            else if (player.points == maxScore) {
                returnList.add(player);
            }
        }
        return returnList;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Player> players = initialize();
        int turns = 5;
        while (turns > 0) {
            takeTurn(players);
            turns -= 1;
        }
        ArrayList<Player> winner = getWinners(players);
        if (winner.size() > 1) {
            int noPlayers = winner.size();
            System.out.printf("It's a draw! %d players each got %d points:", noPlayers, winner.get(0).points);
            for (Player player : winner) {
                System.out.println(player.name);
            }
        }
        else if (winner.size() == 1) {
            System.out.printf("The winner is %s with %d points!", winner.get(0).name, winner.get(0).points);
        }
        else {
            System.out.println("Nobody guessed right!");
        }
    }
}
