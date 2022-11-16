import java.util.Scanner;


public class Menu {

    public void printMenu(){
        System.out.println("Choose one option:");
        System.out.println("1 - Create new character");
        System.out.println("2 - Character description");
        System.out.println("3 - Edit your character");
        System.out.println("4 - Start game!");
        System.out.println("5 - Exit");
    }
    public void createCharacter(personnage newCharacter){
        Scanner inputInfo = new Scanner(System.in);
        System.out.println("Name your character");
        newCharacter.setNameOfCharacter(inputInfo.nextLine());

        System.out.println("Choose type of your character");
        System.out.println("1 - warrior");
        System.out.println("2 - wizard");
        newCharacter.setType(inputInfo.nextInt());
        System.out.println(newCharacter);
    }

    public void printCharacter(personnage newCharacter){
        System.out.println(newCharacter);
    }

    public void exitGame(){
        System.out.println("ExitGame");
    }

}
