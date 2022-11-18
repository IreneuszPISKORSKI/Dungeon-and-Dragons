package EquipmentDefensif;

public abstract class EquipementDefensif {
    private String type;
    private int defence;
    private String name;

    @Override
    public String toString() {return name + " (+" + defence + " def)";}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public int getDefence() {return defence;}

    public void setDefence(int defence) {this.defence = defence;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}
