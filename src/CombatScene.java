import java.awt.*;
import java.io.InvalidClassException;

public class CombatScene extends ChoiceClass {

    String combatText;
    String enemyName;
    private int enemyHealth;
    private int enemyStrength;

    private ChoiceClass nextScene;
    int damage;
    public CombatScene(String enemyName, String combatText, int enemyHealth, int enemyStrength, ChoiceClass nextScene) {
        this.enemyName = enemyName;
        super.storyText = combatText;
        Main.getDiceButton().setEnabled(true);
        this.enemyHealth = enemyHealth;
        this.enemyStrength = enemyStrength;
        this.nextScene = nextScene;

        Main.getChoiceOne().setEnabled(false);
        Main.getChoiceTwo().setEnabled(false);
        Main.getChoiceThree().setEnabled(false);
        Main.getCurrentScene().setChoice1text("Combat");
        Main.getCurrentScene().setChoice2text("Combat");
        Main.getCurrentScene().setChoice3text("Combat");
    }

    public void Attack() {
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


        if(Player.getHealth() <= 0){
            Main.getCurrentScene().setStoryText("You died... Loser. Do you want to play again?");
            Main.getCurrentScene().setChoice1text("Quit.. Like a loser");
            Main.getCurrentScene().setChoice2text("Play again");
            Main.getCurrentScene().setChoice3text("Come on... Play again");
            Main.setChoiceOne(-1);
            Main.setChoiceTwo(0);
            Main.setChoiceThree(0);
            Main.getDiceButton().setEnabled(false);
        }
        else if (enemyHealth <= 0) {
            Main.setCurrentScene(nextScene);
            Main.FinishCombatScene();
            Main.getDiceButton().setEnabled(false);
        }

    }
}
