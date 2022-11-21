import Board.Board;
import Personnage.Personnage;
import Personnage.Warrior;
import Personnage.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Where the magic begins
 */
public class Game {
    private Menu menu = new Menu();
    private int boardSize = 64;
    private Personnage newCharacter;

    /**
     * Start game and display main menu
     */
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            menu.printMenu();
            choice = scanner.nextInt();
            switch (choice) {
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
        } while (choice != 5);
    }

    /**
     * create new character
     */
    private void createCharacter() {

        Scanner inputInfo = new Scanner(System.in);
        System.out.println("Name your character");
        String name = inputInfo.nextLine();

        System.out.println("Choose type of your character");
        System.out.println("1 - warrior");
        System.out.println("2 - wizard");
        int type = inputInfo.nextInt();

        /**
         * make warrior or wizard
         */
        if (type == 1) {
            newCharacter = new Warrior(name);

        } else if (type == 2) {
            newCharacter = new Wizard(name);
        }
        System.out.println(newCharacter);
    }

    /**
     * Start game
     */
    public void playGame() {
        Scanner gameOn = new Scanner(System.in);
        Scanner gameRestart = new Scanner(System.in);
        int thisThrow;
        int continueGame;
        int restart;

        //boxes
        Board board = new Board();
        int counter = 0;
        do {
            int position = randomOnBoard();
            board.add(position, "Bonus");
            board.readAll();
            board.elementsOnBoard();
            counter++;

        }while (counter<2);

//        System.out.println("tablica: ");
//        board.readAll();
//        board.edit(0,"hshshshshs");
//        System.out.println("Po edit: ");
//        board.readAll();
//        System.out.println("Po delete: ");
//        board.delete(0);
//        board.readAll();
    //boxes

        do {
            newCharacter.setPlayerPosition(1);
            System.out.println("Start game at: " + newCharacter.getPlayerPosition());
            try {
                /**
                 * loop turns of the game
                 */
                while (true) {
                    System.out.println("-----------------------");
                    System.out.println("Play?  1 - yes | 0 - no");
                    continueGame = gameOn.nextInt();
                    if (continueGame == 0) {
                        break;
                    }
                    thisThrow = diceThrow();
                    newCharacter.setPlayerPosition(newCharacter.getPlayerPosition() + thisThrow);
                    if (newCharacter.getPlayerPosition() >= boardSize) {
                        throw new PersonnageHorsPlateauException();
                    }
                    System.out.println("You got: " + thisThrow);
                    System.out.println("You are on case " + newCharacter.getPlayerPosition() + "/" + boardSize);
                }
                System.out.println("You left the game \nGame over!");

            } catch (PersonnageHorsPlateauException e) {
                System.out.println(e);
            }
            /**
             * ask for restart or quit game
             */
            finally {
                System.out.println("Do you want to play again?");
                System.out.println("1 - yes | 0 - no");
                restart = gameRestart.nextInt();
            }
        } while (restart == 1);
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    /**
     * take random digit as dice throw
     * @return give 1-6 digit
     */
    public int diceThrow() {
        return (int) (Math.random() * 6 + 1);
    }

    public int randomOnBoard(){
        //random between 1 and 63
        return (int) (Math.random()* 63 + 1);
    }

}
