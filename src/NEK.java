public class NEK implements Square{
    private int position;
    private String name;
    private Player player;

    public NEK(int position, String name) {
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
    public void firstPlay(Player player) {
        player.setCurrentMoney(player.getCurrentMoney() - 150);
        System.out.println("You paid Tax NEK 150$");
    }
}
