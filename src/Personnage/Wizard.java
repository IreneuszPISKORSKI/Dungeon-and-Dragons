package Personnage;

import EquipmentDefensif.Potion;
import EquipmentOffensif.Spell;

public class Wizard extends Personnage{
    public Wizard(String name){
        setType(2);
        setNameOfCharacter(name);
        setHealthPoints(6);
        setAttackPower(15);
        setTypeOfCharacter("You are a wizard Harry");
        setWeapon(new Spell());
        setDefense(new Potion());
    }
}
