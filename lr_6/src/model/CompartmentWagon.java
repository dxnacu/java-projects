package model;

public class CompartmentWagon extends Wagon {

    public CompartmentWagon(int passengerCount, int baggageCount) {
        super(passengerCount, baggageCount, 2);
    }

    @Override
    public void displayInfo() {
        System.out.println("Купейний вагон - Пасажири: " + getPassengerCount() +
                ", Багаж: " + getBaggageCount() + ", Рівень комфорту: " + getComfortLevel());
    }

    @Override
    public String toString() {
        return "CompartmentWagon," + getPassengerCount() + "," + getBaggageCount();
    }
}