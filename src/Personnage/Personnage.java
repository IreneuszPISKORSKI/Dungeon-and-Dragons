package Personnage;

import EquipmentDefensif.EquipementDefensif;
import EquipmentOffensif.EquipementOffensif;

public abstract class Personnage {
    protected EquipementDefensif defense;
    protected EquipementOffensif weapon;
    protected String nameOfCharacter;
    protected int type;
    protected int healthPoints;
    protected int attackPower;
    protected String typeOfCharacter;
    protected int playerPosition;
    public Personnage(){

        this.nameOfCharacter = "Not yet created";
        this.type = 3;
    }
    public Personnage(String name){
        this.nameOfCharacter = name;
    }
    public Personnage(String name, int type){
        this.nameOfCharacter = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Your character: " +
            "Name: " + nameOfCharacter +
            ", type: " + typeOfCharacter +
            ". Your character has: " + weapon +
            " and " + defense + ", " +
            healthPoints + " health points and " +
            attackPower + " base attack power.\nYour final stats are: " +
            (attackPower+weapon.getAttack()) + " attack power and " +
            (healthPoints+defense.getDefence()) +
            " health points.\nYour starting position: " + playerPosition;
    }

    //getter & setter:

    public String getNameOfCharacter() {
        return nameOfCharacter;
    }

    public void setNameOfCharacter(String nameOfCharacter) {
        this.nameOfCharacter = nameOfCharacter;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    public int getType() {
        return type;
    }
    public String getTypeOfCharacter() {
        return typeOfCharacter;
    }
    public void setTypeOfCharacter(String typeOfCharacter) {
        this.typeOfCharacter = typeOfCharacter;
    }
    public int getPlayerPosition() {
        return playerPosition;
    }
    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }
    public EquipementDefensif getDefense() {
        return defense;
    }
    public void setDefense(EquipementDefensif defense) {
        this.defense = defense;
    }
    public EquipementOffensif getWeapon() {
        return weapon;
    }
    public void setWeapon(EquipementOffensif weapon) {
        this.weapon = weapon;
    }
    public void setType(int type) {
        this.type = type;
    }

}
