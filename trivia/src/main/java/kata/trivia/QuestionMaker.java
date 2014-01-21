package kata.trivia;

import java.util.LinkedList;

public class QuestionMaker {
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public QuestionMaker() {
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
}