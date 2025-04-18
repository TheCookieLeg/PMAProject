public class Kitchen implements Room {
    public void PlayRoom(){
        Main.storyScenes.clear();
        Main.storyScenes.put("Entering kitchen", new ChoiceClass("You enter the kitchen. A rotten stench fills the air, almost bringing tears to your eyes. There are carcasses on all the tables, and the walls are smeared with blood. In the back of the room, a fridge is standing tall, untainted by the rest of the room. It stands out like a sore thumb compared to the rest of the room. A skeleton is sitting in front of it. Creepy.",
                "Look at the carcasses","Inspect the skeleton","Go back to dining room"));
        Main.storyScenes.put("Inspecting skeleton", new ChoiceClass("You go over to the skeleton. It's sitting up against the fridge, head held high. Almost like it's staring at you. In its hand is a [important item]. It shines brightly when in the graces of the flashlight. It could be useful, but you're not sure about stealing from the dead.",
                "Take the [important item]","Have a staring contest with the skeleton","Go back"));
        Main.storyScenes.put("Look at the carcasses", new ChoiceClass("It's just a bunch of carcasses. And they smell even worse up close. Please go back, it hurts my nose",
                "Go back","Go back","Go back"));
        Main.storyScenes.put("Taking important item", new ChoiceClass("You try to take the [IMPORTANT ITEM] from his hand. But his grip is strong. Wait, how is it strong? He's dead goddammit. After a bunch of tugging, you yell out in fury and kicked the arm holding the [IMPORTANT ITEM] with all your might. The arm breaks, and you get the [IMPORTANT ITEM]. You stare at the [ITEM] for a few seconds, but when you look back at the skeleton, it's turned to dust. Now the fridge is fully visible.",
                "Go back","Open the fridge","Punch the fridge"));
        Main.storyScenes.put("Staring contest", new ChoiceClass("After sitting there for 10 minutes, you give up. That guy is a tough opponent. Maybe because he's dead or something. Was this really worth your time?",
                "He was a worthy opponent","I won!!","He was stronger than expected..."));
        Main.storyScenes.put("Opening fridge", new ChoiceClass("You open the fridge, and the lights inside turn on, lighting up the entire room. The light is almost blinding. It feels like you've opened the door to heaven. After five minutes, your eyes adjust, and you can see inside the fridge. Inside stands a lone chocolate pudding. How long has this been here?",
                "Take it","Eat it","Close fridge"));
        Main.storyScenes.put("Punch fridge", new ChoiceClass("Your hand hurts now. Why would you do that???",
                "Go back","Open fridge","Punch fridge"));

        Main.setCurrentScene(Main.storyScenes.get("Entering kitchen"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}


    }
    public void StartRoom(){
        if(Main.getCurrentScene() == Main.storyScenes.get("Entering kitchen")) {
            Main.setChoiceOne(Main.storyScenes.get("Look at the carcasses"));
            Main.setChoiceTwo(Main.storyScenes.get("Inspecting skeleton"));
            Main.setChoiceThree(2);
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Inspecting skeleton")) {
            Main.setChoiceOne(Main.storyScenes.get("Taking important item"));
            Main.setChoiceTwo(Main.storyScenes.get("Staring contest"));
            Main.setChoiceThree(Main.storyScenes.get("Entering kitchen"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Look at the carcasses")) {
            Main.setChoiceOne(Main.storyScenes.get("Entering kitchen"));
            Main.setChoiceTwo(Main.storyScenes.get("Entering kitchen"));
            Main.setChoiceThree(Main.storyScenes.get("Entering kitchen"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Taking important item")) {
            Main.setChoiceOne(Main.storyScenes.get("Entering kitchen"));
            Main.setChoiceTwo(Main.storyScenes.get("Opening fridge"));
            Main.setChoiceThree(Main.storyScenes.get("Punch fridge"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Staring contest")) {
            Main.setChoiceOne(Main.storyScenes.get("Inspecting skeleton"));
            Main.setChoiceTwo(Main.storyScenes.get("Inspecting skeleton"));
            Main.setChoiceThree(Main.storyScenes.get("Inspecting skeleton"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Opening fridge")) {
            Main.setChoiceOne(Main.storyScenes.get("Entering kitchen"));
            Main.setChoiceTwo(Main.storyScenes.get("Entering kitchen"));
            Main.setChoiceThree(Main.storyScenes.get("Entering kitchen"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Punch fridge")) {
            Main.setChoiceOne(Main.storyScenes.get("Entering kitchen"));
            Main.setChoiceTwo(Main.storyScenes.get("Opening fridge"));
            Main.setChoiceThree(Main.storyScenes.get("Punch fridge"));
        }

    }
}
