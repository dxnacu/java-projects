package Droids;

import static java.lang.Math.random;

public class Intelligent extends Droid {
    public Intelligent(String name, int health, int damage, int energy) {
        super(name, health, damage, energy);
    }

    public void attemptEvade(int damage) {
        double random = random();
        if(random >= 0.3){
            takeDamage(damage);
            System.out.println(name + " didn't evade attack");
        } else{
            System.out.println(name + " evaded attack");
        }
        consumeEnergy();
    }

    @Override
    public boolean isIntelligent(){
        return true;
    }

    @Override
    public String toString() {
        return name + " type: " + "Intelligent" +
                " health: " + health +
                ", attack: " + attack +
                '\n';
    }
}
