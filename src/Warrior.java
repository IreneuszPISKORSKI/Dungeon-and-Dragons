public class Warrior extends Personnage{
    Warrior(String name){
        /**
         * determinate statistics of warrior
         */
        setType(1);
        setNameOfCharacter(name);
        setHealthPoints(10);
        setAttackPower(10);
        setTypeOfCharacter("Warrior");
        setWeapon(new Weapon());
        setDefense(new Shield());
    }
}
