package kata.trivia;

import java.util.LinkedList;
import java.util.List;

public class QuestionMaker {
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
        if (currentCategory(currentPlayer) == "Pop") {
            MyLogger.log((String)getPopQuestions().get(0));
            getPopQuestions().remove(0);
        }
        if (currentCategory(currentPlayer) == "Science") {
            MyLogger.log((String)getPopQuestions().get(0));
            getPopQuestions().remove(0);
        }
        if (currentCategory(currentPlayer) == "Sports") {
            MyLogger.log((String)getPopQuestions().get(0));
            getPopQuestions().remove(0);
        }
        if (currentCategory(currentPlayer) == "Rock") {
            MyLogger.log((String)getPopQuestions().get(0));
            getPopQuestions().remove(0);
        }
    }

    String currentCategory(Player currentPlayer) {
        if (currentPlayer.getPlace() == 0) { return "Pop";}
        if (currentPlayer.getPlace() == 4) {return "Pop";}
        if (currentPlayer.getPlace() == 8) {return "Pop";}
        if (currentPlayer.getPlace() == 1) {return "Science";}
        if (currentPlayer.getPlace() == 5) {return "Science";}
        if (currentPlayer.getPlace() == 9) {return "Science";}
        if (currentPlayer.getPlace() == 2) {return "Sports";}
        if (currentPlayer.getPlace() == 6) {return "Sports";}
        if (currentPlayer.getPlace() == 10) {return "Sports";}
        return "Rock";
    }
}