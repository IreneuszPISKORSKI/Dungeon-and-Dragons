import Board.Board;
import Board.EmptySpace;
import Board.EnemyDragon;
import Board.EnemyMage;
import Board.EnemyGoblin;
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

        //boxes Start
        Board board = new Board();
        int counter = 1;

//      Add box to all places on the board
        do {
            EmptySpace emptySpace = new EmptySpace(counter);
            board.add(counter, emptySpace);
            counter++;
        }while (counter<boardSize+1);


//      Add bonus box x5
        int numberOfBonus = 13;
        System.out.println("Dragon: ");
        counter = 0;
        do {
            int position = board.randomBonusOnBoard();
            if (board.letsTry(position)) {
                System.out.println("Position: " + position);
                board.nameOnPosition(position);

                EnemyDragon enemyDragon = new EnemyDragon(position);
                board.edit(position, enemyDragon);
                board.nameOnPosition(position);
                counter++;
            }
        }while (counter<(numberOfBonus));



//      Add Enemy box x10
        int numberOfEnemies = 15;
        counter = 0;
        System.out.println("Mage: ");
        do {
            int position = board.randomEnemyOnBoard();
            if (board.letsTry(position)) {
                System.out.println("Position: " + position);
                board.nameOnPosition(position);
                EnemyMage enemyMage = new EnemyMage();
                board.edit(position, enemyMage);
                counter++;
            }

        }while (counter<(numberOfEnemies));


//      Add Weapon box x3
        int numberOfWeapons = 10;
        counter = 0;
        System.out.println("Goblin: ");
        do {
            int position = board.randomWeaponOnBoard();
            if (board.letsTry(position)) {
                System.out.println("Position: " + position);
                board.nameOnPosition(position);
                EnemyGoblin enemyGoblin = new EnemyGoblin();
                System.out.println(enemyGoblin);
                board.edit(position, enemyGoblin);
                board.nameOnPosition(position);
                counter++;
            }
        }while (counter<(numberOfWeapons));

        board.elementsOnBoard();
        board.readAll();


    //boxes End

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
                    thisThrow = board.diceThrow();
                    newCharacter.setPlayerPosition(newCharacter.getPlayerPosition() + thisThrow);

                    System.out.println("You got: " + thisThrow);
                    System.out.println("You are on case " + newCharacter.getPlayerPosition() + "/" + boardSize);

                    board.interactionBoardPlayer(newCharacter.getPlayerPosition());

//                    switch (playerGotBox) {
//                        case "Bonus" -> System.out.println("Bonus!");
//                        case "Enemy" -> System.out.println("Fight!");
//                        case "Weapon" -> System.out.println("Gear up!");
//                        default -> System.out.println("Nothing to see here...");
//                    }

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

}
