public class personnage {

    private EquipementDefensif defense = new EquipementDefensif();
    private EquipementOffensif weapon = new EquipementOffensif();
    private String nameOfCharacter;
    private int type;
    private int healthPoints;
    private int attackPower;
    private String typeOfCharacter;
    private int playerPosition;

    personnage(){
        this.nameOfCharacter = "Not yet created";
        this.type = 3;
    }
    personnage(String name){
        this.nameOfCharacter = name;
    }
    personnage(String name, int type){
        this.nameOfCharacter = name;
        this.type = type;
    }

    @Override
    public String toString() {
        if (this.type == 1){
            this.typeOfCharacter = "Warrior";
        } else if (this.type == 2) {
            this.typeOfCharacter = "You are a wizard Harry";
        }else if (this.type == 3) {
            this.typeOfCharacter = "Not yet selected";
        }else {
            this.typeOfCharacter = "What are you?";
        }

        return "Your character: " +
                "Name: " + nameOfCharacter +
                ", type: " + typeOfCharacter +
                ". Your character has: " + weapon +
                " and " + defense + ", " +
                healthPoints + " health points and " +
                attackPower + " base attack power. \nYour position: " + playerPosition;
    }

    //getter & setter:
    public String getNameOfCharacter() {
        return nameOfCharacter;
    }

    public void setNameOfCharacter(String nameOfCharacter) {
        this.nameOfCharacter = nameOfCharacter;}

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;}

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
        this.playerPosition = 0;
        if (type==1) {
            this.healthPoints = 10;
            this.attackPower = 10;
            this.weapon.setAsSword();
            this.defense.setAsShield();
        }else if (type == 2){
            this.healthPoints = 6;
            this.attackPower = 15;
            this.weapon.setAsSpell();
            this.defense.setAsPotion();
        }
    }

}
