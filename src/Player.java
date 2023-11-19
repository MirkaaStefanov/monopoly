import java.util.ArrayList;

public class Player {
    private String name;
    private static int firstMoney = 1500;
    private int currentMoney;
    private static int firstPosition = 0;
    private int currentPosition;
    public Property[] properties;
    private int numOfProperties = 0;
    private boolean ifPlayerIsInJail = false;
    private int stayInJail;


    public Player(String name) {
        this.name = name;
        this.currentMoney = this.firstMoney;
        this.currentPosition = this.firstPosition;
    }

    public int getStayInJail() {
        return stayInJail;
    }

    public void setStayInJail(int stayInJail) {
        this.stayInJail = stayInJail;
    }

    public int getNumOfproperties() {
        return numOfProperties;
    }

    public void setNumOfproperties(int numOfproperties) {
        this.numOfProperties = numOfproperties;
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




    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", currentMoney=" + currentMoney +
                ", currentPosition=" + currentPosition +
                ", properties=" + numOfProperties+
                '}';
    }
}
