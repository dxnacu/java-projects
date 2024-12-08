package Team;

import Droids.Droid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.random;

public class Team {
    private List<Droid> droids;

    public Team(List<Droid> droids){
        this.droids = droids;
    }

    public Team(){
        this.droids = new ArrayList<>();
    }

    public void setDroids(List<Droid> droids) {
        this.droids = droids;
    }

    public List<Droid> getDroids() {
        return droids;
    }

    public void addDroid(Droid droid){
        droids.add(droid);
    }

    public void removeDroid(Droid droid){
        droids.remove(droid);
    }

    public void removeDeadDroids() {
        droids.removeIf(droid -> !droid.isAlive());
    }

    public boolean hasAliveDroids() {
        if(droids.isEmpty()) return false;
        for (Droid droid : droids) {
            if (droid.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDroidOfType(Class<? extends Droid> droidType) {
        for (Droid droid : droids) {
            if (droidType.isInstance(droid)) {
                return true;
            }
        }
        return false;
    }

    public Droid getDroidOfType(Class<? extends Droid> droidType) {
        for (Droid droid : droids) {
            if (droidType.isInstance(droid)) {
                return droid;
            }
        }
        return null;
    }

    public Droid getRandomAliveDroid() {
        List<Droid> aliveDroids = droids.stream()
                .filter(Droid::isAlive)
                .collect(Collectors.toList());
        if (aliveDroids.isEmpty()) return null;
        int randomIndex = (int) (random() * aliveDroids.size());
        return aliveDroids.get(randomIndex);
    }

    public Droid findWeakestDroid() {
        Droid weakest = null;
        for (Droid droid : droids) {
            if (droid.isAlive() && (weakest == null || droid.getHealth() < weakest.getHealth())) {
                weakest = droid;
            }
        }
        return weakest;
    }
}
