public class Taxes implements Square {
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
    public void firstPlay(Player player) {
        if (this.name.equalsIgnoreCase("taxProfit")) {
            player.setCurrentMoney(player.getCurrentMoney() - 200);
            System.out.println("You paid Tax Profit 200$");
        }else{
            player.setCurrentMoney(player.getCurrentMoney() - 100);
            System.out.println("You paid super Tax 100$");
        }
    }
}
