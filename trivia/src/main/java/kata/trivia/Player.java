package kata.trivia;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 14-1-21
 * Time: 下午4:51
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private String name = "";
    private int place = 0;
    private boolean isGettingOutOfPenaltyBox = true;
    private boolean inPenaltyBox = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void moveForward(int numberOfSteps) {
        this.place += numberOfSteps;
        if (this.place > 11) {
            this.place -= 12;
        }
    }

    public int getPlace() {
        return this.place;
    }

    public void processPenaltyBoxAndMovingForward(int diceRollingNumber) {
        if (inPenaltyBox) {
            if (diceRollingNumber % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                MyLogger.log(this.name + " is getting out of the penalty box");

                currentPlayerMovedForward(diceRollingNumber);
            } else {
                MyLogger.log(this.name + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            currentPlayerMovedForward(diceRollingNumber);
        }
    }

    private void currentPlayerMovedForward(int roll) {
        moveForward(roll);
        MyLogger.log(this.name
                + "'s new location is "
                + this.place);
    }

    public boolean isInPenaltyBox() {
        return this.inPenaltyBox;
    }
}
