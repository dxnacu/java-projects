package model;

public class Wagon {
    private int passengerCount;
    private int baggageCount;
    private int comfortLevel;

    public Wagon(int passengerCount, int baggageCount, int comfortLevel) {
        this.passengerCount = passengerCount;
        this.baggageCount = baggageCount;
        this.comfortLevel = comfortLevel;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getBaggageCount() {
        return baggageCount;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public void displayInfo() {
        System.out.println("Вагон - Пасажири: " + passengerCount + ", Багаж: " + baggageCount + ", Рівень комфорту: " + comfortLevel);
    }
}
