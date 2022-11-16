import java.util.Scanner;

public class Game {
    Menu menu = new Menu();
    private int boardSize = 64;
    Personnage newCharacter;

    public void startGame(){
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            menu.printMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> createCharacter();
                case 2 -> menu.printCharacter(newCharacter);
                case 3 -> {
                    menu.printCharacter(newCharacter);
                    createCharacter();
                }
                case 4 -> playGame();
                case 5 -> menu.exitGame();
                default -> System.out.println("Incorrect choice.");
            }
            System.out.println(" ");
        }while (choice != 5);
    }

    private void createCharacter() {
        Scanner inputInfo = new Scanner(System.in);
        System.out.println("Name your character");
        String name = inputInfo.nextLine();

        System.out.println("Choose type of your character");
        System.out.println("1 - warrior");
        System.out.println("2 - wizard");
        int type = inputInfo.nextInt();

        if (type==1){
            newCharacter = new Warrior(name,type);

        } else if (type==2) {
            newCharacter = new Wizard(name,type);
        }
        System.out.println(newCharacter);
    }

    public void playGame(){
        Scanner gameOn = new Scanner(System.in);
        Scanner gameRestart = new Scanner(System.in);
        int thisThrow;
        int continueGame;
        int restart;
        do {
            newCharacter.setPlayerPosition(0);
            System.out.println("Start game at: " + newCharacter.getPlayerPosition());
            while (newCharacter.getPlayerPosition() < boardSize) {
                System.out.println("Play?");
                System.out.println("1 - yes | 0 - no");
                continueGame = gameOn.nextInt();
                if (continueGame == 0) {
                    break;
                }
                thisThrow = diceThrow();
                newCharacter.setPlayerPosition(newCharacter.getPlayerPosition()+thisThrow);
                System.out.println("You got: " + thisThrow);
                System.out.println("You are on case " + newCharacter.getPlayerPosition() + "/" + boardSize);
            }
            if (newCharacter.getPlayerPosition()>=boardSize) {
                System.out.println("Congratulations! You've reached the end of the board!");
            }else {System.out.println("Game over");}

            System.out.println("Do you want to play again?");
            System.out.println("1 - yes | 0 - no");
            restart = gameRestart.nextInt();
        }while (restart==1);

        System.out.println("");
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }



    public int diceThrow(){
        //random 1-6
        return (int) (Math.random()*6+1);
    }

}
