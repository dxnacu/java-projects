package Droids;

public class Fearless extends Droid {
    public Fearless(String name, int health, int damage, int energy) {
        super(name, health, damage, energy);
    }

    public boolean hasEnoughEnergy(){
        return this.energy >= 40;
    }

    public void consumeEnergy(){
        this.energy -= 40;
    }

    public int boostAttack(){
        consumeEnergy();
        return this.attack * 2;
    }

    @Override
    public boolean isFearless(){
        return true;
    }

    @Override
    public String toString() {
        return name + " type: " + "Fearless" +
                "    health: " + health +
                "    attack: " + attack +
                "\n";
    }
}
