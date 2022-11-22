import Board.Board;
import Personnage.Personnage;
import Personnage.Warrior;
import Personnage.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Where the magic begins
public class Game {
    private Menu menu = new Menu();
    private int boardSize = 64;
    private Personnage newCharacter;

    //Start game and display main menu
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

    //create new character
    private void createCharacter() {

        Scanner inputInfo = new Scanner(System.in);
        System.out.println("Name your character");
        String name = inputInfo.nextLine();

        System.out.println("Choose type of your character");
        System.out.println("1 - warrior");
        System.out.println("2 - wizard");
        int type = inputInfo.nextInt();

        //make warrior or wizard
        if (type == 1) {
            newCharacter = new Warrior(name);

        } else if (type == 2) {
            newCharacter = new Wizard(name);
        }
        System.out.println(newCharacter);
    }

    //Start game
    public void playGame() {
        Scanner gameOn = new Scanner(System.in);
        Scanner gameRestart = new Scanner(System.in);
        int thisThrow;
        int continueGame;
        int restart;

        //boxes
        Board board = new Board();
        int counter = 1;

//      Add box to all places on the board
        do {
            board.add(counter, "0");
            counter++;
        }while (counter<boardSize+1);


//      Add bonus box x5
        int numberOfBonus = 5;
        counter = 0;
        do {
            int position = randomOnBoard();
            if (board.letsTry(position)) {
                board.edit(position, "Bonus");
                counter++;
            }
        }while (counter<numberOfBonus);



//      Add Enemy box x10
        int numberOfEnemies = 10;
        counter = 0;
        do {
            int position = randomOnBoard();
            if (board.letsTry(position)) {
                board.edit(position, "Enemy");
                counter++;
            }

        }while (counter<numberOfEnemies);


//      Add Weapon box x3
        int numberOfWeapons = 3;
        counter = 0;
        do {
            int position = randomOnBoard();
            if (board.letsTry(position)) {
                board.edit(position, "Weapon");
                counter++;
            }
        }while (counter<numberOfWeapons);

        board.elementsOnBoard();
        board.readAll();


    //boxes

        do {
            newCharacter.setPlayerPosition(0);
            System.out.println("Start game at: " + newCharacter.getPlayerPosition());
            try {

//              loop turns of the game
                while (true) {
                    System.out.println("-----------------------");
                    System.out.println("Play?  1 - yes | 0 - no");
                    continueGame = gameOn.nextInt();
                    if (continueGame == 0) {
                        break;
                    }
                    thisThrow = diceThrow();
                    newCharacter.setPlayerPosition(newCharacter.getPlayerPosition() + thisThrow);

                    System.out.println("You got: " + thisThrow);
                    System.out.println("You are on case " + newCharacter.getPlayerPosition() + "/" + boardSize);

                    String playerGotBox = board.interactionBoardPlayer(newCharacter.getPlayerPosition());

                    switch (playerGotBox) {
                        case "Bonus" -> System.out.println("Bonus!");
                        case "Enemy" -> System.out.println("Fight!");
                        case "Weapon" -> System.out.println("Gear up!");
                        default -> System.out.println("Nothing to see here...");
                    }

                    if (newCharacter.getPlayerPosition() >= boardSize) {
                        throw new PersonnageHorsPlateauException();
                    }
                }
                System.out.println("You left the game \nGame over!");

            } catch (PersonnageHorsPlateauException e) {
                System.out.println(e);
            }

//            ask for restart or quit game
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

    //take random digit as dice throw, return 1-6
    public int diceThrow() {
        return (int) (Math.random() * 6 + 1);
    }

    public int randomOnBoard(){
        //random between 1 and 63
        return (int) (Math.random()* 62 + 1);
    }

}
