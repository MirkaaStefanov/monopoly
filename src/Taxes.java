public class Taxes implements Square{
    private int position;
    private String name;
    private Player player;

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

    public Taxes(int position, String name) {
        this.position = position;
        this.name = name;
    }

    @Override
    public int position() {
        return 0;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public boolean isItBoughtable() {
        return false;
    }

    @Override
    public boolean isItBought() {
        return false;
    }

    @Override
    public int cost() {
        return 0;
    }

    @Override
    public void buy(Player player) {

    }

    @Override
    public void rent(Player player) {

    }

    @Override
    public void firstPlay(Player player) {

    }
}
