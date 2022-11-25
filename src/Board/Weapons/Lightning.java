package Board.Weapons;

import Board.Weapon;

public class Lightning extends Weapon {
    public Lightning(int position){
        this.setDmgUp(4);
        this.setName("Lightning");
        this.setPosition(position);
        this.setTypeOfItem(2);
    }
}
