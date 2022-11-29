package Board;

import Personnage.Personnage;

public class EmptySpace implements Box{
    private int position;
    public EmptySpace(int position) {
        this.position = position;
    }
    
    public String toString(){
        return "Box number: " + position + ", it have: " + getName();
    }

    @Override
    public int interact(Personnage player, int again) {
        System.out.println("Peace and quiet...");
        return 0;
    }

    @Override
    public String getName() {
        return "0";
    }

    @Override
    public int getPosition() {
        return position;
    }
}
