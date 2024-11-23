public class Arena {
    private Player playerA;
    private Player playerB;
    private Dice dice;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = new Dice();
    }

    public void startFight() {
        System.out.println("Fight begins!");

        while (playerA.isAlive() && playerB.isAlive()) {
            if (playerA.getHealth() <= playerB.getHealth()) {
                executeTurn(playerA, playerB);
            } else {
                executeTurn(playerB, playerA);
            }
        }

        System.out.println("Fight Over!");
        if (playerA.isAlive()) {
            System.out.println("Player A Wins!");
        } else {
            System.out.println("Player B Wins!");
        }
    }

    private void executeTurn(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defenseRoll = dice.roll();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseDamage = defender.getStrength() * defenseRoll;

        int netDamage = Math.max(0, attackDamage - defenseDamage);
        defender.reduceHealth(netDamage);

        System.out.printf("%s attacks %s: Attack Roll = %d, Defense Roll = %d, Damage = %d%n",
                attacker, defender, attackRoll, defenseRoll, netDamage);
        System.out.printf("%s's health: %d%n", defender, defender.getHealth());
    }
}
