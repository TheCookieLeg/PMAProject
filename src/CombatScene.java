import java.io.InvalidClassException;

public class CombatScene extends ChoiceClass {

    String combatText;
    String enemyName;
    private int enemyHealth;
    private int enemyStrength;
    int damage;
    public CombatScene(String enemyName, String combatText, int enemyHealth, int enemyStrength) {
        this.enemyName = enemyName;
        super.storyText = combatText;
        Main.getDiceButton().setEnabled(true);
        this.enemyHealth = enemyHealth;
        this.enemyStrength = enemyStrength;
    }

    public void attack() {
        int playerSuccesses = Dice.Roll(Player.getStrength());
        int enemySuccesses = Dice.Roll(enemyStrength);

        if (enemySuccesses > playerSuccesses) {
            damage = enemySuccesses - playerSuccesses;
            Player.takeDamage(damage);
            combatText = "The " + enemyName + " hits you, dealing " + damage + " damage.";
        }
        else if (playerSuccesses > enemySuccesses) {
            damage = playerSuccesses - enemySuccesses;
            enemyHealth -= damage;
            combatText = "You hit the " + enemyName + ", dealing " + damage + " damage.";
        }
        else {
            enemyHealth -= 1;
            Player.takeDamage(1);
            combatText = "Both you and the " + enemyName + " get a hit in, and you both take 1 damage.";
        }
    }
}
