import java.util.ArrayList;

public class Jail implements Square {
    private int position;
    private String name;
    private Player player;

    public Jail(int position, String name) {
        this.position = position;
        this.name = name;
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
    public void firstPlay(Player player, ArrayList<Player> players, Square[] board) {
        player.setIfPlayerIsInJail(true);
        player.setStayInJail(0);
        player.setCurrentPosition(10);
        System.out.println("Do you want to pay 50$ to escape jail (yes/no)");
        String answer = Monopoly.respond();
        if (answer.equalsIgnoreCase("yes")) {
            player.setCurrentMoney(player.getCurrentMoney() - 50);
            System.out.println("You escaped the jail");
            player.setIfPlayerIsInJail(false);
        } else {
            System.out.println("You are gonna miss 3 moves");
        }
    }
}
