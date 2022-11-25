package Board;

import Personnage.Personnage;

public class EnemyGoblin extends Enemy {

    public EnemyGoblin(int position) {
        super(position);
        setName("Goblin");
        this.setEnemyAttack(1);
        this.setEnemyHealth(6);
    }

    @Override
    public void interact(Personnage player) {
        super.interact(player);
    }
}
