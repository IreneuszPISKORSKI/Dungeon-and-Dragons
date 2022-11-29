import Personnage.Personnage;

public class Menu {
    public void printMenu(){
        System.out.println("Choose one option:");
        System.out.println("1 - Create new character");
        System.out.println("2 - Choose your Character");
        System.out.println("3 - Edit this character");
        System.out.println("4 - Delete this character");
        System.out.println("5 - Start game!");
        System.out.println("6 - Exit");
    }

    public void printCharacter(Personnage newCharacter){
        System.out.println(newCharacter);
    }

    public void exitGame(){
        System.out.println("ExitGame");
    }

}
