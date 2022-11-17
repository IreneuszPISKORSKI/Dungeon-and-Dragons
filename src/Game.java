import java.util.Scanner;

public class Game {
    private Menu menu = new Menu();
    private int boardSize = 64;
    private Personnage newCharacter;

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            /**
             * Display main menu
             */
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

    private void createCharacter() {
        /**
         * create new character
         */
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

    public void playGame() {
        /**
         * Start game
         */
        Scanner gameOn = new Scanner(System.in);
        Scanner gameRestart = new Scanner(System.in);
        int thisThrow;
        int continueGame;
        int restart;
        do {
            newCharacter.setPlayerPosition(1);
            System.out.println("Start game at: " + newCharacter.getPlayerPosition());
            try {
                /**
                 * loop turns of the game
                 *
                 */
                while (true) {
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
            } finally {
                /**
                 * ask for restart or quit game
                 */
                System.out.println("Do you want to play again?");
                System.out.println("1 - yes | 0 - no");
                restart = gameRestart.nextInt();
                System.out.println("--------------------");
            }
        } while (restart == 1);
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }


    public int diceThrow() {
        /**
         * take random digit 1 to 6 as dice trow
         */
        return (int) (Math.random() * 6 + 1);
    }

}
