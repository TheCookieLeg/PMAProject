public class UpstairsHallway implements Room{

    private boolean beenInRoom = false;

    private boolean comingFromBedroom = false;
    private boolean comingFromBathroom = false;
    public void PlayRoom(){
        Main.storyScenes.clear();
        Main.storyScenes.put("Upstairs Hallway", new ChoiceClass("You walk up the stairs. Every step creaks under you. You should probably lose some weight. As you reach the top of the stairs, you find yourself in a hallway with a wall of pictures. To your left there is a door with a mysterious sound emanating from behind it. At the end of the hall way there is another door.",
                "Go to the left","Go to end of hallway","Go back"));
        Main.storyScenes.put("Infront of door", new ChoiceClass("You walk to the door at the end of the hallway. You grab the door handle. It is obviously locked. Have you never played a game before?",
                "Open the door","Kick the door down","Go back to the hallway"));
        Main.storyScenes.put("Kicking the door", new ChoiceClass("You are so weak",
                "Give up","Kick again","Go back to the hallway"));
        Main.storyScenes.put("DoorLocked", new ChoiceClass("I told you, the door is locked. Listen to me goddammit!",
                "I'm sorry", "I only listen to myself... It's locked", "Okay, MOM"));

        Main.setCurrentScene(Main.storyScenes.get("Upstairs Hallway"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}


    }
    public void StartRoom(){

        if(Main.getCurrentScene() == Main.storyScenes.get("Upstairs Hallway")) {
            Main.setChoiceOne(5);
            Main.setChoiceTwo(Main.storyScenes.get("Infront of door"));
            Main.setChoiceThree(1);

            if(beenInRoom){
                Main.getCurrentScene().setStoryText("You find yourself back in the hallway.");
            }

            beenInRoom = true;
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Infront of door")) {
            Main.setChoiceOne(Main.storyScenes.get("DoorLocked"));
            Main.setChoiceTwo(Main.storyScenes.get("Kicking the door"));
            Main.setChoiceThree(Main.storyScenes.get("Upstairs Hallway"));
            if(Main.items.contains("Bedroom Key")) {
                Main.setChoiceOne(6);
            }
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Kicking the door")) {
            Main.setChoiceOne(Main.storyScenes.get("Infront of door"));
            Main.setChoiceTwo(Main.storyScenes.get("Kicking the door"));
            Main.setChoiceThree(Main.storyScenes.get("Upstairs Hallway"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("DoorLocked")) {
            Main.setChoiceOne(Main.storyScenes.get("Infront of door"));
            Main.setChoiceTwo(Main.storyScenes.get("Infront of door"));
            Main.setChoiceThree(Main.storyScenes.get("Infront of door"));
        }
    }
}
