public class ChoiceClass {
    private String storyText;
    private String choice1text, choice2text, choice3text;

    public ChoiceClass(String storyText,  String choice1text, String choice2text, String choice3text) {
        this.storyText = storyText;
        this.choice1text = choice1text;
        this.choice2text = choice2text;
        this.choice3text = choice3text;
    }

    public String getStoryText() {
        return storyText;
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
