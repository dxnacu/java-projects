package menu.command;

import model.PassengerTrain;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

public class DeleteTrain implements Command {
    private List<PassengerTrain> trains;

    public DeleteTrain(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Список потягів:");
        for (int i = 0; i < trains.size(); i++) {
            System.out.println((i + 1) + ". Потяг №" + trains.get(i).getTrainNumber());
        }

        System.out.print("Введіть номер потяга для видалення: ");
        int trainNumber = scanner.nextInt();

        Iterator<PassengerTrain> iterator = trains.iterator();
        boolean trainFound = false;

        while (iterator.hasNext()) {
            PassengerTrain train = iterator.next();
            if (train.getTrainNumber() == trainNumber) {
                iterator.remove();
                System.out.println("Потяг №" + trainNumber + " успішно видалено.");
                trainFound = true;
                break;
            }
        }

        if (!trainFound) {
            System.out.println("Невірний номер потяга.");
        }
    }

    @Override
    public String getName() {
        return "Видалити потяг";
    }
}
