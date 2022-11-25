package Board;

import Personnage.Personnage;

abstract class Enemy implements Box{
    private int position;
    private String name;
    private int enemyAttack;
    private int enemyHealth;

    Enemy(int position){
        setPosition(position);
    }

    @Override
    public void interact(Personnage player) {
        while (getEnemyHealth()>0 && (player.getHealthPoints() + player.getDefense().getDefence())>0){
            setEnemyHealth(getEnemyHealth()-(player.getAttackPower()+player.getWeapon().getAttack()));
            player.setHealthPoints(player.getHealthPoints()-getEnemyAttack());
        }
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnemyAttack() {
        return enemyAttack;
    }

    public void setEnemyAttack(int enemyAttack) {
        this.enemyAttack = enemyAttack;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public String toString(){
        return "Box number: " + position + ", it have: " + name;
    }
}
