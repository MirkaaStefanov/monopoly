import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void play() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        Player[] players = players();
        Square[] board = createBoard();

        while (true) {

            for (int i = 0; i < players.length; i++) {
                if (players[i].getIfPlayerIsInJail()) {
                    System.out.println("You (" + players[i].getName() + ") are in Jail");
                    System.out.println("If you role two same dice you are gonna escape the jail");
                    System.out.print("press enter to roll the dice");
                    sc.nextLine();
                    int diceInJail1 = random.nextInt(6) + 1;
                    int diceInJail2 = random.nextInt(6) + 1;
                    System.out.println("You rolled " + diceInJail1 + " and " + diceInJail2);
                    if (diceInJail1 == diceInJail2) {
                        System.out.println("You escaped the jail");
                    } else {
                        players[i].setStayInJail(players[i].getStayInJail() + 1);
                        if (players[i].getStayInJail() == 3) {
                            System.out.println("You escaped the jail, next time you will be able to roll the dice");
                            continue;
                        }
                        System.out.println("After " + (3 - players[i].getStayInJail()) + " moves, you will be able to roll the dice");
                        continue;
                    }
                }
                System.out.print(players[i].getName() + ", press enter to roll the dice");
                sc.nextLine();
                int dice1 = random.nextInt(6) + 1;
                int dice2 = random.nextInt(6) + 1;

                int sumOfDice = dice1 + dice2;
                int boardPosition = players[i].getCurrentPosition() + sumOfDice;
                players[i].setCurrentPosition(boardPosition);
                System.out.println("You rolled " + dice1 + " and " + dice2);
                System.out.println("Your position is " + players[i].getCurrentPosition());

                if (boardPosition > 40) {
                    boardPosition = boardPosition - 40;
                    players[i].setCurrentMoney(players[i].getCurrentMoney() + 200);
                }

//1= boardPosition
                board[1].firstPlay(players[i]);

            }
        }
    }

    public static Player[] players() {
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
        Player[] players = new Player[numOfPlayers];
        for (int i = 0; i < players.length; i++) {
            System.out.print("Enter name of player " + (i + 1) + ": ");

            String name = sc.nextLine();

            players[i] = new Player(name);
        }
        return players;
    }

    public static Square[] createBoard() {
        Square[] board = new Square[40];
        board[0] = new Start(0, "GO");
        board[1] = new Property("Bulevard Botevgradsko Shose", 60, 30, 1);
        board[2] = new Cards(2, "Obshtestven trezor");
        board[3] = new Property("Bulevard Carigradsko Shose", 60, 30, 3);
        board[4] = new Cards(4, "Danuk pechalba");
        board[5] = new Cards(5, "Gara Sofia");
        board[6] = new Property("Ulica Opulchenska", 100, 50, 6);
        board[7] = new Cards(7, "Luck");
        board[8] = new Property("Bulevard Slivnica", 100, 50, 8);
        board[9] = new Property("Lunov most", 120, 60, 9);
        board[10] = new Jail(10, "Na Svijdane");
        board[11] = new Property("Ploshtad Makedoniq", 140, 70, 11);
        board[12] = new Cards(12, "NEK");
        board[13] = new Property("Ulica Pirotska", 140, 70, 13);
        board[14] = new Property("Bulevard Hristo Botev", 160, 80, 14);
        board[15] = new Cards(15, "Gara Plovdiv");
        board[16] = new Property("Bulevard Evlogi Georgiev", 180, 90, 16);
        board[17] = new Cards(17, "Obshtestven trezor");
        board[18] = new Property("Orlov most", 180, 90, 18);
        return board;
    }

    public static void main(String[] args) {

        play();

    }
}