package kata.trivia;

import java.util.LinkedList;
import java.util.List;

public class QuestionMaker {
    public static final String POP = "Pop";
    public static final String SCIENCE = "Science";
    public static final String SPORTS = "Sports";
    public static final String ROCK = "Rock";
    List popQuestions = new LinkedList();
    List scienceQuestions = new LinkedList();
    List sportsQuestions = new LinkedList();
    List rockQuestions = new LinkedList();

    public QuestionMaker() {
        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add(("Science Question " + i));
            sportsQuestions.add(("Sports Question " + i));
            rockQuestions.add(createRockQuestion(i));
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

    public String createRockQuestion(int index){
        return "Rock Question " + index;
    }

    void askQuestion(Player currentPlayer) {
        if (POP.equals(currentCategory(currentPlayer))) {
            MyLogger.log((String)getPopQuestions().get(0));
            getPopQuestions().remove(0);
        }
        if (SCIENCE.equals(currentCategory(currentPlayer))) {
            MyLogger.log((String)getPopQuestions().get(0));
            getPopQuestions().remove(0);
        }
        if (SPORTS.equals(currentCategory(currentPlayer))) {
            MyLogger.log((String)getPopQuestions().get(0));
            getPopQuestions().remove(0);
        }
        if (ROCK.equals(currentCategory(currentPlayer))) {
            MyLogger.log((String)getPopQuestions().get(0));
            getPopQuestions().remove(0);
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