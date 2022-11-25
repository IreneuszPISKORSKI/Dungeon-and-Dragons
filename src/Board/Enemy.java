package Board;

import Personnage.Personnage;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int choice;
        if (getEnemyHealth()<=0){
            System.out.println("Your enemy lies here. Dead. Killed by you. You murderer.");
        }else {
            System.out.println("You met a " + name + "!\nHe has " + getEnemyAttack() + " attack power and " + getEnemyHealth() + " health points.");
            while (getEnemyHealth()>0 && (player.getHealthPoints() + player.getDefense().getDefence())>0){
                System.out.println("What will you do?\n1 - fight | 0 - run");
                choice = scanner.nextInt();
                if (choice==1) {
                    setEnemyHealth(getEnemyHealth() - (player.getAttackPower() + player.getWeapon().getAttack()));
                    player.setHealthPoints(player.getHealthPoints() - getEnemyAttack());
                } else if (choice==0) {
                    int random = (int) (Math.random() * 6 + 1);
                    int goBack = player.getPlayerPosition() - random ;
                    if (goBack<0){goBack=0;}
                    player.setPlayerPosition(goBack);
                    System.out.println("You ran away and moved back " + random + " squares, you are now on square " + player.getPlayerPosition());
                    break;
                }else {
                    System.out.println("Wrong value, try again");
                }
                System.out.println("After fight:\n" + name + " have: " + getEnemyHealth() + " health points. You have: " + (player.getHealthPoints() + player.getDefense().getDefence()) + " health points.");
            }
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
