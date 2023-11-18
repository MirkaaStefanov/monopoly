public interface Square {
    int position();
    String name();
    boolean isItBoughtable();
    boolean isItBought();
    int cost();
    void buy(Player player);
    void rent(int value);

    void firstPlay(Player player);

}
