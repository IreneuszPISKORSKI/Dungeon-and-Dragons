package Board;

public class BoardBox {
    int position;
    String name;

    BoardBox(int position, String name){
        this.name = name;
        this.position = position;
    }

    public String toString(){
        return "Box number: " + position + ", it have: " + name;
    }
}
