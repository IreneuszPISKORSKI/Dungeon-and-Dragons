package Board;

abstract class Enemy implements Box{
    private int position;
    private String name;

    Enemy(int position){
        setPosition(position);
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

    public String toString(){
        return "Box number: " + (position) + ", it have: " + name;
    }
}
