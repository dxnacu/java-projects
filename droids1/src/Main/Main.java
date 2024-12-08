package Main;

import Battle.Battle;
import Team.Team;
import Battle.Battle1v1;
import Utils.DroidManager;
import Utils.InOut;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Battle currentBattle;

    public static void main(String[] args){
        InOut inout = new InOut();
        DroidManager droidManager = new DroidManager();
        Scanner scanner = new Scanner(System.in);

        while(true){
            inout.displayMenu();
            switch (inout.inputMenuChoice(scanner)){
                case 0:
                    droidManager.preparedDroids();
                    break;
                case 1:
                    inout.printAvailableDroids();
                    System.out.println(" ");
                    droidManager.createNewDroid(inout.inputDroid());
                    break;
                case 2:
                    inout.showCreatedDroids(droidManager);
                    break;
                case 3:
                    Team player1 = new Team();
                    Team player2 = new Team();
                    droidManager.chooseOpponents(player1,player2,inout.enterDroidsFor1v1(scanner));
                    Battle1v1 battle1v1 = new Battle1v1(player1,player2);
                    battle1v1.start();
                    break;
                case 4:
                    if(!droidManager.hasCreatedDroids()){
                        break;
                    }
                    droidManager.reviveDroids();
                    Team team1 = new Team(new ArrayList<>());
                    Team team2 = new Team(new ArrayList<>());
                    droidManager.createTeam(team1, inout.enterTeam(scanner));
                    droidManager.createTeam(team2, inout.enterTeam(scanner));
                    currentBattle = new Battle(team1,team2);
                    currentBattle.start();
                    break;
                case 5:
                    if (currentBattle != null) {
                        currentBattle.saveBattleToFile("battleLog.txt");
                    }
                    break;
                case 6:
                    currentBattle.loadBattleFromFile("battleLog.txt");
                    break;
                case 7:
                    System.out.println("Game's closed.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option choice. Try again.\n");
            }
        }
    }
}