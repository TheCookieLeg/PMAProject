public class Bathroom implements Room{
    public void PlayRoom(){
        Main.storyScenes.clear();
        Main.storyScenes.put("Entering bathroom", new ChoiceClass("You enter the bathroom. The noise you heard from outside the hallway faded as you entered, leaving the room silent. Seems you are starting to get delusional. Inside, there is a shower cabin, a sink beneath a huge mirror and a toilet.",
                "Explore the shower cabin","Explore the sink","Go back into the hallway"));
        Main.storyScenes.put("Exploring the shower", new ChoiceClass("You walk over to the shower cabin. As you get closer, you start to hear the strange sound again. It is coming from behind the shower curtain. Sounds kind of like crunching. Chewing?",
                "Pull the curtain away","Yell Howdy partner","Explore the sink instead (Pussy)"));
        Main.storyScenes.put("Yell", new ChoiceClass("You await an answer. It is silent for a moment, but then you get your answer as a person jumps out from behind the shower curtain, tackling you to the ground.",
                "KICK HIM","KICK HIM","KICK HIM"));
        Main.storyScenes.put("Opening the curtain", new ChoiceClass("You open the curtain. You see a cultist eating a burrito. A confused expression forms on his face when he sees you. You stare at each other for a few seconds. Then, the cultist jumps you, burrito in hand.",
                "KICK HIM","KICK HIM","KICK HIM"));
        Main.storyScenes.put("Exploring the sink", new ChoiceClass("You begin to search the sink and the area around it. You hear a voice. You look around to look for the source of the voice, but find nothing. Until you realize it is coming from the mirror above the sink.",
                "Dad?","Are you... me?","You are so ugly"));
        Main.storyScenes.put("Mirror talking", new ChoiceClass("Hey dumb-dumb, your reflection quips. Finally found your way home, it states. You asks what it means by 'home' as you have never been here, and is actually investigating a case. The reflection tells you you should be investigating how you got so stupid. You tell the reflection that's really hurtful. It says you clearly haven't been hurt enough, since you are weird enough to be talking to a mirror. You suppress a tear and turn away from the mirror. Behind you, you hear it thank you for preventing it from looking at your stupid face anymore.",
                "Run out in the hallway while crying","Tell the the reflection to fuck off and back off","Silently back away"));

        Main.setCurrentScene(Main.storyScenes.get("Entering bathroom"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}
    }
    public void StartRoom(){

        if(Main.getCurrentScene() == Main.storyScenes.get("Entering bathroom")) {
            Main.setChoiceOne(Main.storyScenes.get("Exploring the shower"));
            Main.setChoiceTwo(Main.storyScenes.get("Exploring the sink"));
            Main.setChoiceThree(4);
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Exploring the shower")) {
            Main.setChoiceOne(Main.storyScenes.get("Opening the curtain"));
            Main.setChoiceTwo(Main.storyScenes.get("Yell"));
            Main.setChoiceThree(Main.storyScenes.get("Exploring the sink"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Yell")) {
            // Combat scene -- Main.setChoiceOne(Main.storyScenes.get("Upstairs Hallway"));
            // Combat scene -- Main.setChoiceTwo(Main.storyScenes.get("Upstairs Hallway"));
            // Combat scene -- Main.setChoiceThree(Main.storyScenes.get("Upstairs Hallway"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Opening the curtain")) {
            // Combat scene -- Main.setChoiceOne(Main.storyScenes.get("Upstairs Hallway"));
            // Combat scene -- Main.setChoiceTwo(Main.storyScenes.get("Upstairs Hallway"));
            // Combat scene -- Main.setChoiceThree(Main.storyScenes.get("Upstairs Hallway"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Exploring the sink")) {
            Main.setChoiceOne(Main.storyScenes.get("Mirror talking"));
            Main.setChoiceTwo(Main.storyScenes.get("Mirror talking"));
            Main.setChoiceThree(Main.storyScenes.get("Mirror talking"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Mirror talking")) {
            Main.setChoiceOne(4);
            Main.setChoiceTwo(Main.storyScenes.get("Entering bathroom"));
            Main.setChoiceThree(Main.storyScenes.get("Entering bathroom"));
        }
    }
}
