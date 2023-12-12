import java.util.ArrayList;

public class Parking implements Square{
    private int position;
    private String name;
    private Player player;


    public Parking(int position, String name) {
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
        System.out.println("You are in parking. You don't have to do anything");
    }
}
