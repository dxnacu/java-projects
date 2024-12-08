package model;

public class PassengerWagon extends Wagon {

    public PassengerWagon(int passengerCount, int baggageCount) {
        super(passengerCount, baggageCount, 1); // Рівень комфорту для пасажирського вагона = 1
    }

    @Override
    public void displayInfo() {
        System.out.println("Пасажирський вагон - Пасажири: " + getPassengerCount() +
                ", Багаж: " + getBaggageCount() + ", Рівень комфорту: " + getComfortLevel());
    }

    @Override
    public String toString() {
        return "PassengerWagon," + getPassengerCount() + "," + getBaggageCount();
    }
}
