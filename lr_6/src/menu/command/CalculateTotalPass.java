package menu.command;

import model.PassengerTrain;
import java.util.List;

public class CalculateTotalPass implements Command {
    private List<PassengerTrain> trains;

    public CalculateTotalPass(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        if (trains.isEmpty()) {
            System.out.println("Немає доступних потягів для підрахунку пасажирів.");
            return;
        }

        for (PassengerTrain train : trains) {
            int totalPassengers = train.calculateTotalPassengers();
            System.out.println("Потяг " + train.getTrainNumber() + ": загальна кількість пасажирів = " + totalPassengers);
        }
    }

    @Override
    public String getName() {
        return "Підрахувати загальну кількість пасажирів";
    }
}