package Board;

import Personnage.Personnage;

public interface Box {
    void interact(Personnage player);
    String getName();
    int getPosition();
}
