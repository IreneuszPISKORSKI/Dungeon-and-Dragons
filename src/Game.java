import java.util.Scanner;

public class Game {


    private int boardSize = 64;
    Personnage pos = new Personnage();
    private int playerPosition;
    public void playGame(){
        Scanner gameOn = new Scanner(System.in);
        Scanner gameRestart = new Scanner(System.in);
        int thisThrow;
        int continueGame;
        int restart = 1;
        while (restart==1){
            playerPosition = 0;
            System.out.println("Start game at: " + playerPosition);
            while (playerPosition < boardSize) {
                System.out.println("Play?");
                System.out.println("1 - yes | 0 - no");
                continueGame = gameOn.nextInt();
                if (continueGame == 0) {
                    break;
                }
                thisThrow = DiceThrow();
                playerPosition += thisThrow;
                System.out.println("You got: " + thisThrow);
                System.out.println("You are on case " + playerPosition + "/" + boardSize);
            }
            if (playerPosition>=boardSize) {
                System.out.println("Congratulations! You've reached the end of the board!");
            }else {System.out.println("Game over");}

            System.out.println("Do you want to play again?");
            System.out.println("1 - yes | 0 - no");
            restart = gameRestart.nextInt();
            setPlayerPosition(playerPosition);
        }

        System.out.println("");
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int DiceThrow(){
        //random 1-6
        return (int) (Math.random()*6+1);
    }

}
