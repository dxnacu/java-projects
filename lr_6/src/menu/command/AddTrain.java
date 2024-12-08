package menu.command;

import model.PassengerTrain;

import java.util.List;
import java.util.Scanner;

public class AddTrain implements Command {
    private List<PassengerTrain> trains;

    public AddTrain(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер потяга: ");
        int trainNumber = scanner.nextInt();

        PassengerTrain newTrain = new PassengerTrain(trainNumber);
        trains.add(newTrain);
        System.out.println("Потяг додано: номер " + trainNumber);
    }

    @Override
    public String getName() {
        return "Додати потяг";
    }
}
