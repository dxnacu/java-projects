package Utils;

import Droids.*;
import Team.Team;
import java.util.*;

public class DroidManager {
    private List<Droid> createdDroids;

    public DroidManager() {
        this.createdDroids = new ArrayList<>();
    }

    public List<Droid> getCreatedDroids(){
        return createdDroids;
    }

    public void setCreatedDroids(List<Droid> createdDroids) {
        this.createdDroids = createdDroids;
    }

    public void createNewDroid(String[] parts) {
        Droid newDroid = null;
        String type = parts[0];
        String name = parts[1];

        switch (type.toLowerCase()) {
            case "fearless":
                newDroid = new Fearless(name,100,30,100);
                break;
            case "honest":
                newDroid = new Honest(name,100,20,100);
                break;
            case "intelligent":
                newDroid = new Intelligent(name,100,20,100);
                break;
            case "selfless":
                newDroid = new Selfless(name, 100, 15,100);
                break;
            case "kind":
                newDroid = new Kind(name,100,15,100);
                break;
            default:
                System.out.println("The type doesn't exist!");
                return;
        }
        createdDroids.add(newDroid);
    }

    public boolean hasCreatedDroids(){
        if(createdDroids.isEmpty()){
            System.out.println("No created droids.");
            return false;
        }
        return true;
    }

    public void createTeam(Team team, String[] names) {
        for (String name : names) {
            name = name.trim();
            boolean droidFound = false;

            for (Droid droid : createdDroids) {
                if (droid.getName().equalsIgnoreCase(name)) {
                    team.addDroid(droid);
                    droidFound = true;
                    break;
                }
            }

            if (!droidFound) {
                System.out.println("Droid with name '" + name + "' not found.");
            }
        }
    }

    public void chooseOpponents(Team op1, Team op2, String[] droids){
        int i = 0;
        for (String name : droids) {
            name = name.trim();
            boolean droidFound = false;

            for (Droid droid : createdDroids) {
                if (droid.getName().equalsIgnoreCase(name)) {
                    if(i == 0){
                        op1.addDroid(droid);
                    } else {
                        op2.addDroid(droid);
                    }
                    droidFound = true;
                    i++;
                    break;
                }
            }

            if (!droidFound) {
                System.out.println("Droid with name '" + name + "' not found.");
            }
        }
    }


    public void reviveDroids(){
        for(Droid droid: createdDroids){
            droid.setHealth(100);
            droid.setEnergy(100);
        }
    }

    public void preparedDroids(){
        List<Droid> list = new ArrayList<>();
        list.add(new Fearless("Four",100,30,100));
        list.add(new Honest("Helen",100,20,100));
        list.add(new Intelligent("Ian",100,20,100));
        list.add(new Selfless("Sally", 100, 15,100));
        list.add(new Kind("Kristina",100,18,100));
        list.add(new Fearless("Tris",100,30,100));
        list.add(new Honest("Oleh",100,20,100));
        list.add(new Intelligent("Igor",100,20,100));
        list.add(new Selfless("Sandra", 100, 15,100));
        list.add(new Kind("Ken",100,18,100));
        setCreatedDroids(list);
    }
}
