package innerclasses;
import static innerclasses.util.Print.*;
//переписанный Games с безымянными классами

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    private Checkers() {}
    private int moves = 0;
    private static final int MOVES = 3;
    public boolean move() {
        print("Checkers move " + moves);
        return ++moves != MOVES;
    }
    public static GameFactory factory = new GameFactory() {
        public Game getGame() {return new Checkers();}
    };
}

class Chess implements Game {
    private Chess() {}
    private int moves = 0;
    private static final int MOVES = 4;
    public boolean move() {
        print("Chess move " + moves);
        return ++moves != MOVES;
    }
    public static GameFactory factory = new GameFactory() {
        public Game getGame() {return new Chess();}
    };
}

public class GamesNew {
    public static void playGame(GameFactory gameFactory) {
        Game game = gameFactory.getGame();
        while (game.move());
    }
    public static void main(String[] args) {
        playGame(Checkers.factory);
        print();
        playGame(Chess.factory);
    }
}
