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
    public void interact(Personnage player) {
        System.out.println("You met a Mage!\nHe has " + getEnemyAttack() + " attack power and " + getEnemyHealth() + " health points.");
        super.interact(player);
        System.out.println("After fight:\nMage have: " + getEnemyHealth() + " health points. You have: " + (player.getHealthPoints() + player.getDefense().getDefence()) + " health points.");
    }
}
