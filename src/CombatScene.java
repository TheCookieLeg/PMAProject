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
        this.enemyHealth = enemyHealth;
        this.enemyStrength = enemyStrength;
        this.nextScene = nextScene;
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
            combatText = "<html> <div style='width:500px;'> " + enemyName + " hits you, dealing " + damage + " damage.</div> </html>";
        }
        else if (playerSuccesses > enemySuccesses) {
            damage = playerSuccesses - enemySuccesses;
            enemyHealth -= damage;
            combatText = "<html> <div style='width:500px;'>You hit " + enemyName + ", dealing " + damage + " damage.</div> </html>";
        }
        else {
            enemyHealth -= 1;
            Player.takeDamage(1);
            combatText = "<html> <div style='width:500px;'>Both you and " + enemyName + " get a hit in, and you both take 1 damage. </div> </html>";
        }

        Main.frame.enemyStats.setText("Name: " + this.enemyName + "\nHealth: " + this.enemyHealth + "\nStrength: " + this.enemyStrength);
        Main.frame.playerStatsField.setText("Name: Larry the detective" + "\nHealth: " + Player.getHealth() + "\nStrength: " + Player.getStrength());
        Main.frame.storyLabel.setText(combatText);

        if(Player.getHealth() <= 0){

            Main.getCurrentScene().setChoice1text("Quit.. Like a loser");
            Main.getCurrentScene().setChoice2text("Quit.. Like a hero");
            Main.getCurrentScene().setChoice3text("Quit.. Like an average person");
            Main.UpdateText();
            Main.frame.storyLabel.setText("You died... Loser. Do you want to play again?");
            Main.setChoiceOne(-1);
            Main.setChoiceTwo(-1);
            Main.setChoiceThree(-1);
            Main.getDiceButton().setEnabled(false);
            Main.getChoiceOne().setEnabled(true);
            Main.getChoiceTwo().setEnabled(true);
            Main.getChoiceThree().setEnabled(true);
        }
        else if (enemyHealth <= 0) {
            Main.setCurrentScene(nextScene);
            Main.frame.enemyStats.setText("");
            Player.restoreHealth();
            //Main.frame.playerStatsField.setText("Name: Larry the detective" + "\nHealth: " + Player.getHealth() + "\nStrength: " + Player.getStrength()+"\n\nInventory:");
            Main.updatePlayerText();
            Main.FinishCombatScene();
            Main.getDiceButton().setEnabled(false);
        }

    }

    public void InitiateCombat()
    {
        Main.getChoiceOne().setEnabled(false);
        Main.getChoiceTwo().setEnabled(false);
        Main.getChoiceThree().setEnabled(false);
        Main.getDiceButton().setEnabled(true);
        Main.setCurrentCombatScene(this);
        Main.frame.enemyStats.setText("Name: " + this.enemyName + "\nHealth: " + this.enemyHealth + "\nStrength: " + this.enemyStrength);
    }

    //public void setStoryText(String storyText) {this.storyText = storyText;}
}
