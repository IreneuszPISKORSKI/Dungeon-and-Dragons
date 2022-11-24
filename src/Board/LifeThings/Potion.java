package Board.LifeThings;

import Board.Life;

public class Potion extends Life {
    public Potion(int position){
        this.setHealthUp(2);
        this.setName("Potion");
        this.setPosition(position);
    }
}
