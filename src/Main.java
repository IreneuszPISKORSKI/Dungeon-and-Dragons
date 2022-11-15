import java.util.Scanner;

public class Main {
    private static Menu newGame;
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        newGame = new Menu();
        int choice;
        do {
            newGame.printMenu();
            choice = menu.nextInt();
            switch (choice){
                case 1 -> newGame.CreateCharacter();
                case 2 -> newGame.printCharacter();
                case 3 -> {
                    newGame.printCharacter();
                    newGame.CreateCharacter();
                }
                case 4 -> newGame.playGame();
                case 5 -> newGame.exitGame();
                default -> System.out.println("Incorrect choice.");
            }
            System.out.println(" ");
        }while (choice != 5);
    }

    public static Menu getNewGame() {
        return newGame;
    }

    public static void setNewGame(Menu newGame) {
        Main.newGame = newGame;
    }
}