public class ViK implements Square{
    private int position;
    private String name;

    public ViK(int position, String name) {
        this.position = position;
        this.name = name;
    }

    @Override
    public void firstPlay(Player player) {
        player.setCurrentMoney(player.getCurrentMoney() - 150);
        System.out.println("You paid Tax ViK 150$");
    }
}
