package Board;

abstract class Bonus implements Box{
    protected String name;
    protected int position;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String toString(){
        return "Box number: " + position + ", it have: " + name;
    }
}
