import Board.Board;
import Board.EmptySpace;
import Board.EnemyDragon;
import Board.EnemyMage;
import Board.EnemyGoblin;
import Board.LifeThings.BigPotion;
import Board.LifeThings.Potion;
import Board.Weapons.FireBall;
import Board.Weapons.Lightning;
import Board.Weapons.Mace;
import Board.Weapons.Sword;
import Personnage.Personnage;
import Personnage.Warrior;
import Personnage.Wizard;

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
        int counter = 0;

//      Add box to all places on the board
        do {
            EmptySpace emptySpace = new EmptySpace(counter);
            board.add(emptySpace);
            counter++;
        }while (counter<boardSize);


//      Add dragon box x4
        int numberOfDragons = 4;
        counter = 0;
        do {
            int position = board.randomDragonPos();
            if (board.letsTry(position)) {
                EnemyDragon enemyDragon = new EnemyDragon(position);
                board.edit(position, enemyDragon);
                counter++;
            }
        }while (counter<(numberOfDragons));



//      Add Mages box x10
        int numberOfMages = 10;
        counter = 0;
        do {
            int position = board.randomDragonPos();
            if (board.letsTry(position)) {
                EnemyMage enemyMage = new EnemyMage(position);
                board.edit(position, enemyMage);
                counter++;
            }

        }while (counter<(numberOfMages));


//      Add Goblins box x10
        int numberOfGoblins = 10;
        counter = 0;
        do {
            int position = board.randomDragonPos();
            if (board.letsTry(position)) {
                EnemyGoblin enemyGoblin = new EnemyGoblin(position);
                board.edit(position, enemyGoblin);
                counter++;
            }
        }while (counter<(numberOfGoblins));

        //      Add Mace box x5
        int numberOfMace = 5;
        counter = 0;
        do {
            int position = board.randomDragonPos();
            if (board.letsTry(position)) {
                Mace mace = new Mace(position);
                board.edit(position, mace);
                counter++;
            }
        }while (counter<(numberOfMace));

//      Add Sword x4
        int numberOfSword = 4;
        counter = 0;
        do {
            int position = board.randomDragonPos();
            if (board.letsTry(position)) {
                Sword sword = new Sword(position);
                board.edit(position, sword);
                counter++;
            }
        }while (counter<(numberOfSword));


        //      Add Big potion x2
        int numberOfBigPotions = 2;
        counter = 0;
        do {
            int position = board.randomDragonPos();
            if (board.letsTry(position)) {
                BigPotion potion = new BigPotion(position);
                board.edit(position, potion);
                counter++;
            }
        }while (counter<(numberOfBigPotions));


        //      Add Potion x6
        int numberOfPotions = 6;
        counter = 0;
        do {
            int position = board.randomDragonPos();
            if (board.letsTry(position)) {
                Potion potion = new Potion(position);
                board.edit(position, potion);
                counter++;
            }
        }while (counter<(numberOfPotions));


        //      Add Fireballs x2
        int numberOfFireballs = 2;
        counter = 0;
        do {
            int position = board.randomDragonPos();
            if (board.letsTry(position)) {
                FireBall fireBall = new FireBall(position);
                board.edit(position, fireBall);
                counter++;
            }
        }while (counter<(numberOfFireballs));


        //      Add Lightning x5
        int numberOfLightnings = 5;
        counter = 0;
        do {
            int position = board.randomDragonPos();
            if (board.letsTry(position)) {
                Lightning lightning = new Lightning(position);
                board.edit(position, lightning);
                counter++;
            }
        }while (counter<(numberOfLightnings));




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
                    System.out.println("You are on case " + newCharacter.getPlayerPosition() + "/" + (boardSize-1));
                    if (newCharacter.getPlayerPosition() > boardSize) {
                        throw new PersonnageHorsPlateauException();
                    }
                    board.interactionBoardPlayer(newCharacter);

                }
                System.out.println("You left the game \nGame over!");

            } catch (PersonnageHorsPlateauException e) {
                System.out.println("Message " + e);
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
