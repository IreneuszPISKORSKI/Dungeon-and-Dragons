import java.util.Scanner;


public class Menu {

    Personnage newCharacter = new Personnage();



    public void CreateCharacter(){
        Scanner inputInfo = new Scanner(System.in);
        System.out.println("Type name of your character");
        newCharacter.setNameofcharacter(inputInfo.nextLine());

        System.out.println("Choose type of your character");
        System.out.println("1 - warrior");
        System.out.println("2 - wizard");
        newCharacter.setType(inputInfo.nextInt());

        System.out.println(newCharacter);
    }

    public void PrintCharacter(){

        System.out.println(newCharacter);
    }
    public void ExitGame(){
        System.out.println("ExitGame");
    }

}
