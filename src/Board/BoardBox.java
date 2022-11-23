package Board;

public class BoardBox {
    private int position;
    private String name;
    private Box have;

    BoardBox(int position, Box have){
        this.have = have;
        this.name = have.getName();
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Box getHave() {
        return have;
    }

    public void setHave(Box have) {
        this.have = have;
    }

    public String toString(){
        return "Box number: " + (position) + ", it have: " + name;
    }
}
