public class Board {
    public Square[] board;
    private Player[] players;

    public Board() {
        board = new Square[40];

        for (int i = 0; i < 40; i++) {
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
                return bulBotevgradskoShose(position);
            case 2:
                return luck(position);
            case 3:
                return bulCarigradskoShose(position);
            case 4:
                return taxProfit(position);
            case 5:
                return luck(position);
            case 6:
                return ulOpulchenska(position);
            case 7:
                return luck(position);
            case 8:
                return luvovMost(position);
            default:
                return null;
        }
    }


    private Square go(int position) {
        return new Start(position, "GO");
    }

    private Square bulBotevgradskoShose(int position) {
        int rent = 30;
        int cost = 60;
        return new Property("Bulevard Botevgradsko Shose", cost, rent, position);
    }

    private Square luck(int position) {
        return new Cards(position, "luck");
    }

    private Square bulCarigradskoShose(int position) {
        int rent = 30;
        int cost = 60;
        return new Property("Bulevard Carigradsko Shose", cost, rent, position);
    }

    private Square taxProfit(int position) {
        return new Taxes(position, "tax profit");
    }


    private Square ulOpulchenska(int position) {
        int cost = 100;
        int rent = 50;
        return new Property("Ulica Opulchenksa", cost, rent, position);
    }

    private Square bulSlivnica(int position) {
        int cost = 100;
        int rent = 50;
        return new Property("Bulevard Slivnica", cost, rent, position);
    }

    private Square luvovMost(int position) {
        int cost = 120;
        int rent = 50;
        return new Property("Luvov most", cost, rent, position);
    }

   /* private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }

    private Square ....(
    int position)

    {

    }*/


}
