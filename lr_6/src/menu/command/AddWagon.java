package menu.command;

import model.PassengerTrain;
import model.CompartmentWagon;
import model.PassengerWagon;
import model.Wagon;

import java.util.List;
import java.util.Scanner;

public class AddWagon implements Command {
    private List<PassengerTrain> trains;
    private Scanner scanner = new Scanner(System.in);

    public AddWagon(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        if (trains.isEmpty()) {
            System.out.println("Немає доступних потягів для додавання вагонів.");
            return;
        }

        System.out.println("Список потягів:");
        for (PassengerTrain train : trains) {
            System.out.println("Потяг №" + train.getTrainNumber());
        }

        System.out.print("Введіть номер потяга для додавання вагона: ");
        int trainNumber = scanner.nextInt();
        PassengerTrain selectedTrain = findTrainByNumber(trainNumber);
        if (selectedTrain == null) {
            System.out.println("Невірний номер потяга.");
            return;
        }

        System.out.print("Введіть кількість пасажирів: ");
        int passengers = scanner.nextInt();
        System.out.print("Введіть кількість багажу: ");
        int baggage = scanner.nextInt();
        System.out.println("Оберіть тип вагона (1 - Пасажирський, 2 - Купейний): ");
        int type = scanner.nextInt();

        Wagon wagon;
        if (type == 1) {
            wagon = new PassengerWagon(passengers, baggage);
        } else if (type == 2) {
            wagon = new CompartmentWagon(passengers, baggage);
        } else {
            System.out.println("Невірний тип вагона.");
            return;
        }

        selectedTrain.addWagon(wagon);
        System.out.println("Вагон додано до потяга №" + trainNumber);
    }

    private PassengerTrain findTrainByNumber(int trainNumber) {
        for (PassengerTrain train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return "Додати вагон";
    }
}
