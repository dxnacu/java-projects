package Droids;

public class Honest extends Droid {
    public Honest(String name, int health, int damage, int energy) {
        super(name, health, damage, energy);
    }

    public int counterAttack(int damageReceived) {
        this.health -= 10;
        consumeEnergy();
        return (int)(damageReceived * 0.5);
    }

    @Override
    public boolean isHonest(){
        return true;
    }

    @Override
    public String toString() {
        return name + " type: " + "Honest" +
                "    health: " + health +
                "    attack: " + attack +
                '\n';
    }
}
