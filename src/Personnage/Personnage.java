package Personnage;

import EquipmentDefensif.EquipementDefensif;
import EquipmentOffensif.EquipementOffensif;

/**
 * Abstract class for creating new characters
 */
public abstract class Personnage {
    /**
     * creates a defensive item for the character with the help of a EquipmentDefensif Class
     * @see EquipementDefensif Equipement defensif class
     */
    protected EquipementDefensif defense;
    /**
     * creates an offensive item for the character with the help of a EquipmentOffensif Class
     * @see EquipementOffensif Equipement offensif class
     */
    protected EquipementOffensif weapon;
    /**
     * a string attribute created to store the character's name
     */
    protected String nameOfCharacter;
    /**
     * int attribute created to store the character's type: 1-warrior, 2-wizard
     * @see Warrior
     * @see Wizard
     */
    protected int type;
    /**
     * an int attribute created to store the character's health points
     */
    protected int healthPoints;
    /**
     * an int attribute created to store the character's attack power
     */
    protected int attackPower;
    /**
     * an attribute created to store a character type in the form of string
     */
    protected String typeOfCharacter;
    /**
     * an int attribute created to store the character's position
     */
    protected int playerPosition;
    /**
     * creation character "not yet"
     */
    public Personnage(){

        this.nameOfCharacter = "Not yet created";
        this.type = 3;
    }
    /**
     * creation character with string parameter "name"
     * @param name name of character
     */
    public Personnage(String name){
        this.nameOfCharacter = name;
    }
    /**
     * creation character with string parameter "name" and int parameter "type"
     * @param name name of character
     * @param type type of character
     */
    public Personnage(String name, int type){
        this.nameOfCharacter = name;
        this.type = type;
    }

    /**
     * determinate how to display characters
     * @return string to display
     */
    @Override
    public String toString() {
        return "Your character: " +
            "Name: " + nameOfCharacter +
            ", type: " + typeOfCharacter +
            ". Your character has: " + weapon +
            " and " + defense + ", " +
            healthPoints + " health points and " +
            attackPower + " base attack power. \nYour position: " + playerPosition;
    }

    //getter & setter:

    /**
     * Getter of the nameOfCharacter
     * @return nameOfCharacter
     */
    public String getNameOfCharacter() {
        return nameOfCharacter;
    }

    /**
     * Setter of the nameOfCharacter
     * @param nameOfCharacter
     */
    public void setNameOfCharacter(String nameOfCharacter) {
        this.nameOfCharacter = nameOfCharacter;}
    /**
     * Getter of the healthPoints
     * @return healthPoints
     */
    public int getHealthPoints() {
        return healthPoints;
    }
/**
     * Setter of the healthPoints
     * @param healthPoints
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;}
/**
     * Getter of the attackPower
     * @return attackPower
     */
    public int getAttackPower() {
        return attackPower;
    }
/**
     * Setter of the attackPower
     * @param attackPower
     */
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
/**
     * Getter of the type
     * @return type
     */
    public int getType() {
        return type;
    }
/**
     * Getter of the typeOfCharacter
     * @return typeOfCharacter
     */
    public String getTypeOfCharacter() {
        return typeOfCharacter;
    }
/**
     * Setter of the typeOfCharacter
     * @param typeOfCharacter
     */
    public void setTypeOfCharacter(String typeOfCharacter) {
        this.typeOfCharacter = typeOfCharacter;
    }
/**
     * Getter of the playerPosition
     * @return playerPosition
     */
    public int getPlayerPosition() {
        return playerPosition;
    }
/**
     * Setter of the playerPosition
     * @param playerPosition
     */
    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }
/**
     * Getter of the defense
     * @return defense
     */
    public EquipementDefensif getDefense() {
        return defense;
    }
/**
     * Setter of the defense
     * @param defense
     */
    public void setDefense(EquipementDefensif defense) {
        this.defense = defense;
    }
/**
     * Getter of the weapon
     * @return weapon
     */
    public EquipementOffensif getWeapon() {
        return weapon;
    }
/**
     * Setter of the weapon
     * @param weapon
     */
    public void setWeapon(EquipementOffensif weapon) {
        this.weapon = weapon;
    }
/**
     * Setter of the type
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

}
