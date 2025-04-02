import java.io.InvalidClassException;

public class CombatScene extends ChoiceClass {

    public CombatScene(String combatText) {
        super.storyText = combatText;
        Main.getDiceButton().setEnabled(true);


    }
}
