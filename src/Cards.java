import java.util.Random;

public class Cards implements Square {
    private int position;
    private String name;
    private Player player;

    public Cards(int position, String name) {
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
        Random cardsRandom = new Random();
        if(this.name.equalsIgnoreCase("Obshtestven trezor")){
            int obshtestvenTrezorRandom = cardsRandom.nextInt(16)+1;
            switch (obshtestvenTrezorRandom){
                case 1:
                    System.out.println("life insurance maturity. you receive 100$");
                    player.setCurrentMoney(player.getCurrentMoney()+100);
                    break;
                case 2:
                    System.out.println("Pay school fees 50$");
                    player.setCurrentMoney(player.getCurrentMoney()-50);
                    break;
                case 3:
                    System.out.println("Overpaid taxes are refunded to you. You get 20$");
                    player.setCurrentMoney(player.getCurrentMoney()+20);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
            }
        }else if(this.name.equalsIgnoreCase("Luck")){
            int luckRandom = cardsRandom.nextInt(16)+1;
            switch (luckRandom){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
            }
        }else {

        }
    }
}
