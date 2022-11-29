package Board;

import Personnage.Personnage;

public class EnemyMage extends Enemy {

    public EnemyMage(int position) {
        super(position);
        setName("Mage");
        this.setEnemyAttack(2);
        this.setEnemyHealth(9);
    }

    @Override
    public int interact(Personnage player, int again) {
        return super.interact(player, again);
    }
}
