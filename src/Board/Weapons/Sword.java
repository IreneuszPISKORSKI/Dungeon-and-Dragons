package Board.Weapons;

import Board.Weapon;

public class Sword extends Weapon {
    public Sword(int position){
        this.setDmgUp(5);
        this.setName("Sword");
        this.setPosition(position);
        this.setTypeOfItem(1);
    }
}
