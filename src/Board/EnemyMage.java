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
        while (getEnemyHealth()>0&&player.getHealthPoints()>0){
            setEnemyHealth(getEnemyHealth()-player.getAttackPower());
            player.setHealthPoints(player.getHealthPoints()-getEnemyAttack());
        }
        System.out.println("After fight:\nMage have: " + getEnemyHealth() + "health points. You have: " + player.getHealthPoints() + " health points.");
    }
}
