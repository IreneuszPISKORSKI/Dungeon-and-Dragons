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
    public Warrior(int id, String name, int health_points, int attack_power, String weapon, int wAttack, String wType, String armor){
        setType(1);
        setId(id);
        setNameOfCharacter(name);
        setHealthPoints(health_points);
        setAttackPower(attack_power);
        setTypeOfCharacter("Warrior");
        setWeapon(new Weapon());
        getWeapon().setName(weapon);
        getWeapon().setType(wType);
        getWeapon().setAttack(wAttack);
        setDefense(new Shield());
        getDefense().setName(armor);
    }
}
