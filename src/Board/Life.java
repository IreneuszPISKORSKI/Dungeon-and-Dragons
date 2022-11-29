package Board;

import Personnage.Personnage;

public class Life extends Bonus{
    private int healthUp ;
    @Override
    public int interact(Personnage player, int again) {
        int oldHP = player.getHealthPoints();
        System.out.println("You have found: " + getName() + "\nYou had: " + (player.getHealthPoints()+player.getDefense().getDefence()) + " health points");
        player.setHealthPoints(oldHP + getHealthUp());
        System.out.println("Now you have: " + (player.getHealthPoints()+player.getDefense().getDefence()) + " health points");
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

    public int getHealthUp() {
        return healthUp;
    }

    public void setHealthUp(int healthUp) {
        this.healthUp = healthUp;
    }
}
