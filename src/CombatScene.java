import java.io.InvalidClassException;

public class CombatScene extends ChoiceClass {

    private int enemyHealth;
    private int enemyStrength;
    int damage;
    public CombatScene(String combatText, int enemyHealth, int enemyStrength) {
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
            //Have a method here or in Player class for taking damage
            //Write to the player how much damage they took
        }
        if (playerSuccesses > enemySuccesses) {
            damage = playerSuccesses - enemySuccesses;
            enemyHealth -= damage;
            //Write to the player how much damage they dealt
        }
        else {
            damage = 1;
            enemyHealth -= damage;
        }
    }
}
