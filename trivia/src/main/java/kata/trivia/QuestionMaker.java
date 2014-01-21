package kata.trivia;

import java.util.LinkedList;

public class QuestionMaker {
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public QuestionMaker() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }
    public LinkedList getPopQuestions() {
        return popQuestions;
    }

    public LinkedList getScienceQuestions() {
        return scienceQuestions;
    }

    public LinkedList getSportsQuestions() {
        return sportsQuestions;
    }

    public LinkedList getRockQuestions() {
        return rockQuestions;
    }

    public String createRockQuestion(int index){
        return "Rock Question " + index;
    }

    void askQuestion(Player currentPlayer) {
        if (currentCategory(currentPlayer) == "Pop")
            MyLogger.log((String)getPopQuestions().removeFirst());
        if (currentCategory(currentPlayer) == "Science")
            MyLogger.log((String)getScienceQuestions().removeFirst());
        if (currentCategory(currentPlayer) == "Sports")
            MyLogger.log((String)getSportsQuestions().removeFirst());
        if (currentCategory(currentPlayer) == "Rock")
            MyLogger.log((String)getRockQuestions().removeFirst());
    }

    String currentCategory(Player currentPlayer) {
        if (currentPlayer.getPlace() == 0) return "Pop";
        if (currentPlayer.getPlace() == 4) return "Pop";
        if (currentPlayer.getPlace() == 8) return "Pop";
        if (currentPlayer.getPlace() == 1) return "Science";
        if (currentPlayer.getPlace() == 5) return "Science";
        if (currentPlayer.getPlace() == 9) return "Science";
        if (currentPlayer.getPlace() == 2) return "Sports";
        if (currentPlayer.getPlace() == 6) return "Sports";
        if (currentPlayer.getPlace() == 10) return "Sports";
        return "Rock";
    }
}