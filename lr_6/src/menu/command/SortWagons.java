package menu.command;

import model.PassengerTrain;
import java.util.List;
import java.util.Scanner;

public class SortWagons implements Command {
    private List<PassengerTrain> trains;

    public SortWagons(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        if (trains.isEmpty()) {
            System.out.println("Немає потягів для сортування.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть номер потяга для сортування за комфортом:");
        int trainNumber = scanner.nextInt();

        PassengerTrain selectedTrain = null;
        for (PassengerTrain train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                selectedTrain = train;
                break;
            }
        }

        if (selectedTrain != null) {
            selectedTrain.sortWagonsByComfort();
            System.out.println("Відсортовані вагони за рівнем комфорту:");
            selectedTrain.displayWagons();
        } else {
            System.out.println("Потяг з номером " + trainNumber + " не знайдено.");
        }
    }

    @Override
    public String getName() {
        return "Сортувати вагони за комфортом";
    }
}
