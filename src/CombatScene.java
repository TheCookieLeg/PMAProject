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
            combatText = "<html> <div style='width:500px;'>The " + enemyName + " hits you, dealing " + damage + " damage.</div> </html>";
        }
        else if (playerSuccesses > enemySuccesses) {
            damage = playerSuccesses - enemySuccesses;
            enemyHealth -= damage;
            combatText = "<html> <div style='width:500px;'>You hit the " + enemyName + ", dealing " + damage + " damage.</div> </html>";
        }
        else {
            enemyHealth -= 1;
            Player.takeDamage(1);
            combatText = "<html> <div style='width:500px;'>Both you and the " + enemyName + " get a hit in, and you both take 1 damage. </div> </html>";
        }
        //Main.getCurrentScene().setStoryText(combatText);

        Main.frame.storyLabel.setText(combatText);
        if(Player.getHealth() <= 0){

            Main.getCurrentScene().setChoice1text("Quit.. Like a loser");
            Main.getCurrentScene().setChoice2text("Play again");
            Main.getCurrentScene().setChoice3text("Come on... Play again");
            Main.UpdateText();
            Main.frame.storyLabel.setText("You died... Loser. Do you want to play again?");
            Main.setChoiceOne(-1);
            Main.setChoiceTwo(0);
            Main.setChoiceThree(0);
            Main.getDiceButton().setEnabled(false);
            Main.getChoiceOne().setEnabled(true);
            Main.getChoiceTwo().setEnabled(true);
            Main.getChoiceThree().setEnabled(true);
        }
        else if (enemyHealth <= 0) {
            Main.setCurrentScene(nextScene);
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
    }

    //public void setStoryText(String storyText) {this.storyText = storyText;}
}
