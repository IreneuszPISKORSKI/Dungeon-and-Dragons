package Board.Weapons;

import Board.Weapon;

public class FireBall extends Weapon {
    public FireBall(int position){
        this.setTypeOfItem(2);
        this.setDmgUp(7);
        this.setName("FireBall");
        this.setPosition(position);
    }
}
