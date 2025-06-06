import javax.imageio.stream.ImageInputStream;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Room1 extends Room {

    //private Map<String, ChoiceClass> storyScenes = new HashMap<String, ChoiceClass>();


    public void PlayRoom() {
        Main.storyScenes.clear();
        Main.storyScenes.put("Enter Room", new ChoiceClass("You just entered the room", "Door 1","Door 2", "Door 3"));
        Main.storyScenes.put("Door", new ChoiceClass("Does it work now?","","",""));
        Main.storyScenes.put("Question", new ChoiceClass("Hello?","Yes","No","Stay silent"));
        Main.setCurrentScene(Main.storyScenes.get("Enter Room"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}
        System.out.println("Test");

        StartRoom();

    }

    private void StartRoom() {
        if(Main.getCurrentScene() == Main.storyScenes.get("Enter Room")) {
            System.out.println("Please enter room number");
            Main.setChoiceOne(Main.storyScenes.get("Question"), -1);
            Main.setChoiceTwo(Main.storyScenes.get("Door"), -1);
            StartRoom();
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Door")) {

        }
    }

}
