public class Taxes implements Square{
    private int position;
    private String name;

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
    public void rent(int value) {

    }

    @Override
    public void firstPlay(Player player) {

    }
}
