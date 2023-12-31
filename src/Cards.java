import java.util.ArrayList;
import java.util.Random;

public class Cards implements Square {
    private int position;
    private String name;


    public Cards(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void firstPlay(Player player, ArrayList<Player> players, Square[] board) {

        Random cardsRandom = new Random();
        if (this.name.equalsIgnoreCase("Obshtestven trezor")) {
            int obshtestvenTrezorRandom = cardsRandom.nextInt(15) + 1;
            System.out.println("Your Obshtestven trezor card is:");
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
                    player.setCurrentMoney(player.getCurrentMoney() - 100);
                    break;
                case 6:
                    System.out.println("You receive a consultant fee 25$");
                    player.setCurrentMoney(player.getCurrentMoney() + 25);
                    break;
                case 7:
                    System.out.println("You have a birthday and receive 10$ from every player");
                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i) != player) {
                            player.setCurrentMoney(player.getCurrentMoney() +10);
                            players.get(i).setCurrentMoney(players.get(i).getCurrentMoney() - 10);
                        }
                    }
                    break;
                case 8:
                    System.out.println("You pay 30$ for every property");
                    player.setCurrentMoney(player.getCurrentMoney() - 30 * player.getNumOfproperties());
                    break;
                case 9:
                    System.out.println("Maturity of vacation fund, you receive 100$");
                    player.setCurrentMoney(player.getCurrentMoney() + 100);
                    break;
                case 10:
                    System.out.println("Continue to the start and receive 200$");
                    player.setCurrentPosition(0);
                    player.setCurrentMoney(player.getCurrentMoney() + 200);
                    break;
                case 11:
                    System.out.println("Bank error in your favor, you receive 200$");
                    player.setCurrentMoney(player.getCurrentMoney() + 200);
                    break;
                case 12:
                    System.out.println("You win second place in a beauty competition, you receive 10$");
                    player.setCurrentMoney(player.getCurrentMoney() + 10);
                    break;
                case 13:
                    System.out.println("Doctor fee, pay 50$");
                    player.setCurrentMoney(player.getCurrentMoney() - 50);
                    break;
                case 14:
                    System.out.println("You receive an inheritance of 100$");
                    player.setCurrentMoney(player.getCurrentMoney() + 100);
                    break;
                case 15:
                    System.out.println("You sale stocks and receive 50$");
                    player.setCurrentMoney(player.getCurrentMoney() + 50);
                    break;
            }
        } else if (this.name.equalsIgnoreCase("Luck")) {
            int luckRandom = cardsRandom.nextInt(13) + 1;
            System.out.println("Your luck card is:");
            switch (luckRandom) {
                case 1:
                    System.out.println("Go to Boqna -> 39");
                    player.setCurrentPosition(39);
                    board[39].firstPlay(player,players,board);
                    break;
                case 2:
                    System.out.println("Go to ploshtat Makedonia -> 11");
                    if (player.getCurrentPosition() >= 0 && player.getCurrentPosition() < 12) {
                        player.setCurrentPosition(11);
                        board[11].firstPlay(player,players,board);
                    } else if (player.getCurrentPosition() > 12) {
                        player.setCurrentPosition(11);
                        board[11].firstPlay(player,players,board);
                        player.setCurrentMoney(player.getCurrentMoney() + 200);
                        System.out.println("You continued by start");
                    } else {
                        System.out.println("You are at plushtat Makedonia");
                    }
                    break;
                case 3:
                    System.out.println("You have been chosen to be chairman. You must pay everyone 50$");

                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i) != player) {
                            player.setCurrentMoney(player.getCurrentMoney() - 50);
                            players.get(i).setCurrentMoney(players.get(i).getCurrentMoney() +50);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Go to gara Sofia -> 5");
                    if (player.getCurrentPosition() >= 0 && player.getCurrentPosition() < 6) {
                        player.setCurrentPosition(5);
                        board[5].firstPlay(player,players,board);
                    } else if (player.getCurrentPosition() > 6) {
                        player.setCurrentPosition(5);
                        board[5].firstPlay(player,players,board);
                        System.out.println("You continued by start");
                        player.setCurrentMoney(player.getCurrentMoney() + 200);
                    } else {
                        System.out.println("You are at gara Sofia");
                    }
                    break;
                case 5:
                    System.out.println("Maturity of your home loan, you receive 150$");
                    player.setCurrentMoney(player.getCurrentMoney() + 150);
                    break;
                case 6:
                    System.out.println("Go back 3 spaces");
                    player.setCurrentPosition(player.getCurrentPosition() - 3);
                    board[player.getCurrentPosition()].firstPlay(player,players,board);
                    break;
                case 7:
                    System.out.println("Speeding ticket. It costs: 15$");
                    player.setCurrentMoney(player.getCurrentMoney() - 15);
                    break;
                case 8:
                    System.out.println("You go straight to jail");
                    player.setIfPlayerIsInJail(true);
                    board[10].firstPlay(player,players, board);
                    break;
                case 9:
                    System.out.println("Go to start and earn 200$");
                    player.setCurrentMoney(player.getCurrentMoney() + 200);
                    player.setCurrentPosition(0);
                    break;
                case 10:
                    System.out.println("The bank sends you a dividend of 50$");
                    player.setCurrentMoney(player.getCurrentMoney() + 50);
                    break;
                case 11:
                    System.out.println("Go to Bulevard Bulgaria -> 19");
                    if (player.getCurrentPosition() >= 0 && player.getCurrentPosition() < 20) {
                        player.setCurrentPosition(19);
                        board[19].firstPlay(player,players,board);
                    } else if (player.getCurrentPosition() > 20) {
                        player.setCurrentPosition(19);
                        board[19].firstPlay(player,players,board);
                        System.out.println("You continued by start");
                        player.setCurrentMoney(player.getCurrentMoney() + 200);
                    } else {
                        System.out.println("You are at Bulevard Bulgaria");
                    }
                    break;
                case 12:
                    System.out.println("Go to the nearest Property, if it is bought you have to pay double rent");
                    for (int i = player.getCurrentPosition(); i <board.length ; i++) {
                        if(board[i]instanceof Property){
                            player.setCurrentPosition(i);
                            player.setMoveToTheNearest(true);
                            board[i].firstPlay(player,players,board);
                            break;
                        }
                    }
                    break;
                case 13:
                    System.out.println("Go to the nearest Gara, if it is bought you have to pay double rent");
                    for (int i = player.getCurrentPosition(); i <board.length ; i++) {
                        if(board[i]instanceof Gara){
                            player.setCurrentPosition(i);
                            player.setMoveToTheNearest(true);
                            board[i].firstPlay(player, players, board);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
