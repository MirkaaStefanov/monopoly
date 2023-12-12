import java.util.ArrayList;
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

    @Override
    public int getPriceForBuying() {
        return priceForBuying;
    }

    @Override
    public void setIfItsBought(boolean ifItsBought) {
        this.ifItsBought = ifItsBought;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void firstPlay(Player player, ArrayList<Player> players, Square[] board) {

        if(player==this.owner){
            System.out.println("This is yours");
        }
        if (!ifItsBought) {
            System.out.println("Would you like to buy " + this.name +", "+this.priceForBuying +"$(yes/no)");
            String respond = Monopoly.respond();
            if (respond.equalsIgnoreCase("Yes")) {
                buy(player,board);
            }
        }else{
            rent(player);
        }
    }

    @Override
    public void buy(Player player,  Square[] board) {
        player.setCurrentMoney(player.getCurrentMoney() - this.priceForBuying);
        this.ifItsBought = true;
        this.owner = player;

        player.properties.add((Gara)board[this.position]);
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
