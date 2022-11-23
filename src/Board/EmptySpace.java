package Board;

public class EmptySpace extends Enemy{

    public EmptySpace(int position) {
        super(position);
        setName("0");
    }

    @Override
    public void interact() {
        System.out.println("Peace and quiet...");
    }
}
