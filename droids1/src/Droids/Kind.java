package Droids;

public class Kind extends Droid {
    public Kind(String name, int health, int damage, int energy) {
        super(name, health, damage, energy);
    }

    @Override
    public String toString() {
        return name + " type: " + "Kind" +
                "    health: " + health +
                "    attack: " + attack +
                '\n';
    }
}
