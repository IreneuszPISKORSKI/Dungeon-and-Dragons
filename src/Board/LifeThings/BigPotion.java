package Board.LifeThings;

import Board.Life;

public class BigPotion extends Life {
    public BigPotion(int position){
        this.setHealthUp(5);
        this.setName("Big Potion");
        this.setPosition(position);
    }
}
