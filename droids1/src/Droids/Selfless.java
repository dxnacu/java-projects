package Droids;

public class Selfless extends Droid {
    public Selfless(String name, int health, int damage, int energy) {
        super(name, health, damage, energy);
    }

    public boolean hasEnoughHealth(){
        return health >= health * 0.5;
    }

    public int shareHealth(){
        int sharing = (int)(health * 0.2);
        this.health -= sharing;
        consumeEnergy();
        return sharing;
    }

    @Override
    public boolean isSelfless(){
        return true;
    }

    @Override
    public String toString() {
        return name + " type: " + "Selfless" +
                "    health: " + health +
                "    attack: " + attack +
                '\n';
    }
}
