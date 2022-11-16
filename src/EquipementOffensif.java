public class EquipementOffensif {
    private String type;
    private int attack;
    private String name;
    public void setAsSword() {
        type = "sword";
        attack = 5;
        name = "Short sword";
    }

    public void setAsSpell() {
        type = "Magic attack";
        attack = 8;
        name = "Fireball";
    }

    @Override
    public String toString() {
        return name + " (+" + attack + " att)";
    }
}
