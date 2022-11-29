package Board;

import Personnage.Personnage;

public interface Box {
    int interact(Personnage player, int again);
    String getName();
    int getPosition();
}
