import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Player[] players() {
        Scanner sc = new Scanner(System.in);
        int numOfPlayers;
        System.out.print("How many players will play (2-4): ");
        while (true) {
            try {
                numOfPlayers =Integer.parseInt(sc.nextLine());
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
            System.out.print("Enter name of player "+(i+1)+": ");
            if(i>0) {
                sc.nextLine();
            }
            String name = sc.nextLine();
            players[i]= new Player(name);
        }
        return players;
    }

    public static Square[] createBoard() {
        Square[] board = new Square[40];
        board[0] = new Start(0, "GO");
        board[1] = new Property("Bulevard Botevgradsko Shose", 60, 30, 1);

        return board;
    }

    public static void main(String[] args) {
        /*Player player = new Player("Mirkaan");
        System.out.println(player);
        Random random = new Random();
        int zar1 = random.nextInt(6) + 1;
        int zar2 = random.nextInt(6) + 1;

        int sum = zar1 + zar2;
        sum = 1;
        int boardPosition = player.getCurrentPosition() + sum;

        Player voidPlayer = player;
        board[boardPosition].firstPlay(voidPlayer);

        System.out.println(player);
        System.out.println(board[1]);*/

        Square[] board = createBoard();
        players();


    }
}