//import BDDconnectionAndManagement.AddHero;

import BDDconnectionAndManagement.BDDConnect;
//import BDDconnectionAndManagement.SelectAll;
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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Scanner;

//Where the magic begins
public class Game {
    private Menu menu = new Menu();
    private int boardSize;
    private Personnage newCharacter;

    //Start game and display main menu
    public void startGame(int size) {
        setBoardSize(size);
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            BDDConnect.selectAll();
            menu.printMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createCharacter();
                case 2 -> selectCharacter();
                case 3 -> editCharacter(newCharacter.getId());
                case 4 -> BDDConnect.deleteHero(newCharacter.getNameOfCharacter());
                case 5 -> playGame();
                case 6 -> menu.exitGame();
                default -> System.out.println("Incorrect choice.");
            }
            System.out.println(" ");
        } while (choice != 5);
    }

    private void selectCharacter() {
        Scanner inputInfo = new Scanner(System.in);
        System.out.println("Which one do you want to choose (enter id)");
        int id = inputInfo.nextInt();
        System.out.println(id);

        try {
            ResultSet selected = BDDConnect.selectOne(id);
            while (selected.next()) {
                if (selected.getInt("type") == 1) {

                    newCharacter = new Warrior(id,
                            selected.getString("name"),
                            selected.getInt("health_points"),
                            selected.getInt("attack_power"),
                            selected.getString("weapon"),
                            selected.getInt("wAttack"),
                            selected.getString("wType"),
                            selected.getString("armor"));

                } else if (selected.getInt("type") == 2) {

                    newCharacter = new Wizard(id,
                            selected.getString("name"),
                            selected.getInt("health_points"),
                            selected.getInt("attack_power"),
                            selected.getString("weapon"),
                            selected.getInt("wAttack"),
                            selected.getString("wType"),
                            selected.getString("armor"));
                }
            }
            System.out.println("You have chosen a character:" +
                    " Id: " + newCharacter.getId() +
                    ", Name: " + newCharacter.getNameOfCharacter() +
                    ", Type: " + newCharacter.getType() +
                    ", HP: " + newCharacter.getHealthPoints() +
                    ", AP: " + newCharacter.getAttackPower() +
                    ", Weapon: " + newCharacter.getWeapon() +
                    ", Armor: " + newCharacter.getDefense());
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        BDDConnect.addHero(type, name, newCharacter.getHealthPoints(), newCharacter.getAttackPower(), newCharacter.getWeapon().getName(), newCharacter.getWeapon().getAttack(), newCharacter.getWeapon().getType(), newCharacter.getDefense().getName());
        System.out.println(newCharacter);
    }

    private void editCharacter(int oldID) {
        BDDConnect.selectOne(oldID);
        menu.printCharacter(newCharacter);
        Scanner inputInfo = new Scanner(System.in);
        System.out.println("Rename your character");
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

        BDDConnect.editHero(type, name, newCharacter.getHealthPoints(), newCharacter.getAttackPower(), newCharacter.getWeapon().getName(), newCharacter.getWeapon().getAttack(), newCharacter.getWeapon().getType(), newCharacter.getDefense().getName(), oldID);
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
        } while (counter < boardSize);


        //      Add dragon box x4
        int numberOfDragons = 4;
        counter = 0;
        do {
            int position = board.randomDragonPos(boardSize);
            if (board.letsTry(position)) {
                EnemyDragon enemyDragon = new EnemyDragon(position);
                board.edit(position, enemyDragon);
                counter++;
            }
        } while (counter < (numberOfDragons));


        //      Add Mages box x10
        int numberOfMages = 10;
        counter = 0;
        do {
            int position = board.randomDragonPos(boardSize);
            if (board.letsTry(position)) {
                EnemyMage enemyMage = new EnemyMage(position);
                board.edit(position, enemyMage);
                counter++;
            }

        } while (counter < (numberOfMages));


        //      Add Goblins box x10
        int numberOfGoblins = 10;
        counter = 0;
        do {
            int position = board.randomDragonPos(boardSize);
            if (board.letsTry(position)) {
                EnemyGoblin enemyGoblin = new EnemyGoblin(position);
                board.edit(position, enemyGoblin);
                counter++;
            }
        } while (counter < (numberOfGoblins));


        //      Add Mace box x5
        int numberOfMace = 5;
        counter = 0;
        do {
            int position = board.randomDragonPos(boardSize);
            if (board.letsTry(position)) {
                Mace mace = new Mace(position);
                board.edit(position, mace);
                counter++;
            }
        } while (counter < (numberOfMace));


//      Add Sword x4
        int numberOfSword = 4;
        counter = 0;
        do {
            int position = board.randomDragonPos(boardSize);
            if (board.letsTry(position)) {
                Sword sword = new Sword(position);
                board.edit(position, sword);
                counter++;
            }
        } while (counter < (numberOfSword));


        //      Add Big potion x2
        int numberOfBigPotions = 2;
        counter = 0;
        do {
            int position = board.randomDragonPos(boardSize);
            if (board.letsTry(position)) {
                BigPotion potion = new BigPotion(position);
                board.edit(position, potion);
                counter++;
            }
        } while (counter < (numberOfBigPotions));


        //      Add MageRobe x6
        int numberOfPotions = 6;
        counter = 0;
        do {
            int position = board.randomDragonPos(boardSize);
            if (board.letsTry(position)) {
                Potion potion = new Potion(position);
                board.edit(position, potion);
                counter++;
            }
        } while (counter < (numberOfPotions));


        //      Add Fireballs x2
        int numberOfFireballs = 2;
        counter = 0;
        do {
            int position = board.randomDragonPos(boardSize);
            if (board.letsTry(position)) {
                FireBall fireBall = new FireBall(position);
                board.edit(position, fireBall);
                counter++;
            }
        } while (counter < (numberOfFireballs));


        //      Add Lightning x5
        int numberOfLightnings = 5;
        counter = 0;
        do {
            int position = board.randomDragonPos(boardSize);
            if (board.letsTry(position)) {
                Lightning lightning = new Lightning(position);
                board.edit(position, lightning);
                counter++;
            }
        } while (counter < (numberOfLightnings));


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
                    System.out.println("You are on case " + newCharacter.getPlayerPosition() +
                            "/" + (boardSize - 1) + "\nYour character has " +
                            (newCharacter.getAttackPower() + newCharacter.getWeapon().getAttack()) + " attack points and " +
                            (newCharacter.getHealthPoints() + newCharacter.getDefense().getDefence()) + " health points");

                    if (newCharacter.getPlayerPosition() >= (boardSize - 1)) {
                        throw new PersonnageHorsPlateauException();
                    }

                    board.interactionBoardPlayer(newCharacter);

                    if ((newCharacter.getHealthPoints() + newCharacter.getDefense().getDefence()) < 1) {
                        throw new PersonnageDead();
                    }
                }
                System.out.println("You left the game \nGame over!");

            } catch (PersonnageHorsPlateauException | PersonnageDead e) {
                System.out.println(e);
            }

//            ask for restart or quit game
            finally {
                System.out.println("Do you want to play again?");
                System.out.println("1 - yes | 0 - no");
                restart = gameRestart.nextInt();
                if (newCharacter.getType() == 1) {
                    newCharacter.setHealthPoints(10);
                    newCharacter.getWeapon().setName("You have been robbed in the meantime so again short sword");
                    newCharacter.getWeapon().setAttack(2);
                } else if (newCharacter.getType() == 2) {
                    newCharacter.setHealthPoints(6);
                    newCharacter.getWeapon().setName("You got amnesia and again it's flame touch");
                    newCharacter.getWeapon().setAttack(2);
                }
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
