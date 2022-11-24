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
        System.out.println("You met a Goblin!\nHe has " + getEnemyAttack() + " attack power and " + getEnemyHealth() + " health points.");
        while (getEnemyHealth()>0&&player.getHealthPoints()>0){
            setEnemyHealth(getEnemyHealth()-player.getAttackPower());
            player.setHealthPoints(player.getHealthPoints()-getEnemyAttack());
        }
        System.out.println("After fight:\nGoblin have: " + getEnemyHealth() + "health points. You have: " + player.getHealthPoints() + " health points.");
    }
}
