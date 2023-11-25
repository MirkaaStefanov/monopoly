public interface Propertiable {
    void buy(Player player,  Square[] board);
    void rent(Player player);
    void setIfItsBought(boolean ifItsBought);
    String getName();
    int getPriceForBuying();
}
