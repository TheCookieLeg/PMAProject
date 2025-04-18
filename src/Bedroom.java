public class Bedroom implements Room{
    public void PlayRoom(){
        Main.storyScenes.clear();
        Main.storyScenes.put("Entering bedroom", new ChoiceClass("You enter the room. Total darkness. The light from the hallway is reflecting from some big rough shapes inside the room, but you can not determine what they are.",
                "Go back. You are afraid of the dark","Try to find a lightswitch","Look in your backpack for a flashlight"));
        Main.storyScenes.put("Look for lightswitch", new ChoiceClass("You blindly feel after a light switch, and find one to your left. You flick it, and nothing happens.",
                "Go back. You are afraid of the dark","Flick it again","Look in your backpack for a flashlight"));
        Main.storyScenes.put("Don't know how electricity works", new ChoiceClass("You dont know how electricity works, do you?",
                "Go back. You are afraid of the dark","Flick it again","Look in your backpack for a flashlight"));
        Main.storyScenes.put("Look for flashlight", new ChoiceClass("You find your flashlight. The light reveals the shapes to be bunk beds. The little bedroom is full of them. The beds are placed in a square around a chest in the middle of the room.",
                "Go back","Try searching the beds","Crawl through the beds to the chest"));
        Main.storyScenes.put("Search the beds", new ChoiceClass("You search the beds. Under the pillows and blankets are pictures of the cult and weird drawings. In the top bunks you find several cultists asleep.",
                "Go back","Try poking them","Crawl through the beds to the chest"));
        Main.storyScenes.put("Awful idea", new ChoiceClass("That is a genuinely awful idea. I'm just gonna be nice and say your basic survival instinct kicks in and prevents you from doing that.",
                "Go back","Try poking them again","Crawl through the beds to the chest"));
        Main.storyScenes.put("Standing in front of the chest", new ChoiceClass("You try crawling over the beds. You can hear snoring from the top bunks. You get to the middle of the room. You now stand in front of the chest.",
                "","Open it",""));
        Main.storyScenes.put("Opening chest", new ChoiceClass("You open the chest. The only thing in the chest is a sheath to a knife. The sheath has a weird shape. Almost looks like a key",
                "Put the sheath on the knife handle","Put the sheath in your pants","Put the knife in the sheath"));
        Main.storyScenes.put("Just no", new ChoiceClass("Just.... no",
                "Put the sheath on the knife handle","Put the sheath in your pants","Put the knife in the sheath"));
        Main.storyScenes.put("Completing the key", new ChoiceClass("Great! You put 2 and 2 together! Now you have a key. They usually unlock something",
                "","Go back down stairs",""));

        Main.setCurrentScene(Main.storyScenes.get("Entering bedroom"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}
    }
    public void StartRoom(){
        if(Main.getCurrentScene() == Main.storyScenes.get("Entering bedroom")) {
            Main.setChoiceOne(4);
            Main.setChoiceTwo(Main.storyScenes.get("Look for lightswitch"));
            Main.setChoiceThree(Main.storyScenes.get("Look for flashlight"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Look for lightswitch")) {
            Main.setChoiceOne(4);
            Main.setChoiceTwo(Main.storyScenes.get("Don't know how electricity works"));
            Main.setChoiceThree(Main.storyScenes.get("Look for flashlight"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Don't know how electricity works")) {
            Main.setChoiceOne(4);
            Main.setChoiceTwo(Main.storyScenes.get("Don't know how electricity works"));
            Main.setChoiceThree(Main.storyScenes.get("Look for flashlight"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Look for flashlight")) {
            Main.setChoiceOne(4);
            Main.setChoiceTwo(Main.storyScenes.get("Search the beds"));
            Main.setChoiceThree(Main.storyScenes.get("Standing in front of the chest"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Search the beds")) {
            Main.setChoiceOne(4);
            Main.setChoiceTwo(Main.storyScenes.get("Awful idea"));
            Main.setChoiceThree(Main.storyScenes.get("Standing in front of the chest"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Awful idea")) {
            Main.setChoiceOne(4);
            Main.setChoiceTwo(Main.storyScenes.get("Awful idea"));
            Main.setChoiceThree(Main.storyScenes.get("Standing in front of the chest"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Standing in front of the chest")) {
            Main.setChoiceOne(Main.storyScenes.get("Opening chest"));
            Main.setChoiceTwo(Main.storyScenes.get("Opening chest"));
            Main.setChoiceThree(Main.storyScenes.get("Opening chest"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Opening chest")) {
            Main.setChoiceOne(Main.storyScenes.get("Just no"));
            Main.setChoiceTwo(Main.storyScenes.get("Just no"));
            Main.setChoiceThree(Main.storyScenes.get("Completing the key"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Just no")) {
            Main.setChoiceOne(Main.storyScenes.get("Just no"));
            Main.setChoiceTwo(Main.storyScenes.get("Just no"));
            Main.setChoiceThree(Main.storyScenes.get("Completing the key"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Completing the key")) {
            Main.setChoiceOne(1);
            Main.setChoiceTwo(1);
            Main.setChoiceThree(1);
        }
    }

}
