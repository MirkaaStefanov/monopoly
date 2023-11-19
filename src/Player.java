import java.util.ArrayList;

public class Player {
    private String name;
    private static int firstMoney = 1500;
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
    private boolean paidToEscapeJail = false;


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

    public boolean getPaidToEscapeJail() {
        return paidToEscapeJail;
    }

    public void setPaidToEscapeJail(boolean paidToEscapeJail) {
        this.paidToEscapeJail = paidToEscapeJail;
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

    public int getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(int firstMoney) {
        this.firstMoney = firstMoney;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getFirstPosition() {
        return firstPosition;
    }

    public void setFirstPosition(int firstPosition) {
        this.firstPosition = firstPosition;
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
