package Board;

public class EnemyGoblin implements Box{
    @Override
    public void interact() {
        System.out.println("Im goblin, fear me!");
    }
    @Override
    public String getName() {
        return "Goblin";
    }



    @Override
    public String toString() {
        return "name: " + this.getName();
    }
}
