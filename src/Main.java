import java.util.Random;

public class Main {
public static Square[] createBoard () {
    Square[] board = new Square[40];
    board[0]= new Start(0, "GO");
    board[1]= new Property("Bulevard Botevgradsko Shose", 60, 30,1);

    return board;
}
    public static void main(String[] args) {
    Square[] board = createBoard();

Player player = new Player("Mirkaan");
        System.out.println(player);
        Random random = new Random();
        int zar1 = random.nextInt(6)+1;
        int zar2 = random.nextInt(6)+1;

        int sum = zar1+zar2;
        sum=1;
        int boardPosition = player.getCurrentPosition()+sum;

        Player voidPlayer = player;
        board[boardPosition].firstPlay(voidPlayer);

        System.out.println(player);
    }
}