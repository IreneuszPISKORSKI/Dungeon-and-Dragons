package Board;

public class EnemyDragon extends Enemy{

    public EnemyDragon(int position) {
        super(position);
        setName("Dragon");
    }
    @Override
    public void interact() {
        System.out.println("I'm Dragon!");
    }
}
