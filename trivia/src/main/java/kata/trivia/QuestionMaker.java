package kata.trivia;

import java.util.LinkedList;
import java.util.List;

public class QuestionMaker {
    public static final String POP = "Pop";
    public static final String SCIENCE = "Science";
    public static final String SPORTS = "Sports";
    public static final String ROCK = "Rock";
    private List popQuestions = new LinkedList();
    private List scienceQuestions = new LinkedList();
    private List sportsQuestions = new LinkedList();
    private List rockQuestions = new LinkedList();

    public QuestionMaker() {
        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add(("Science Question " + i));
            sportsQuestions.add(("Sports Question " + i));
            rockQuestions.add("Rock Question " + i);
        }
    }
    public List getPopQuestions() {
        return popQuestions;
    }

    public List getScienceQuestions() {
        return scienceQuestions;
    }

    public List getSportsQuestions() {
        return sportsQuestions;
    }

    public List getRockQuestions() {
        return rockQuestions;
    }

    void askQuestion(Player currentPlayer) {
        if (POP.equals(currentCategory(currentPlayer))) {
            MyLogger.log((String)getPopQuestions().get(0));
            getPopQuestions().remove(0);
        }
        if (SCIENCE.equals(currentCategory(currentPlayer))) {
            MyLogger.log((String)getScienceQuestions().get(0));
            getScienceQuestions().remove(0);
        }
        if (SPORTS.equals(currentCategory(currentPlayer))) {
            MyLogger.log((String)getSportsQuestions().get(0));
            getSportsQuestions().remove(0);
        }
        if (ROCK.equals(currentCategory(currentPlayer))) {
            MyLogger.log((String)getRockQuestions().get(0));
            getRockQuestions().remove(0);
        }
    }

    String currentCategory(Player currentPlayer) {
        if (currentPlayer.getPlace() == 0) { return POP;}
        if (currentPlayer.getPlace() == 4) {return POP;}
        if (currentPlayer.getPlace() == 8) {return POP;}
        if (currentPlayer.getPlace() == 1) {return SCIENCE;}
        if (currentPlayer.getPlace() == 5) {return SCIENCE;}
        if (currentPlayer.getPlace() == 9) {return SCIENCE;}
        if (currentPlayer.getPlace() == 2) {return SPORTS;}
        if (currentPlayer.getPlace() == 6) {return SPORTS;}
        if (currentPlayer.getPlace() == 10) {return SPORTS;}
        return ROCK;
    }
}