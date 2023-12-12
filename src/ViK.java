import java.util.ArrayList;

public class ViK implements Square{
    private int position;
    private String name;

    public ViK(int position, String name) {
        this.position = position;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void firstPlay(Player player, ArrayList<Player> players, Square[] board) {
        player.setCurrentMoney(player.getCurrentMoney() - 150);
        System.out.println("You paid Tax ViK 150$");
    }
}
