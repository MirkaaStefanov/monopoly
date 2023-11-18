public class Board {
    public Square[] board;
    private Player[] players;

    public Board() {
        board = new Square[40];

        for (int i = 0; i <40 ; i++) {
            board[i] = makeSquare(i);
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

private Square makeSquare(int position) {
    switch (position) {
        case 0:
            return go(position);
        case 1:
        default:
            return null;
    }
}
private Square go(int position) {
        return new Start(position,"GO");
}
private Square slivnica(int position){
        int rent= 30;
        int cost = 60;
        return new Property("Slivnica",cost,rent,position);
}


}
