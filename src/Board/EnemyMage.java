package Board;

public class EnemyMage implements Box {

    @Override
    public void interact() {
        System.out.println("I'm mighty mage!");
    }
    @Override
    public String getName() {
        return  "Mage";
    }
}
