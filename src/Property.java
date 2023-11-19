import java.util.Scanner;

public class Property implements Square, Propertiable {
    private String name;
    private int position;
    private Player owner;
    private int priceForBuying;
    private int priceForRent;
    private boolean ifItsBought = false;
    private int ownerEntered = 0;
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
    public String getName() {
        return name;
    }

    @Override
    public void buy(Player player) {
        player.setCurrentMoney(player.getCurrentMoney() - this.priceForBuying);
        this.ifItsBought = true;
        this.owner = player;
        player.properties[player.getNumOfproperties()]=new Property(this.name, this.priceForBuying, this.priceForRent, this.position);
        player.setNumOfproperties(player.getNumOfproperties()+1);
        System.out.println("You bought \"" + this.name + "\"");
    }

    @Override
    public void rent(Player player) {

        if (!(player == this.owner)) {

            if (!this.owner.getIfPlayerIsInJail()) {
                System.out.println("You pay rent to " + this.owner.getName() + ", " + this.priceForRent + "$");
                player.setCurrentMoney(player.getCurrentMoney() - this.priceForRent);
                this.owner.setCurrentMoney(owner.getCurrentMoney() + this.priceForRent);
                System.out.println("You paid the rent! ");
            }else{
                System.out.println("You are lucky! The owner is in jail and you shouldn't pay rent");
            }
        }
    }


    public void firstPlay(Player player) {
        if (!ifItsBought) {
            System.out.println("Would you like to buy " + this.name + " (yes/no)");
            String respond = sc.next();
            if (respond.equalsIgnoreCase("Yes")) {
                buy(player);
            }
        } else if(ifItsBought && player==owner && ownerEntered==0){
           ownerEntered=1;
            System.out.println("This is yours");
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
