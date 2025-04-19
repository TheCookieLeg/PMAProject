public class PrisonCell implements Room{
    public void PlayRoom(){
        Main.storyScenes.clear();

        Main.storyScenes.put("Enter cell", new ChoiceClass("[You fumble in the darkness. Suddenly the walls are lit up by torches, as if welcoming you.] Before you is a room which resembles a lab of unknown purpose. In one corner stands a bloody table with jagged saws strewn upon it. In another corner is a furnace with an alembic on top, liquid lying dormant inside. A prison cell looms in the opposite end of the room.",
                "Investigate bloody table","Investigate furnace","Investigate cell"));
        Main.storyScenes.put("Investigate furnace", new ChoiceClass("You take a closer look at the furnace with the alembic. Both are cold and covered in black soot. The liquid inside the alembic is blacker yet. The furnace seems like it would be easy to operate, or at least turn on. A scrawled paper is hung on the wall right behind the furnace. On it is a depiction of a robed figure offering up their own blood to a pit of flames.",
                "Go back","Turn on furnace, then offer [ITEM]","offer [ITEM], then turn on furnace"));
        Main.storyScenes.put("Investigate bloody table", new ChoiceClass("Upon the table lies saw, syringes, and scalpels, red from rust, blood, or both. The edge of the table has an array of jars full of various body parts. A notebook lies on the table. You don't understand the language it's written in, but two symbols are sketched on the page, a flame to the left of a drop.",
                "Go back","Take a jar","Extract some of you blood"));
        Main.storyScenes.put("Turn on furnace", new ChoiceClass("The body part writhes as it enters the bubbling liquid, rapidly boiling over and spilling out of the alembic. The liquid seeps on the floor, quickly cooling and turning more solid. It expands from the tar-like pool, taking the shape of a humanoid creature, with many grotesque limbs",
                "","Begin combat",""));
        Main.storyScenes.put("Offer before turning on the furnace", new ChoiceClass("",
                "","Continue",""));
        Main.storyScenes.put("Investigate cell", new ChoiceClass("You stare into the cell. It is dark. So dark, in fact, that you cannot see where it ends. The walls might as well stretch endlessly beyond the bars.",
                "","Go back",""));
        Main.storyScenes.put("Turn on furnace succesfully", new ChoiceClass("Your blood eagerly mixes with the bubbling liquid. The air around you smells burnt, and you feel your head throbbing. You feel your senses dull to this world, in favor of letting another presence into your mind. Something beckons you to the cell.",
                "","Investigate cell",""));
        Main.storyScenes.put("Investigate cell final", new ChoiceClass("You grasp around the iron bars and gaze into the dark cell. A dreadful feeling overcomes you. You realize that freedom lies on the other side of the bars, somewhere beyond the darkness. You are trapped in this room, no way to return and no way forward, but you were never truly free. The dark emptiness in front of you taunts you with promises of true freedom, just out of reach. From the darkness, a voice that makes no sound wordlessly offers you to partake in this freedom, to be consumed by it.",
                "Accept","Refuse","Cover your ears"));
        Main.storyScenes.put("No escape", new ChoiceClass("You cannot escape it. You have already let it in by mixing your blood with its. It owns your will.",
                "Let it consume you","Let it consume you","Let it consume you"));

        Main.setCurrentScene(Main.storyScenes.get("Enter cell"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}

    }
    public void StartRoom(){
        if(Main.getCurrentScene() == Main.storyScenes.get("Enter cell")) {
            Main.setChoiceOne(Main.storyScenes.get("Investigate bloody table"));
            Main.setChoiceTwo(Main.storyScenes.get("Investigate furnace"));
            Main.setChoiceThree(Main.storyScenes.get("Investigate cell"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Investigate furnace")) {
            Main.setChoiceOne(Main.storyScenes.get("Enter cell"));
            Main.setChoiceTwo(Main.storyScenes.get("Turn on furnace"));
            Main.setChoiceThree(Main.storyScenes.get("Offer before turning on the furnace"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Investigate bloody table")) {
            Main.setChoiceOne(Main.storyScenes.get("Enter cell"));
            Main.setChoiceTwo(Main.storyScenes.get("Enter cell"));
            Main.setChoiceThree(Main.storyScenes.get("Enter cell"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Turn on furnace")) {
            // begin combat Main.setChoiceOne(Main.storyScenes.get("Try to leave"));
            // begin combat Main.setChoiceTwo(Main.storyScenes.get("Go deeper into the room"));
            // begin combat Main.setChoiceThree(Main.storyScenes.get("Investigating closet"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Offer before turning on the furnace")) {
            Main.setChoiceOne(Main.storyScenes.get("Enter cell"));
            Main.setChoiceTwo(Main.storyScenes.get("Enter cell"));
            Main.setChoiceThree(Main.storyScenes.get("Enter cell"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Investigate cell")) {
            Main.setChoiceOne(Main.storyScenes.get("Enter cell"));
            Main.setChoiceTwo(Main.storyScenes.get("Enter cell"));
            Main.setChoiceThree(Main.storyScenes.get("Enter cell"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Turn on furnace succesfully")) {
            Main.setChoiceOne(Main.storyScenes.get("Investigate cell final"));
            Main.setChoiceTwo(Main.storyScenes.get("Investigate cell final"));
            Main.setChoiceThree(Main.storyScenes.get("Investigate cell final"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Investigate cell final")) {
            Main.setChoiceOne(9);
            Main.setChoiceTwo(Main.storyScenes.get("No escape"));
            Main.setChoiceThree(Main.storyScenes.get("No escape"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("No escape")) {
            Main.setChoiceOne(9);
            Main.setChoiceTwo(9);
            Main.setChoiceThree(9);
        }
    }
}
