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
        System.out.println("You met a Dragon!\nHe has " + getEnemyAttack() + " attack power and " + getEnemyHealth() + " health points.");
        super.interact(player);
        System.out.println("After fight:\nDragon have: " + getEnemyHealth() + " health points. You have: " + (player.getHealthPoints() + player.getDefense().getDefence()) + " health points.");
    }
}
