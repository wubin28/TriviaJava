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

    void askQuestion(Game game) {
        if (currentCategory(game) == "Pop")
            System.out.println(getPopQuestions().removeFirst());
        if (currentCategory(game) == "Science")
            System.out.println(getScienceQuestions().removeFirst());
        if (currentCategory(game) == "Sports")
            System.out.println(getSportsQuestions().removeFirst());
        if (currentCategory(game) == "Rock")
            System.out.println(getRockQuestions().removeFirst());
    }

    String currentCategory(Game game) {
        if (currentPlayer.getPlace() == 0) return "Pop";
        if (game.places[game.currentPlayer] == 4) return "Pop";
        if (game.places[game.currentPlayer] == 8) return "Pop";
        if (game.places[game.currentPlayer] == 1) return "Science";
        if (game.places[game.currentPlayer] == 5) return "Science";
        if (game.places[game.currentPlayer] == 9) return "Science";
        if (game.places[game.currentPlayer] == 2) return "Sports";
        if (game.places[game.currentPlayer] == 6) return "Sports";
        if (game.places[game.currentPlayer] == 10) return "Sports";
        return "Rock";
    }
}