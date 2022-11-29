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
    public int interact(Personnage player, int again) {
        return super.interact(player, again);
    }
}
