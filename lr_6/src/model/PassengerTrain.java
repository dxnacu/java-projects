package model;

import java.util.ArrayList;
import java.util.List;

public class PassengerTrain {
    private int trainNumber;
    private List<Wagon> wagons;

    public PassengerTrain(int trainNumber) {
        this.trainNumber = trainNumber;
        this.wagons = new ArrayList<>();
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void addWagon(Wagon wagon) {
        wagons.add(wagon);
    }

    public int calculateTotalPassengers() {
        int totalPassengers = 0;
        for (Wagon wagon : wagons) {
            totalPassengers += wagon.getPassengerCount();
        }
        return totalPassengers;
    }

    public void sortWagonsByComfort() {
        wagons.sort((w1, w2) -> Integer.compare(w2.getComfortLevel(), w1.getComfortLevel()));
    }

    public void displayWagons() {
        if (wagons.isEmpty()) {
            System.out.println("Немає вагонів у цьому потязі.");
        } else {
            for (Wagon wagon : wagons) {
                wagon.displayInfo();
            }
        }
    }
}
