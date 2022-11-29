package Board.Weapons;

import Board.Weapon;

public class Mace extends Weapon {
    public Mace(int position){
        this.setDmgUp(3);
        this.setName("Mace");
        this.setPosition(position);
        this.setTypeOfItem(1);
    }
}
