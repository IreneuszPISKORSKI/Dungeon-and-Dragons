package Board;

import Personnage.Personnage;

public class EnemyDragon extends Enemy{

    public EnemyDragon(int position) {
        super(position);
        this.setName("Dragon");
        this.setEnemyAttack(4);
        this.setEnemyHealth(15);
    }

    @Override
    public void interact(Personnage player) {
        super.interact(player);
    }
}
