public class Parking implements Square{
    private int position;
    private String name;
    private Player player;


    public Parking(int position, String name) {
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
        System.out.println("You are in parking. You don't have to do anything");
    }
}
