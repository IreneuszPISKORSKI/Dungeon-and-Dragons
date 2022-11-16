public class EquipementDefensif {

    private String type;
    private int defence;
    private String name;

    public void setAsShield() {
        type = "Shield";
        defence = 5;
        name = "Wood shield";
    }

    public void setAsPotion() {
        type = "Potion";
        defence = 2;
        name = "Health potion";
    }

    @Override
    public String toString() {
        return name + " (+" + defence + " def)";
    }
}
