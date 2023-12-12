import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private static int firstMoney = 400;
    private int currentMoney;
    private static int firstPosition = 0;
    private int currentPosition;
    public ArrayList<Propertiable> properties;
    private int currentNumOfProperties ;
    private int numOfPropertiesAtStart = 0;
    private boolean ifPlayerIsInJail = false;
    private int stayInJail;
    private boolean doNotGet200FromStart= false;
    private boolean moveToTheNearest = false;
    private boolean lose=false;


    public Player(String name) {
        this.name = name;
        this.currentMoney = this.firstMoney;
        this.currentPosition = this.firstPosition;
        this.currentNumOfProperties =this.numOfPropertiesAtStart;
        this.properties = makePropertyArrayList();
    }
    public ArrayList<Propertiable> makePropertyArrayList () {
        ArrayList<Propertiable> propertiesOfPlayer = new ArrayList<>();
        return propertiesOfPlayer;
    }

    public boolean getLose() {
        return lose;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public boolean getMoveToTheNearest() {
        return moveToTheNearest;
    }

    public void setMoveToTheNearest(boolean moveToTheNearest) {
        this.moveToTheNearest = moveToTheNearest;
    }

    public int getStayInJail() {
        return stayInJail;
    }

    public void setStayInJail(int stayInJail) {
        this.stayInJail = stayInJail;
    }

    public int getNumOfproperties() {
        return currentNumOfProperties;
    }

    public void setNumOfproperties(int numOfproperties) {
        this.currentNumOfProperties = numOfproperties;
    }

    public boolean getIfPlayerIsInJail() {
        return ifPlayerIsInJail;
    }

    public void setIfPlayerIsInJail(boolean ifPlayerIsInJail) {
        this.ifPlayerIsInJail = ifPlayerIsInJail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean getDoNotGet200FromStart() {
        return doNotGet200FromStart;
    }

    public void setDoNotGet200FromStart(boolean doNotGet200FromStart) {
        this.doNotGet200FromStart = doNotGet200FromStart;
    }

    public void sell() {
        int propertyForSelling;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < properties.size() ; i++) {
            System.out.println((i+1)+") "+properties.get(i).getName()+" $"+properties.get(i).getPriceForBuying());
        }
        System.out.print("Enter which one you wanna sell: ");

        while (true) {
            try {
                propertyForSelling = Integer.parseInt(sc.next());
                if(propertyForSelling>0 && propertyForSelling<=properties.size()){
                    break;
                }else{
                    if(properties.size()==1){
                        System.out.print("You have only one property, so enter \"1\" :");
                    }else{
                        System.out.print("Please enter number between 1 and "+properties.size()+ ": ");
                    }
                }
            }catch (Exception e){
                System.out.print("Please enter integer: ");
            }
        }

        properties.get(propertyForSelling-1).setIfItsBought(false);
        currentNumOfProperties-=1;
        setCurrentMoney(getCurrentMoney()+properties.get(propertyForSelling-1).getPriceForBuying());
        System.out.println("You sold it and received $"+properties.get(propertyForSelling-1).getPriceForBuying());
        properties.remove(propertyForSelling-1);

    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", currentMoney=" + currentMoney +
                ", currentPosition=" + currentPosition +
                ", properties=" + currentNumOfProperties+
                '}';
    }
}
