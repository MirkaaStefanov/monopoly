import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void play() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Player> players = players();
        Square[] board = createBoard();
        int counter = 0;
        while (true) {
            if (counter != 0) {
                sc.nextLine();
            }
            counter++;
            printState(players);
            for (int i = 0; i < players.size(); i++) {
                if (counter > 0) {
                    System.out.println();
                }
                if (players.get(i).getLose() == true) {
                    continue;
                }
                if (jailInMain(players.get(i)) == false) {
                    continue;
                }

                System.out.print(players.get(i).getName() + ", press enter to roll the dice");
                if (i == players.size()) {
                    sc.nextLine();
                }
                sc.nextLine();
                int dice1 = random.nextInt(6) + 1;
                int dice2 = random.nextInt(6) + 1;
                System.out.println("You rolled " + dice1 + " and " + dice2);
                int sumOfDice = dice1 + dice2;
                int boardPosition = players.get(i).getCurrentPosition() + sumOfDice;
                if (boardPosition >= 40) {
                    boardPosition = boardPosition - 40;
                    startInMain(players.get(i));
                }
                players.get(i).setCurrentPosition(boardPosition);
                System.out.println("Your position is " + players.get(i).getCurrentPosition() + ", you are in square: " + board[boardPosition].getName());

                board[boardPosition].firstPlay(players.get(i), players, board);

                sellOrSetLoseInMain(players, players.get(i));
                if (players.size() == 1) {
                    break;
                }
            }
            if (players.size() == 1) {
                System.out.println("Player ("+players.get(0).getName()+") WINS!");
                break;
            }
        }
    }

    public static ArrayList<Player> players() {
        Scanner sc = new Scanner(System.in);
        int numOfPlayers;
        System.out.print("How many players will play (2-4): ");
        while (true) {
            try {
                numOfPlayers = Integer.parseInt(sc.nextLine());
                if (numOfPlayers >= 2 && numOfPlayers <= 4) {
                    break;
                } else {
                    System.out.print("Please enter number between 2 and 4:");
                }
            } catch (Exception e) {
                System.out.print("Please enter integer: ");
            }
        }
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("Enter name of player " + (i + 1) + ": ");

            String name = sc.nextLine();
            players.add(i, new Player(name));
        }
        return players;
    }


    public static Square[] createBoard() {
        Square[] board = new Square[40];
        board[0] = new Start(0, "GO");
        board[1] = new Property("Bulevard Botevgradsko Shose", 60, 30, 1);
        board[2] = new Cards(2, "Obshtestven trezor");
        board[3] = new Property("Bulevard Carigradsko Shose", 60, 30, 3);
        board[4] = new Taxes(4, "Danuk pechalba");
        board[5] = new Gara("Gara Sofia", 100, 40, 5);
        board[6] = new Property("Ulica Opulchenska", 100, 50, 6);
        board[7] = new Cards(7, "Luck");
        board[8] = new Property("Bulevard Slivnica", 100, 50, 8);
        board[9] = new Property("Lunov most", 120, 60, 9);
        board[10] = new Jail(10, "Na Svijdane");
        board[11] = new Property("Ploshtad Makedoniq", 140, 70, 11);
        board[12] = new NEK(12, "NEK");
        board[13] = new Property("Ulica Pirotska", 140, 70, 13);
        board[14] = new Property("Bulevard Hristo Botev", 160, 80, 14);
        board[15] = new Gara("Gara Plovdiv", 100, 40, 15);
        board[16] = new Property("Bulevard Evlogi Georgiev", 180, 90, 16);
        board[17] = new Cards(17, "Obshtestven trezor");
        board[18] = new Property("Orlov most", 180, 90, 18);
        board[19] = new Property("Bulevard Bulgaria", 200, 100, 19);
        board[20] = new Parking(20, "Free parking");
        board[21] = new Property("Ulica San Stefano", 220, 110, 21);
        board[22] = new Cards(22, "Luck");
        board[23] = new Property("Ulica Shipka", 220, 110, 23);
        board[24] = new Property("Ulica Oborishte", 240, 120, 24);
        board[25] = new Gara("Gara Varna", 100, 40, 25);
        board[26] = new Property("Bulevard Dondukov", 260, 130, 26);
        board[27] = new Property("Bulevard Patriarh Evtimiy", 260, 130, 27);
        board[28] = new ViK(28, "VIK");
        board[29] = new Property("Bulevard Vasil Levski", 280, 140, 29);
        board[30] = new Jail(30, "Go to jail!");
        board[31] = new Property("Ulica G.S.Rakovski", 300, 150, 31);
        board[32] = new Property("Ulica Graf Ignatiev", 300, 150, 32);
        board[33] = new Cards(33, "Obshtestven trezor");
        board[34] = new Property("Bulevard Car Osvoboditel", 320, 160, 34);
        board[35] = new Gara("Gara Burgas", 100, 40, 35);
        board[36] = new Cards(36, "Luck");
        board[37] = new Property("Bulevard Vitosha", 350, 175, 37);
        board[38] = new Taxes(38, "Super danuk");
        board[39] = new Property("Boqna", 400, 200, 39);
        return board;
    }

    public static boolean jailInMain(Player player) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        if (player.getIfPlayerIsInJail()) {
            System.out.println("You (" + player.getName() + ") are in Jail");
            System.out.println("But, If you role two same dice you are gonna escape the jail");
            System.out.print("press enter to roll the dice");

            sc.nextLine();
            int diceInJail1 = random.nextInt(6) + 1;
            int diceInJail2 = random.nextInt(6) + 1;
            System.out.println("You rolled " + diceInJail1 + " and " + diceInJail2);
            if (diceInJail1 == diceInJail2) {
                System.out.println("You escaped the jail");
                player.setIfPlayerIsInJail(false);
                return true;
            } else {
                player.setStayInJail(player.getStayInJail() + 1);
                if (player.getStayInJail() == 3) {
                    System.out.println("You escaped the jail, next time you will be able to roll the dice");
                    player.setIfPlayerIsInJail(false);
                    return false;

                }
                System.out.println("After " + (3 - player.getStayInJail()) + " moves, you will be able to roll the dice");
                return false;

            }
        }
        return true;
    }

    public static void startInMain(Player player) {
        if (player.getDoNotGet200FromStart() == false) {
            player.setCurrentMoney(player.getCurrentMoney() + 200);
            System.out.println("You (" + player.getName() + ") receive 200$ because you went through the START");
        } else {
            System.out.println("You went through the START, but you can't get 200$ because you have a prohibition");
        }
    }

    public static void sellOrSetLoseInMain(ArrayList<Player> players, Player player) {
        Scanner sc = new Scanner(System.in);
        if (player.properties.size() > 0) {
            if (player.getCurrentMoney() < 0) {
                System.out.print("You must sell your property otherwise you gonna lose(yes/no)");
            } else {
                System.out.println("Do you want to sell your property(yes/no)");
            }
            String answer = sc.next();
            if (answer.equalsIgnoreCase("yes")) {
                player.sell();
            }
        }
        if (player.getCurrentMoney() < 0) {
            System.out.println("Player (" + player.getName() + ") LOST!");
            for (int i = 0; i < player.properties.size(); i++) {
                player.properties.get(i).setIfItsBought(false);
            }
            player.properties.clear();
            players.remove(player);
        }
    }


    private static void printState(ArrayList<Player> players) {
        int counter = 1;
        for (Player player : players) {
            System.out.println("--------------------------------------------------");
            System.out.println("Player " + counter++);
            System.out.printf("%-10s%40s%n", "Name", player.getName());
            System.out.printf("%-10s%40s%n", "Money", player.getCurrentMoney());
            System.out.printf("%-10s%40s%n", "Position", player.getCurrentPosition());
            System.out.printf("%-10s", "Properties");
            int owned = player.getNumOfproperties();

            boolean first = true;
            if (first)
                System.out.printf("%40s%n", owned);
            else
                System.out.printf("%50s%n", owned);
            first = false;


            if (first)
                System.out.printf("%40s%n", "none");

            if (player.getIfPlayerIsInJail())
                System.out.printf("%30s%n", "In jail");

            System.out.println("--------------------------------------------------");
        }
    }

    public static void main(String[] args) {

        play();

    }
}