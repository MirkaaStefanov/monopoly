import java.util.Scanner;

public class Property implements Square {
    private String name;
    private int position;
    private Player owner;
    private int priceForBuying;
    private int priceForRent;
    private boolean ifItsBought = false;

    Scanner sc = new Scanner(System.in);

    public Property(String name, int priceForBuying, int priceForRent, int position) {
        this.name = name;
        this.priceForBuying = priceForBuying;
        this.priceForRent = priceForRent;
        this.position = position;

    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPriceForBuying() {
        return priceForBuying;
    }

    public void setPriceForBuying(int priceForBuying) {
        this.priceForBuying = priceForBuying;
    }

    public int getPriceForRent() {
        return priceForRent;
    }

    public void setPriceForRent(int priceForRent) {
        this.priceForRent = priceForRent;
    }

    public boolean isIfItsRent() {
        return ifItsBought;
    }

    public void setIfItsRent(boolean ifItsRent) {
        this.ifItsBought = ifItsRent;
    }


    @Override
    public int position() {
        return 0;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public boolean isItBoughtable() {
        return false;
    }

    @Override
    public boolean isItBought() {
        return false;
    }

    @Override
    public int cost() {
        return 0;
    }

    @Override
    public void buy(Player player) {
        player.setCurrentMoney(player.getCurrentMoney() - this.priceForBuying);
        this.ifItsBought=true;
        this.owner = player;
        System.out.println("You bought \""+this.name+ "\"");
    }

    @Override
    public void rent(Player player) {
        System.out.println("You pay rent to "+this.owner.getName()+", "+this.priceForRent+"$");
        player.setCurrentMoney(player.getCurrentMoney()-this.priceForRent);
        this.owner.setCurrentMoney(owner.getCurrentMoney()+this.priceForRent);
        System.out.println("You paid the rent! ");
    }

    public void firstPlay(Player player) {
        System.out.println("You are on position " + this.position);
        if (!ifItsBought) {
            System.out.println("Would you like to buy " + this.name + " (yes/no)");
            String respond = sc.next();
            if (respond.equalsIgnoreCase("Yes")) {
                buy(player);
            }
        }else{
            rent(player);
        }
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", owner=" + owner +
                ", priceForBuying=" + priceForBuying +
                ", priceForRent=" + priceForRent +
                ", ifItsBought=" + ifItsBought +
                '}';
    }
}
