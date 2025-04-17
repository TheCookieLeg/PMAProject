import java.util.HashMap;
import java.util.Map;

public class Lobby implements Room {

    public void PlayRoom() {
        Main.storyScenes.clear();
        Main.storyScenes.put("Intro", new ChoiceClass("Welcome to the story screen! Please type which room you would like to go to", "Room 1","Room 2", "Room 3"));

        Main.storyScenes.put("After Entering", new ChoiceClass("You enter. Two things alert you to how big of a mistake that was. One, you hear a click as the door behind you locks on its own. Two, leaning against the wall lies the unmoving corpse of your buddy Will. Aside from those unpleasant details, you also notice a doorway to a dining room, and a flight of stairs, going up.",
                "Investigate corpse / Investigate indent", "Go to dining room", "Go upstairs"));
        Main.storyScenes.put("Finding dagger", new ChoiceClass("A dagger stick out from Will's shoulder, a trail of semi-dried blood seeping from the wound.",
                "Go back", "Take dagger", "Try to wake him up"));
        Main.storyScenes.put("Removing dagger", new ChoiceClass("[As you remove the dagger, Will's body leans to the side and you notice an indent in the wall behind him.] [There is an indent in the wall next to Will's corpse.] It is somewhat dagger-shaped. How convenient.",
                "Go back","Place dagger in indent","Investigate wall"));
        Main.storyScenes.put("Try waking him up", new ChoiceClass("Yup, he's dead. dead-dead. deaditty-dead. You are not waking this guy up.",
                "","Continue",""));
        Main.storyScenes.put("Placing dagger", new ChoiceClass("Not as convenient as you thought. The dagger fits in, it's just too small in some areas. Something is missing. Maybe you can find out what if you look around.",
                "","Continue",""));
        Main.storyScenes.put("Investigating wall", new ChoiceClass("Looking closer, you notice a rectangular slit around the indent, like a small doorway. It's too thin for you to push your fingers in and get a grip around it, and it doesn't react to being pushed. Perhaps some sort of mechanism is needed to move this wall.",
                "","Continue",""));
        Main.storyScenes.put("Placing dagger succesfully", new ChoiceClass("With the sheath and the crystal attached, the dagger fits perfectly. It clicks, and the wall starts turning, revealing another room behind it. You slip in as it turns, and find yourself at the top of a stairway, leading down. The wall settles into place behind you. The dagger is stuck inside the indent, it no longer responds to anything you do. The only way is down.",
                "","Continue",""));


        Main.setCurrentScene(Main.storyScenes.get("After Entering"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}

        /*if(Main.getCurrentScene() == Main.storyScenes.get("After Entering")){
            Main.setChoiceOne(1);
        }*/

    }

    public void StartRoom(){
        if(Main.getCurrentScene() == Main.storyScenes.get("After Entering")) {
            Main.setChoiceOne(Main.storyScenes.get("Finding dagger"));
            Main.setChoiceTwo(2);
            Main.setChoiceThree(4);
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Finding dagger")) {
            Main.setChoiceOne(Main.storyScenes.get("After Entering"));
            Main.setChoiceTwo(Main.storyScenes.get("Removing dagger"));
            Main.setChoiceThree(Main.storyScenes.get("Try waking him up"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Removing dagger")) {
            Main.setChoiceOne(Main.storyScenes.get("Finding dagger"));
            Main.setChoiceTwo(Main.storyScenes.get("Placing dagger"));
            Main.setChoiceThree(Main.storyScenes.get("Investigating wall"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Try waking him up")) {
            Main.setChoiceOne(Main.storyScenes.get("Finding dagger"));
            Main.setChoiceTwo(Main.storyScenes.get("Finding dagger"));
            Main.setChoiceThree(Main.storyScenes.get("Finding dagger"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Placing dagger")) {
            Main.setChoiceOne(Main.storyScenes.get("Removing dagger"));
            Main.setChoiceTwo(Main.storyScenes.get("Removing dagger"));
            Main.setChoiceThree(Main.storyScenes.get("Removing dagger"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Investigating wall")) {
            Main.setChoiceOne(Main.storyScenes.get("Removing dagger"));
            Main.setChoiceTwo(Main.storyScenes.get("Removing dagger"));
            Main.setChoiceThree(Main.storyScenes.get("Removing dagger"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Placing dagger succesfully")) {
            Main.setChoiceOne(7);
            Main.setChoiceTwo(7);
            Main.setChoiceThree(7);
        }
    }
}
