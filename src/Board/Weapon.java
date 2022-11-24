package Board;

import Personnage.Personnage;

public class Weapon extends Bonus{
    private int dmgUp ;
    private int typeOfPlayer;
    private int typeOfItem;
    @Override
    public void interact(Personnage player) {
        int oldAttack = player.getAttackPower();
        setTypeOfPlayer(player.getType());
        System.out.println("You found a " + getName() + ". You had " + player.getAttackPower() + " attack power");
        if (player.getType() == getTypeOfItem()){
            player.setAttackPower(oldAttack + getDmgUp());
            System.out.println("Now you have " + player.getAttackPower() + "attack power");
        }else {
            System.out.println("Sorry, not for you, no bonus. You have still " + player.getAttackPower() + " attack power");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPosition() {
        return this.position;
    }

    public int getTypeOfItem() {
        return typeOfItem;
    }

    public void setTypeOfItem(int typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    public int getDmgUp() {
        return dmgUp;
    }

    public void setDmgUp(int dmgUp) {
        this.dmgUp = dmgUp;
    }

    public int getTypeOfPlayer() {
        return typeOfPlayer;
    }

    public void setTypeOfPlayer(int typeOfPlayer) {
        this.typeOfPlayer = typeOfPlayer;
    }
}
