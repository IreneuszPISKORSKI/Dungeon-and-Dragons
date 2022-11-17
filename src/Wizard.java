public class Wizard extends Personnage{
    Wizard(String name){
        /**
         * Create wizard
         */
        setType(2);
        setNameOfCharacter(name);
        setHealthPoints(6);
        setAttackPower(15);
        setTypeOfCharacter("You are a wizard Harry");
        setWeapon(new Spell());
        setDefense(new Potion());
    }
}
