package Utils;

import Droids.*;
import Team.Team;
import java.util.List;
import java.util.Scanner;

import java.util.List;
import java.util.Scanner;

public class InOut {
    public static final String RESET = "\u001B[0m";
    public static final String LIGHT_RED = "\u001B[91m";    // light red for errors
    public static final String LIGHT_GREEN = "\u001B[92m";  // light green for success
    public static final String PURPLE = "\u001B[95m";       // purple for properties
    public static final String BLUE = "\u001B[94m";         // soft blue for menu
    public static final String YELLOW = "\u001B[93m";       // yellow for attacks

    public void displayMenu() {
        System.out.println("=========================");
        System.out.println(BLUE + "        Menu: " + RESET);
        System.out.println(BLUE + "1. Create droid " +
                "\n2. Show list of droids " +
                "\n3. 1v1 battle " +
                "\n4. Team battle " +
                "\n5. Save battle into file " +
                "\n6. Recent saved battle " +
                "\n7. Exit." + RESET);
        System.out.println("=========================");
        System.out.print(YELLOW + "Enter your choice: " + RESET);
    }

    public int inputMenuChoice(Scanner scanner) {
        int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice > 7 || choice < 0) {
            System.out.println(LIGHT_RED + "Please, enter positive integer (from 1 to 7)" + RESET);
            choice = scanner.nextInt();
        }

        return choice;
    }

    public String[] inputDroid() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nCreate new droid (for example, 'Fearless John'): ");
        String input = scanner.nextLine();
        String[] parts;

        while (true) {
            parts = input.split(" ", 2);
            if (parts.length == 2) {
                System.out.println(LIGHT_RED + "Error occurred" + RESET);
                return parts;
            }
            System.out.println(LIGHT_RED + "Error occurred. Try again:" + RESET);
        }
    }

    public void showCreatedDroids(DroidManager list) {
        List<Droid> droids = list.getCreatedDroids();

        System.out.println("=========================");
        if (droids.isEmpty()) {
            System.out.println("No created droids\n");
        } else {
            for (Droid item : droids) {
                System.out.print(item);
            }
        }
        System.out.println("=========================");
    }

    public void printAvailableDroids() {
        System.out.println(PURPLE + "Fearless (health: 100, attack: 30)\n" +
                "Honest (health: 100, attack: 20)\n" +
                "Intelligent (health: 100, attack: 20)\n" +
                "Selfless (health: 100, attack: 15)\n" +
                "Kind (health: 100, attack: 15)\n" + RESET);
    }

    public String[] enterTeam(Scanner scanner) {
        System.out.println("\n=========================");
        System.out.println("Add droids to the team:");
        System.out.println("=========================");
        return scanner.nextLine().split(",");
    }

    public void attack(Droid attacker, Droid target) {
        System.out.println(YELLOW + "=========================");
        System.out.println(attacker.getName() + " attacks " + target.getName());
        System.out.println("=========================" + RESET);
    }

    public void defeated(Droid weakest) {
        System.out.println(LIGHT_RED + "=========================");
        System.out.println(weakest.getName() + " is defeated");
        System.out.println("=========================" + RESET);
    }

    public void counterAttack(Droid target, Droid attacker) {
        System.out.println(PURPLE + "=========================");
        System.out.println(target.getName() + " used counter attack on " + attacker.getName());
        System.out.println("=========================" + RESET);
    }

    public void healing(Droid selfless, Droid weakest) {
        System.out.println(PURPLE + "=========================");
        System.out.println(selfless.getName() + " healed " + weakest.getName());
        System.out.println("=========================" + RESET);
    }

    public void healedHimself(Droid self) {
        System.out.println(PURPLE + "=========================");
        System.out.println(self.getName() + " healed themselves");
        System.out.println("=========================" + RESET);
    }

    public void boostedAttack(Droid fearless, Droid enemy) {
        System.out.println(PURPLE + "=========================");
        System.out.println(fearless.getName() + " used boosted attack on " + enemy.getName());
        System.out.println("=========================" + RESET);
    }

    public void showBattleResult(Team team1) {
        System.out.println(LIGHT_GREEN + "=========================");
        if (team1.hasAliveDroids()) {
            System.out.println("Team 1 won!!!");
        } else {
            System.out.println("Team 2 won!!!");
        }
        System.out.println("=========================" + RESET);
    }

    public void showBattle1v1Result(Team team1, Team team2){
        System.out.println(LIGHT_GREEN + "=========================");
        if (team1.hasAliveDroids()) {
            System.out.println(team1.getDroids().get(0).getName() + " won!!!");
        } else {
            System.out.println(team2.getDroids().get(0).getName() + " won!!!");
        }
        System.out.println("=========================" + RESET);
    }

    public String[] enterDroidsFor1v1(Scanner scanner) {
        System.out.println("\n=========================");
        System.out.println("Choose droids for 1v1 battle:");
        System.out.println("=========================");
        return scanner.nextLine().split(",");
    }
}

////    void saveBattleLog(Battle battle)
////    void loadAndReplayBattle()
//}
