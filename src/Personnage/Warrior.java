package Personnage;
import EquipmentDefensif.Shield;
import EquipmentOffensif.Weapon;

public class Warrior extends Personnage{
    public Warrior(String name){
        setType(1);
        setNameOfCharacter(name);
        setHealthPoints(10);
        setAttackPower(10);
        setTypeOfCharacter("Warrior");
        setWeapon(new Weapon());
        setDefense(new Shield());
    }
}
