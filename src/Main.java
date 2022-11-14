import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        Menu newGame = new Menu();
        int choice;
        do {
            System.out.println("Choose one option:");
            System.out.println("1 - Start new game");
            System.out.println("2 - Character description");
            System.out.println("3 - Edit your character");
            System.out.println("4 - Exit");
            choice = menu.nextInt();
            switch (choice){
                case 1 -> newGame.CreateCharacter();
                case 2 -> newGame.PrintCharacter();
                case 3 -> {
                    newGame.PrintCharacter();
                    newGame.CreateCharacter();
                }
                case 4 -> System.out.println("end");
                default -> System.out.println("Choose one of the given possibilities");
            }
            System.out.println(" ");
        }while (choice != 4);
    }

}