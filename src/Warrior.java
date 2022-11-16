public class Warrior extends Personnage{
        Warrior(String name, int type){
        setType(type);
        setNameOfCharacter(name);
        setHealthPoints(10);
        setAttackPower(10);
        setTypeOfCharacter("Warrior");
        weapon = new Weapon();
        defense = new Shield();
    }
}
