public class ChoiceClass {
    protected String storyText;
    private String choice1text, choice2text, choice3text;

    public  ChoiceClass() {}

    public void Attack(){}
    public ChoiceClass(String storyText,  String choice1text, String choice2text, String choice3text) {
        this.storyText = storyText;
        this.choice1text = choice1text;
        this.choice2text = choice2text;
        this.choice3text = choice3text;
        Main.getDiceButton().setEnabled(false);
    }

    public ChoiceClass(String storyText) {
        this.storyText = storyText;
    }

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public void setChoice1text(String choice1text) {
        this.choice1text = choice1text;
    }
    public void setChoice2text(String choice2text) {
        this.choice2text = choice2text;
    }
    public void setChoice3text(String choice3text) {
        this.choice3text = choice3text;
    }
    public String getChoice1text() {
        return choice1text;
    }
    public String getChoice2text() {
        return choice2text;
    }
    public String getChoice3text() {
        return choice3text;
    }

}
