package menu.command;

import model.PassengerTrain;
import model.Wagon;
import model.CompartmentWagon;
import model.PassengerWagon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoadTrainsFromFile implements Command {
    private final List<PassengerTrain> trains;

    public LoadTrainsFromFile(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        String filePath = "C:\\Users\\Дана\\IdeaProjects\\lr_6\\trains.txt";
        trains.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            PassengerTrain currentTrain = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Train:")) {
                    int trainNumber = Integer.parseInt(line.split(":")[1].trim());
                    currentTrain = new PassengerTrain(trainNumber);
                    trains.add(currentTrain);
                    System.out.println("Створено потяг з номером: " + trainNumber);
                } else if (currentTrain != null) {
                    try {
                        String[] parts = line.split(",");
                        int passengerCount = Integer.parseInt(parts[1].trim());
                        int baggageCount = Integer.parseInt(parts[2].trim());

                        Wagon wagon;
                        if (parts[0].equals("CompartmentWagon")) {
                            wagon = new CompartmentWagon(passengerCount, baggageCount);
                        } else if (parts[0].equals("PassengerWagon")) {
                            wagon = new PassengerWagon(passengerCount, baggageCount);
                        } else {
                            throw new IllegalArgumentException("Невідомий тип вагона: " + parts[0]);
                        }

                        currentTrain.addWagon(wagon);
                        System.out.println("Додано вагон: " + wagon.toString());
                    } catch (NumberFormatException e) {
                        System.out.println("Помилка форматування чисел у рядку: " + line);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                }
            }

            System.out.println("Дані про потяги завантажено з файлу.");
            displayLoadedTrains();
        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    private void displayLoadedTrains() {
        if (trains.isEmpty()) {
            System.out.println("Немає завантажених потягів.");
        } else {
            for (PassengerTrain train : trains) {
                System.out.println("Потяг №" + train.getTrainNumber() + ":");
                for (Wagon wagon : train.getWagons()) {
                    wagon.displayInfo();
                }
                System.out.println();
            }
        }
    }

    @Override
    public String getName() {
        return "Завантажити потяги з файлу";
    }
}
