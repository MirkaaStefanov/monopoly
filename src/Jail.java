import java.util.Random;
import java.util.Scanner;

public class Jail implements Square {
    private int position;
    private String name;
    private Player player;

    public Jail(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void firstPlay(Player player, Player[]players, Square[] board) {
        Scanner sc = new Scanner(System.in);
        player.setIfPlayerIsInJail(true);
        player.setStayInJail(0);
        player.setCurrentPosition(10);
        System.out.println("Do you want to pay 50$ to escape jail (yes/no)");
        String answer = sc.next();
        if (answer.equalsIgnoreCase("yes")) {
            player.setPaidToEscapeJail(true);
            player.setCurrentMoney(player.getCurrentMoney() - 50);
            System.out.println("You paid 50$, but you still miss a move");
            player.setIfPlayerIsInJail(false);
        } else {
            System.out.println("You are gonna miss 3 moves");
        }
    }
}
