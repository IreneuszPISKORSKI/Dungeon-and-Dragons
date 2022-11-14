public class Personnage {

    String nameofcharacter;
    int type;
    int healthPoints;
    int attackPower;
    String typeOfCharacter;

    Personnage(){
        this.nameofcharacter = "Not yet created";
        this.type = 3;
    }
    Personnage(String name){
        this.nameofcharacter = name;
    }
    Personnage(String name, int type){
        this.nameofcharacter = name;
        this.type = type;
    }

    //getter & setter:
    public String getNameofcharacter() {
        return nameofcharacter;
    }

    public void setNameofcharacter(String nameofcharacter) {
        this.nameofcharacter = nameofcharacter;}

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

    public void setType(int type) {
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
            this.typeOfCharacter = "What r u?";
        }
        return "Your character: " +
                "Name: " + nameofcharacter +
                ", type: " + typeOfCharacter;
    }
}
