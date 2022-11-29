import BDDconnectionAndManagement.BDDConnect;

public class Main {
    /**
     * The game has begun
     */
    public static void main(String[] args) {
            BDDConnect.getInstance();
            Game newGame = new Game();
            newGame.startGame(64);
    }
}