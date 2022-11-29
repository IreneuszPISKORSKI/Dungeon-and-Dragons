package Personnage;

import EquipmentDefensif.MageRobe;
import EquipmentDefensif.Shield;
import EquipmentOffensif.Spell;
import EquipmentOffensif.Weapon;

public class Wizard extends Personnage{
    public Wizard(String name){
        setType(2);
        setNameOfCharacter(name);
        setHealthPoints(6);
        setAttackPower(15);
        setTypeOfCharacter("You are a wizard Harry");
        setWeapon(new Spell());
        setDefense(new MageRobe());
    }
    public Wizard(int id, String name, int health_points, int attack_power, String weapon, int wAttack, String wType, String armor){
        setType(2);
        setId(id);
        setNameOfCharacter(name);
        setHealthPoints(health_points);
        setAttackPower(attack_power);
        setTypeOfCharacter("You are a wizard Harry");
        setWeapon(new Weapon());
        getWeapon().setName(weapon);
        getWeapon().setType(wType);
        getWeapon().setAttack(wAttack);
        setDefense(new Shield());
        getDefense().setName(armor);
    }
}
