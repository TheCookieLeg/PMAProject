public class UpstairsHallway implements Room{
    public void PlayRoom(){
        Main.storyScenes.clear();
        Main.storyScenes.put("Upstairs Hallway", new ChoiceClass("You walk up the stairs. Every step creaks under you. You should probably lose some weight. As you reach the top of the stairs, you find yourself in a hallway with a wall of pictures. To your left there is a door with a mysterious sound emanating from behind it. At the end of the hall way there is another door.",
                "Open the door to your left","Go to the door at the end of the hallway","Look at the pictures"));
        Main.storyScenes.put("Looking at pictures", new ChoiceClass("You take a closer look at the pictures on the wall. The large paintings depict robed figures worshipping... something. They are gathered around dark spots in all the pictures. You are unsure if the object of worship has been painted over, or if the cultists are just really big fans of shadowy circles.",
                "Go back","Go back","Go back"));
        Main.storyScenes.put("Infront of door", new ChoiceClass("You walk to the door at the end of the hallway. You grab the door handle. It is obviously locked. Have you never played a game before?",
                "Open the door","Kick the door down","Go back to the hallway"));
        Main.storyScenes.put("Kicking the door", new ChoiceClass("You are so weak",
                "Give up","Kick again","Go back to the hallway"));

        Main.setCurrentScene(Main.storyScenes.get("Upstairs Hallway"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}
    }
    public void StartRoom(){

        if(Main.getCurrentScene() == Main.storyScenes.get("Upstairs Hallway")) {
            Main.setChoiceOne(5);
            Main.setChoiceTwo(Main.storyScenes.get("Infront of door"));
            Main.setChoiceThree(Main.storyScenes.get("Looking at pictures"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Looking at pictures")) {
            Main.setChoiceOne(Main.storyScenes.get("Upstairs Hallway"));
            Main.setChoiceTwo(Main.storyScenes.get("Upstairs Hallway"));
            Main.setChoiceThree(Main.storyScenes.get("Upstairs Hallway"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Infront of door")) {
            Main.setChoiceOne(6);
            Main.setChoiceTwo(Main.storyScenes.get("Kicking the door"));
            Main.setChoiceThree(Main.storyScenes.get("Upstairs Hallway"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Kicking the door")) {
            Main.setChoiceOne(Main.storyScenes.get("Infront of door"));
            Main.setChoiceTwo(Main.storyScenes.get("Kicking the door"));
            Main.setChoiceThree(Main.storyScenes.get("Upstairs Hallway"));
        }
    }
}
