public class Wizard extends Personnage{
    Wizard(String name, int type){
        setType(type);
        setNameOfCharacter(name);
        setHealthPoints(6);
        setAttackPower(15);
        setTypeOfCharacter("You are a wizard Harry");
        weapon = new Spell();
        defense = new Potion();
    }
}
