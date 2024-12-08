package menu;

import menu.command.*;
import model.PassengerTrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final List<Command> commands = new ArrayList<>();
    private final List<PassengerTrain> trains = new ArrayList<>();

    public Menu() {
        initializeCommands();
    }

    private void initializeCommands() {
        commands.add(new AddTrain(trains));
        commands.add(new AddWagon(trains));
        commands.add(new CalculateTotalPass(trains));
        commands.add(new FindWagons(trains));
        commands.add(new SortWagons(trains));
        commands.add(new SaveTrainsToFile(trains));
        commands.add(new LoadTrainsFromFile(trains));
        commands.add(new DeleteTrain(trains));
        commands.add(new RemoveWagon(trains));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();
            if (choice == 9)
                break;
            if (choice >= 0 && choice < commands.size()) {
                commands.get(choice).execute();
                if (choice == commands.size() - 1) break;
            } else {
                System.out.println("Неправильний вибір, спробуйте ще раз.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню:");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println(i + ". " + commands.get(i).getName());
        }
        System.out.println("9. Вихід");
    }
}