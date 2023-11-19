import java.util.Scanner;

public class Gara implements Square, Propertiable{
    private int position;
    private String name;
    private Player owner;
    private int priceForBuying;
    private int priceForRent;
    private boolean ifItsBought = false;
    public Gara(String name, int priceForBuying, int priceForRent, int position) {
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

    public boolean isIfItsBought() {
        return ifItsBought;
    }

    public void setIfItsBought(boolean ifItsBought) {
        this.ifItsBought = ifItsBought;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void firstPlay(Player player, Player[]players, Square[] board) {
        Scanner sc = new Scanner(System.in);
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
    public void buy(Player player) {
        player.setCurrentMoney(player.getCurrentMoney() - this.priceForBuying);
        this.ifItsBought = true;
        this.owner = player;
        player.makePropertyArrayList().add(new Gara(this.name,this.priceForBuying,this.priceForRent,this.position));
        player.setNumOfproperties(player.getNumOfproperties()+1);
        System.out.println("You bought \"" + this.name + "\"");
    }

    @Override
    public void rent(Player player) {
        if (!(player == this.owner)) {

            if (this.owner.getIfPlayerIsInJail()==false) {
                System.out.println("You pay rent to " + this.owner.getName() + ", " + this.priceForRent + "$");
                if(player.getMoveToTheNearest()==true){
                    player.setCurrentMoney(player.getCurrentMoney() - (this.priceForRent)*2);
                    this.owner.setCurrentMoney(owner.getCurrentMoney() + (this.priceForRent)*2);
                    player.setMoveToTheNearest(false);
                }else {
                    player.setCurrentMoney(player.getCurrentMoney() - this.priceForRent);
                    this.owner.setCurrentMoney(owner.getCurrentMoney() + this.priceForRent);
                }
                System.out.println("You paid the rent! ");
            }else{
                System.out.println("You are lucky! The owner is in jail and you shouldn't pay rent");
            }
        }
    }
}
