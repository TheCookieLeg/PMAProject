public class DinningRoom implements Room{
    public void PlayRoom(){
        Main.storyScenes.clear();
        Main.storyScenes.put("After entering dinning room", new ChoiceClass("You enter the dining room. A grand dining table stands in the middle, with room for ten. At the end of the table is a golden chair, with red padding, just like those movies you used to watch. There's plates and silverware set up for the entire table. Did you interrupt someone's dinner by accident? And if so, where did they go? Adjacent to the dining room is the kitchen door. A dark aura eminates from it.",
                "Go back to lobby","Sit in golden chair","Go to kitchen"));
        Main.storyScenes.put("Sitting in the golden chair", new ChoiceClass("As you sit in the golden chair, you feel a sudden wave of pure dread. Everything in the room gets darker, and it feels like dark clouds are covering your eyes. You feel worms crawling under your skin, as your heart starts beating faster and faster. What's wrong with this chair??? You close your eyes, hoping for the best.",
                "Stay in chair","Scream","Get out of chair"));
        Main.storyScenes.put("Stay in chair", new ChoiceClass("For every second you sit in this chair, everything gets worse. You have to do something. Please.",
                "Stay in chair","Scream","Get out of chair"));
        Main.storyScenes.put("Scream", new ChoiceClass("You scream in pure agony and despair. What exactly is this supposed to help? Your only friend, the only person who has ever liked you, is dead. Who are you screaming to? The house? The chair? Who in this house are going to hear you scream? You're pathetic.",
                "Get out of chair","Get out of chair","Get out of chair"));

        Main.setCurrentScene(Main.storyScenes.get("After entering dinning room"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}



    }
    public void StartRoom(){
        if(Main.getCurrentScene() == Main.storyScenes.get("After entering dinning room")) {
            Main.setChoiceOne(1);
            Main.setChoiceTwo(Main.storyScenes.get("Sitting in the golden chair"));
            Main.setChoiceThree(3);
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Sitting in the golden chair")) {
            Main.setChoiceOne(Main.storyScenes.get("Stay in chair"));
            Main.setChoiceTwo(Main.storyScenes.get("Scream"));
            Main.setChoiceThree(Main.storyScenes.get("After entering dinning room"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Stay in chair")) {
            Main.setChoiceOne(Main.storyScenes.get("Stay in chair"));
            Main.setChoiceTwo(Main.storyScenes.get("Scream"));
            Main.setChoiceThree(Main.storyScenes.get("After entering dinning room"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Scream")) {
            Main.setChoiceOne(Main.storyScenes.get("After entering dinning room"));
            Main.setChoiceTwo(Main.storyScenes.get("After entering dinning room"));
            Main.setChoiceThree(Main.storyScenes.get("After entering dinning room"));
        }
    }
}
