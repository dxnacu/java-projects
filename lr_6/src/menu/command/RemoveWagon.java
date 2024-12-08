package menu.command;

import model.PassengerTrain;
import model.Wagon;
import java.util.List;
import java.util.Scanner;

public class RemoveWagon implements Command {
    private List<PassengerTrain> trains;

    public RemoveWagon(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Список потягів:");
        for (int i = 0; i < trains.size(); i++) {
            System.out.println(i + 1 + ". Потяг №" + trains.get(i).getTrainNumber());
        }

        System.out.print("Введіть індекс потяга для видалення вагона: ");
        int trainIndex = scanner.nextInt() - 1;

        if (trainIndex >= 0 && trainIndex < trains.size()) {
            PassengerTrain selectedTrain = trains.get(trainIndex);

            System.out.println("Список вагонів потяга №" + selectedTrain.getTrainNumber() + ":");
            for (int i = 0; i < selectedTrain.getWagons().size(); i++) {
                Wagon wagon = selectedTrain.getWagons().get(i);
                System.out.println(i + 1 + ". " + "Вагон - Пасажири: " + wagon.getPassengerCount() + ", Багаж: " + wagon.getBaggageCount() + ", Рівень комфорту: " + wagon.getComfortLevel());
            }

            System.out.print("Введіть номер вагона для видалення: ");
            int wagonIndex = scanner.nextInt() - 1;

            if (wagonIndex >= 0 && wagonIndex < selectedTrain.getWagons().size()) {
                Wagon removedWagon = selectedTrain.getWagons().remove(wagonIndex);
                System.out.println("Вагон з пасажирами: " + removedWagon.getPassengerCount() + " успішно видалено.");
            } else {
                System.out.println("Невірний номер вагона.");
            }
        } else {
            System.out.println("Невірний номер потяга.");
        }
    }

    @Override
    public String getName() {
        return "Видалити вагон";
    }
}
