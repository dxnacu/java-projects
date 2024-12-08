package Battle;

import Droids.*;
import Team.Team;
import Utils.InOut;

import static java.lang.Math.random;

public class Battle1v1 extends Battle{
    public Battle1v1(Team team1, Team team2) {
        super(team1, team2);
    }

    @Override
    public void start() {
        InOut out = new InOut();

        int random = (int) ((random() * 2) + 1);
        if (random == 1) {
            turn = false;
            executeTurn(team1, team2);
        } else {
            executeTurn(team2, team1);
        }

        while (team1.hasAliveDroids() && team2.hasAliveDroids()) {
            if (turn) {
                executeTurn(team1, team2);
            } else {
                executeTurn(team2, team1);
            }
            turn = !turn;
        }
        out.showBattle1v1Result(team1,team2);
    }

    @Override
    public void makeAttack(Team teamAttacker, Team teamTarget) {
        InOut output = new InOut();

        Droid attacker = teamAttacker.getDroids().get(0);
        Droid target = teamTarget.getDroids().get(0);

        if (attacker == null || target == null) return;

        int damage = attacker.getAttack();

        if (target.isHonest() && target.hasEnoughEnergy()) {
            attacker.takeDamage(((Honest) target).counterAttack(damage));
            output.counterAttack(target,attacker);
        } else if (target.isIntelligent() && target.hasEnoughEnergy()) {
            ((Intelligent) target).attemptEvade(damage);
        } else {
            target.takeDamage(damage);
            output.attack(attacker, target);
        }

        if (!target.isAlive()) {
            teamTarget.removeDroid(target);
            output.defeated(target);
        }
    }

    @Override
    public void useAbility(Team team, Team enemy) {
        InOut output = new InOut();
        Droid self = team.getDroids().get(0);
        Droid opponent = enemy.getDroids().get(0);

        if (self.isSelfless() && ((Selfless) self).hasEnoughHealth()) {
            self.heal(((Selfless) self).shareHealth());
            if(self.getHealth() > 100){
                self.setHealth(100);
            }
            output.healedHimself(self);
        } else if (self.isFearless() && ((Fearless) self).hasEnoughEnergy()) {
            opponent.takeDamage(((Fearless) self).boostAttack());
            output.boostedAttack(self,opponent);
        } else {
            makeAttack(team, enemy);
        }
    }
}
