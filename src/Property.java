import java.util.ArrayList;
import java.util.Scanner;

public class Property implements Square, Propertiable {
    private String name;
    private int position;
    private Player owner;
    private int priceForBuying;
    private int priceForRent;
    private boolean ifItsBought = false;

    private boolean maxed = false;
    Scanner sc = new Scanner(System.in);

    public Property(String name, int priceForBuying, int priceForRent, int position) {
        this.name = name;
        this.priceForBuying = priceForBuying;
        this.priceForRent = priceForRent;
        this.position = position;

    }

    public boolean getMaxed() {
        return maxed;
    }

    public void setMaxed(boolean maxed) {
        this.maxed = maxed;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPriceForBuying() {
        return priceForBuying;
    }

    public void setPriceForBuying(int priceForBuying) {
        this.priceForBuying = priceForBuying;
    }

    public void setPriceForRent(int priceForRent) {
        this.priceForRent = priceForRent;
    }

    @Override
    public void setIfItsBought(boolean ifItsBought) {
        this.ifItsBought = ifItsBought;
    }

    @Override
    public String getName() {
        return name;
    }
     @Override
    public void buy(Player player, Square[] board) {
        player.setCurrentMoney(player.getCurrentMoney() - this.priceForBuying);
        this.ifItsBought = true;
        this.owner = player;
         player.properties.add((Property)board[this.position]);
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


    @Override
    public void firstPlay(Player player, ArrayList<Player> players, Square[] board) {

        if(player==this.owner && getMaxed()==true){
            System.out.println("This is yours and it's maxed");
        }
        if (!ifItsBought) {
            System.out.println("Would you like to buy " + this.name +" price "+this.priceForBuying+ "$ (yes/no)");
           String respond = Monopoly.respond();
            if (respond.equalsIgnoreCase("Yes")) {
                buy(player, board);
            }
        } else if(ifItsBought && player==owner && getMaxed()==false){
            System.out.println("This is yours, would you like to pay "+(this.priceForBuying-20)+", and the rent will be "+this.priceForBuying+"$ (yes/no)");
            String answer = Monopoly.respond();
            if(answer.equalsIgnoreCase("Yes")){
                setMaxed(true);
                setPriceForRent(getPriceForBuying());
                player.setCurrentMoney(player.getCurrentMoney()-(this.priceForBuying-20));
                setPriceForBuying(getPriceForBuying() + (this.priceForBuying-20) );
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
