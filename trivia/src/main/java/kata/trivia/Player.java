package kata.trivia;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 14-1-21
 * Time: 下午4:51
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private final String name;
    private int place;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void moveForward(int numberOfSteps) {
        this.place += numberOfSteps;
        if (this.place > 11) this.place -= 12;
    }

    public int getPlace() {
        return this.place;
    }
}
