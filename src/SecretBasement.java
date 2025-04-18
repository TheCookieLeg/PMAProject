public class SecretBasement implements Room{
    public void PlayRoom(){
        Main.storyScenes.clear();

        Main.storyScenes.put("Enter basement", new ChoiceClass("You find yourself in a dim room. As your eyes adjust to the darkness, you see furniture laid out in a nonsensical display, chairs facing walls, tables stacked upon each other, a closet lying on its side. The dust on the floor is uneven, a multitude of tracks suggesting that some person or creature frequents this area.",
                "Leave while you still can / Call out","Brave the darkness","Investigate closet"));
        Main.storyScenes.put("Try to leave", new ChoiceClass("It is already too late. The way back has closed off. Something further ahead beckons you.",
                "","Continue",""));
        Main.storyScenes.put("Call out", new ChoiceClass("You call out. To the outside world or the dusty room. Regardless, the answer comes from the darkness ahead. A gurgling moan emerges from the shadows, accompanied by the form of a small pale creature. Its thin limbs breaks under its weight with every step towards you.",
                "Kick it","Stand still","Throw something at it"));
        Main.storyScenes.put("Kick the creature", new ChoiceClass("You kick the creature, not wanting to know what it wants. Its even lighter than it looks and tumbles across the room. It doesn't get up.",
                "Look around the room","Destroy the creature's remains","Cover the body"));
        Main.storyScenes.put("Stand still", new ChoiceClass("As the creature gets close, it starts scratching at your feet. You are unsure if it attempts to do harm. Its weak nails split as it claws at your boots, barely leaving indents. Its breathing gets more and more erratic as it increases its efforts until it collapses from exhaustion.",
                "Look around the room","Destroy the creature's remains","Cover the body"));
        Main.storyScenes.put("Throw something", new ChoiceClass("In a panic you grab the nearest object and hurl it at the creature. You hear the squelch of the impact before you even see what you threw. A heavy key now sticks out of the creatures soft head. A masterful shot. The creature's blood makes a sizzling sound and the key seems to melt around it. Hopefully that key isn't important.",
                "Look around the room","Destroy the creature's remains","Cover the body"));
        Main.storyScenes.put("Go deeper into the room", new ChoiceClass("You continue deeper into the room. You hear heavy thuds, perhaps from whatever made the tracks in the dust. Soon you see a figure wearing cultist robes. When it sees you, it shrieks, and several grotesque arms tears through the robes. It lunges at you.",
                "","Begin combat",""));
        Main.storyScenes.put("Investigating closet", new ChoiceClass("You turn the closet the right side up. Both doors and all but one drawer are missing. The remaining drawer has a keyhole. You find the key on a table near the entrance (if it wasn't thrown at creature), and unlock the drawer. Inside are papers written in a language you don't understand, plastered with notes and bookmarks. There is also a vial, filled with a dark liquid. It bears a wrapper, which is also written in the foreign language.",
                "Go back","Drink the liquid","Destroy the papers"));
        Main.storyScenes.put("Destroy papers", new ChoiceClass("Whatever is written on those papers, you fell that such terrible knowledge must not be preserved. You tear the papers, feeling as if a weight lifts from your shoulders.",
                "","Continue",""));

        Main.setCurrentScene(Main.storyScenes.get("Enter basement"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}

        StartRoom();
    }
    public void StartRoom(){
        if(Main.getCurrentScene() == Main.storyScenes.get("Enter basement")) {
            Main.setChoiceOne(Main.storyScenes.get("Try to leave"));
            Main.setChoiceTwo(Main.storyScenes.get("Go deeper into the room"));
            Main.setChoiceThree(Main.storyScenes.get("Investigating closet"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Try to leave")) {
            Main.setChoiceOne(Main.storyScenes.get("Enter basement"));
            Main.setChoiceTwo(Main.storyScenes.get("Enter basement"));
            Main.setChoiceThree(Main.storyScenes.get("Enter basement"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Call out")) {
            Main.setChoiceOne(Main.storyScenes.get("Kick the creature"));
            Main.setChoiceTwo(Main.storyScenes.get("Stand still"));
            Main.setChoiceThree(Main.storyScenes.get("Throw something"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Kick the creature")) {
            Main.setChoiceOne(Main.storyScenes.get("Enter basement"));
            Main.setChoiceTwo(Main.storyScenes.get("Enter basement"));
            Main.setChoiceThree(Main.storyScenes.get("Enter basement"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Stand still")) {
            Main.setChoiceOne(Main.storyScenes.get("Enter basement"));
            Main.setChoiceTwo(Main.storyScenes.get("Enter basement"));
            Main.setChoiceThree(Main.storyScenes.get("Enter basement"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Throw something")) {
            Main.setChoiceOne(Main.storyScenes.get("Enter basement"));
            Main.setChoiceTwo(Main.storyScenes.get("Enter basement"));
            Main.setChoiceThree(Main.storyScenes.get("Enter basement"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Go deeper into the room")) {
            // - Begin combat Main.setChoiceOne(Main.storyScenes.get("Enter basement"));
            // - Begin combat Main.setChoiceTwo(Main.storyScenes.get("Don't know how electricity works"));
            // - Begin combat Main.setChoiceThree(Main.storyScenes.get("Look for flashlight"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Investigating closet")) {
            Main.setChoiceOne(Main.storyScenes.get("Enter basement"));
            Main.setChoiceTwo(Main.storyScenes.get("Don't know how electricity works"));
            Main.setChoiceThree(Main.storyScenes.get("Destroy papers"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Destroy papers")) {
            Main.setChoiceOne(4);
            Main.setChoiceTwo(Main.storyScenes.get("Don't know how electricity works"));
            Main.setChoiceThree(Main.storyScenes.get("Look for flashlight"));
        }

    }
}
