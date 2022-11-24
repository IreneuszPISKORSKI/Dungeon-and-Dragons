package Board;

import Personnage.Personnage;

public class EmptySpace extends Enemy{

    public EmptySpace(int position) {
        super(position);
        this.setName("0");
    }

    @Override
    public void interact(Personnage player) {
        System.out.println("Peace and quiet...");
    }
}
