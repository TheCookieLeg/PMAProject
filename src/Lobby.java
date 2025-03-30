import java.util.HashMap;
import java.util.Map;

public class Lobby implements Room {

    public void PlayRoom() {
        Main.storyScenes.clear();
        Main.storyScenes.put("Intro", new ChoiceClass("Welcome to the story screen! Please type which room you would like to go to", "Room 1","Room 2", "Room 3"));
        Main.setCurrentScene(Main.storyScenes.get("Intro"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}

        if(Main.getCurrentScene() == Main.storyScenes.get("Intro")){
            Main.setChoiceOne(1);
        }

    }

    public void StartRoom(){

    }
}
