package Battle;

import Droids.*;
import Team.Team;
import Utils.InOut;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.Math.random;

public class Battle {
    protected Team team1;
    protected Team team2;
    protected boolean turn;
    protected List<String> battleLog;

    public Battle(Team team1,Team team2){
        this.team1 = team1;
        this.team2 = team2;
        this.turn = true;
        this.battleLog = new ArrayList<>();
    }

    private void logEvent(String event) {
        battleLog.add(event);
    }

    public void start(){
        InOut inout = new InOut();

        int random = (int)((random() * 2) + 1);
        if(random == 1){
            turn = false;
            executeTurn(team1,team2);
        } else {
            executeTurn(team2,team1);
        }

        while(team1.hasAliveDroids() && team2.hasAliveDroids()){
            if(turn){
                executeTurn(team1,team2);
            } else{
                executeTurn(team2,team1);
            }
            turn = !turn;
        }
        inout.showBattleResult(team1);
        logEvent("Battle ended. " + (team1.hasAliveDroids() ? "Team 1 won!" : "Team 2 won!"));
    }

    public void executeTurn(Team teamAttacker, Team teamTarget){
        int random = (int)((random() * 2) + 1);
        if(random == 1){
            makeAttack(teamAttacker, teamTarget);
        } else {
            useAbility(teamAttacker, teamTarget);
        }
        teamAttacker.removeDeadDroids();
        teamTarget.removeDeadDroids();
    }

    public void makeAttack(Team teamAttacker, Team teamTarget){
        InOut output = new InOut();

        Droid attacker = teamAttacker.getRandomAliveDroid();
        if (attacker == null) return;

        Droid weakest = teamTarget.findWeakestDroid();
        if (weakest == null) return;

        int damage = attacker.getAttack();

        if(weakest.isHonest()){
            if(weakest.hasEnoughEnergy()){
                attacker.takeDamage(((Honest) weakest).counterAttack(damage));
                output.counterAttack(weakest,attacker);
                logEvent(weakest.getName() + " used counter attack on " + attacker.getName());
            } else{
                weakest.takeDamage(damage);
                output.attack(attacker,weakest);
                logEvent(attacker.getName() + " attacks " + weakest.getName());
            }
        } else if(weakest.isIntelligent()){
            if(weakest.hasEnoughEnergy()){
                ((Intelligent) weakest).attemptEvade(damage);
            }
        } else{
            weakest.takeDamage(damage);
            output.attack(attacker,weakest);
            logEvent(attacker.getName() + " attacks " + weakest.getName());
        }
        if(!weakest.isAlive()){
            teamTarget.removeDroid(weakest);
            output.defeated(weakest);
            logEvent(weakest.getName() + " is defeated");
        }
    }

    public void useAbility(Team team, Team enemy){
        InOut output = new InOut();
        Droid weakest = team.findWeakestDroid();
        Droid weakestEnemy = enemy.findWeakestDroid();

        if(team.hasDroidOfType(Selfless.class)){
            Selfless selfless = (Selfless)team.getDroidOfType(Selfless.class);
            if(selfless.hasEnoughHealth() && !(weakest.isSelfless()) && weakest.getHealth() < 100){
                weakest.heal(selfless.shareHealth());
                if(weakest.getHealth() > 100){
                    weakest.setHealth(100);
                }
                output.healing(selfless,weakest);
                logEvent(selfless.getName() + " healed " + weakest.getName());
            } else {
                makeAttack(team,enemy);
            }
        } else if(team.hasDroidOfType(Fearless.class)){
            Fearless fearless = (Fearless)team.getDroidOfType(Fearless.class);
            if(fearless.hasEnoughEnergy()){
                weakestEnemy.takeDamage(fearless.boostAttack());
                output.boostedAttack(fearless,weakestEnemy);
                logEvent(fearless.getName() + " used boosted attack on " + weakestEnemy.getName());
            } else {
                makeAttack(team,enemy);
            }
        } else {
            makeAttack(team,enemy);
        }
    }

    public void saveBattleToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String log : battleLog) {
                writer.write(log);
                writer.newLine();
            }
            System.out.println("Battle saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving battle: " + e.getMessage());
        }
    }

    public void loadBattleFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading battle: " + e.getMessage());
        }
    }
}
