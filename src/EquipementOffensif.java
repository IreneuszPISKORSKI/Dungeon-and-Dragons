public abstract class EquipementOffensif {
    private String type;
    private int attack;
    private String name;

    @Override
    public String toString() {return name + " (+" + attack + " att)";}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public int getAttack() {return attack;}

    public void setAttack(int attack) {this.attack = attack;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}
