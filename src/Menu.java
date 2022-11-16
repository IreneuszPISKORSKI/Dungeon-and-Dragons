public class Menu {

    public void printMenu(){
        System.out.println("Choose one option:");
        System.out.println("1 - Create new character");
        System.out.println("2 - Character description");
        System.out.println("3 - Edit your character");
        System.out.println("4 - Start game!");
        System.out.println("5 - Exit");
    }

    public void printCharacter(Personnage newCharacter){
        System.out.println(newCharacter);
    }

    public void exitGame(){
        System.out.println("ExitGame");
    }

}
