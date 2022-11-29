package Board;

import Personnage.Personnage;

public class Weapon extends Bonus{
    private int dmgUp ;
    private int typeOfPlayer;
    private int typeOfItem;
    @Override
    public int interact(Personnage player, int again) {
        setTypeOfPlayer(player.getType());
        System.out.println("You found a " + getName() + ". You had " +
                (player.getAttackPower()+player.getWeapon().getAttack()) + " attack power");

        if (player.getType() == getTypeOfItem() && player.getWeapon().getAttack()<dmgUp){
            player.getWeapon().setAttack(getDmgUp());
            player.getWeapon().setName(getName());
            System.out.println("It's a better weapon than your current one, you decide to keep it.\nNow you have " +
                    (player.getAttackPower()+player.getWeapon().getAttack()) + " attack power");
        }else if (player.getType() == getTypeOfItem() && player.getWeapon().getAttack()>=dmgUp){
            System.out.println("It's the same or weaker weapon than the one you're currently using, " +
                    "there's no point in taking it (and it's dirty!).\nYou have still " +
                    (player.getAttackPower()+player.getWeapon().getAttack()) + " attack power");
        }else {
            System.out.println("Sorry, not for you, no bonus. You have still " +
                    (player.getAttackPower()+player.getWeapon().getAttack()) + " attack power");
        }
    return 0;
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
