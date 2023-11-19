import java.util.Random;

public class Cards implements Square {
    private int position;
    private String name;
    private Player[] player;

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

    public Player[] getPlayer() {
        return player;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }


    @Override
    public void firstPlay(Player player) {
        Player[] pl =Main.players();
        Random cardsRandom = new Random();
        if (this.name.equalsIgnoreCase("Obshtestven trezor")) {
            int obshtestvenTrezorRandom = cardsRandom.nextInt(16) + 1;
            switch (obshtestvenTrezorRandom) {
                case 1:
                    System.out.println("life insurance maturity. you receive 100$");
                    player.setCurrentMoney(player.getCurrentMoney() + 100);
                    break;
                case 2:
                    System.out.println("Pay school fees 50$");
                    player.setCurrentMoney(player.getCurrentMoney() - 50);
                    break;
                case 3:
                    System.out.println("Overpaid taxes are refunded to you. You get 20$");
                    player.setCurrentMoney(player.getCurrentMoney() + 20);
                    break;
                case 4:
                    System.out.println("You go straight to jail and when you go through the start you don't get 200$");
                    player.setDoNotGet200FromStart(true);
                    break;
                case 5:
                    System.out.println("Pay 100$ hospital fees");
                    player.setCurrentMoney(player.getCurrentMoney()-100);
                    break;
                case 6:
                    System.out.println("You receive a consultant fee 25$");
                    player.setCurrentMoney(player.getCurrentMoney()+25);
                    break;
                case 7:
                    System.out.println("You have a birthday and receive 10$ from every player");
                    for (int i = 0; i < pl.length; i++) {
                        int recievenMoney = 10*(pl.length-1);
                        if(pl[i]!=player){
                            player.setCurrentMoney(player.getCurrentMoney()+recievenMoney);
                            pl[i].setCurrentMoney(pl[i].getCurrentMoney()-10);
                        }
                    }
                    break;
                case 8:
                    System.out.println("You escaped jail without paying.");
                    player.setIfPlayerIsInJail(false);
                    break;
                case 9:
                    System.out.println("You pay 30$ for every property");
                    player.setCurrentMoney(player.getCurrentMoney()-30*player.getNumOfproperties());
                    break;
                case 10:
                    System.out.println("Maturity of vacation fund, you receive 100$");
                    player.setCurrentMoney(player.getCurrentMoney()+100);
                    break;
                case 11:
                    System.out.println("Continue to the start and receive 200$");
                    player.setCurrentPosition(0);
                    player.setCurrentMoney(player.getCurrentMoney()+200);
                    break;
                case 12:
                    System.out.println("Bank error in your favor, you receive 200$");
                    player.setCurrentMoney(player.getCurrentMoney()+200);
                    break;
                case 13:
                    System.out.println("You win second place in a beauty competition, you receive 10$");
                    player.setCurrentMoney(player.getCurrentMoney()+10);
                    break;
                case 14:
                    System.out.println("Doctor fee, pay 50$");
                    break;
                case 15:
                    System.out.println("You receive an inheritance of 100$");
                    player.setCurrentMoney(player.getCurrentMoney()+100);
                    break;
                case 16:
                    System.out.println("You sale stocks and receive 50$");
                    player.setCurrentMoney(player.getCurrentMoney()+50);
                    break;
            }
        } else if (this.name.equalsIgnoreCase("Luck")) {
            int luckRandom = cardsRandom.nextInt(16) + 1;
            switch (luckRandom) {
                case 1:
                    System.out.println("Go to Boqna");
                    player.setCurrentPosition(39);
                    break;
                case 2:
                    System.out.println("You escaped jail without paying.");
                    player.setIfPlayerIsInJail(false);
                    break;
                case 3:
                    System.out.println("Go to ploshtat Makedoia");
                    if (player.getCurrentPosition() >= 0 && player.getCurrentPosition() < 12) {
                        player.setCurrentPosition(11);
                    } else if (player.getCurrentPosition() <= 0 && player.getCurrentPosition() > 12) {
                        player.setCurrentPosition(11);
                        player.setCurrentMoney(player.getCurrentMoney() + 200);
                    } else {
                        System.out.println("You are at plushtat Makedonia");
                    }
                    break;
                case 4:
//                    Player[] players=Main.players();
//                    System.out.println("You are chosen to be chairman. You must py every one 50$");
//                    for (int i = 0; i < players.length; i++) {
//
//                    }
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
        } else {

        }
    }
}
