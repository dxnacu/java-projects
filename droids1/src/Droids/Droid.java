package Droids;

public class Droid {
    protected String name;
    protected int health;
    protected int attack;
    protected int energy;

    public Droid(String name, int health, int attack, int energy){
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.energy = energy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getEnergy() {
        return energy;
    }

    public void takeDamage(int amount){
        this.health -= amount;
    }

    public boolean isAlive(){
        return this.health > 0;
    }

    public void consumeEnergy(){
        this.energy -= 25;
    }

    public boolean hasEnoughEnergy(){
        return energy >= 25;
    }

    public void heal(int amount){
        this.health += amount;
    }

    public boolean isFearless(){
        return false;
    }

    public boolean isSelfless(){
        return false;
    }

    public boolean isHonest(){
        return false;
    }

    public boolean isIntelligent(){
        return false;
    }
}
