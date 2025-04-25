public class FrontOfTheHouse implements Room{

    public void PlayRoom(){
        Main.storyScenes.clear();
        Main.storyScenes.put("Start", new ChoiceClass("You are a detective sent to investigate a supposedly abandoned mansion. Your partner, Will, has traced multiple disappearances in the area to this very house. This evening, the two of you agreed to meet up here, and unravel whatever is behind the disappearances.",
                "","Continue",""));
        Main.storyScenes.put("Standing in front of mansion", new ChoiceClass("Standing in front of the mansion, a foreboding feeling overcomes you. But Will is already waiting for you inside, and if you do not figure out what is going on in there, it is likely that no one ever will.",
                "","Enter the mansion",""));
        Main.setCurrentScene(Main.storyScenes.get("Start"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}

        Main.RestartGame();
        StartRoom();
    }
    public void StartRoom(){
        if(Main.getCurrentScene() == Main.storyScenes.get("Start")) {
            Main.setChoiceOne(Main.storyScenes.get("Standing in front of mansion"));
            Main.setChoiceTwo(Main.storyScenes.get("Standing in front of mansion"));
            Main.setChoiceThree(Main.storyScenes.get("Standing in front of mansion"));


        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Standing in front of mansion")) {
            Main.setChoiceOne(1);
            Main.setChoiceTwo(1);
            Main.setChoiceThree(1);
        }
    }
}
