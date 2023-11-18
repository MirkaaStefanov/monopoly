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
                if(!players[i].getIfPlayerIsInJail()){
                    System.out.println("You ("+players[i].getName()+") are in Jail");
                    continue;
                }
                System.out.print(players[i].getName()+", press enter to roll the dice");
                sc.nextLine();
                int dice1 = random.nextInt(6) + 1;
                int dice2 = random.nextInt(6) + 1;

                int sumOfDice = dice1 + dice2;
                int boardPosition = players[i].getCurrentPosition() + sumOfDice;
                players[i].setCurrentPosition(boardPosition);
                System.out.println("You rolled "+dice1+" and "+dice2);

                if(boardPosition>40){
                    boardPosition=boardPosition-40;
                    players[i].setCurrentMoney(players[i].getCurrentMoney()+200);
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

       play();

    }
}