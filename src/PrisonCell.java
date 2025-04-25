public class PrisonCell implements Room{
    private boolean hasBeenInRoom = false;
    private String puzzleItem = "nothing";
    public void PlayRoom(){
        Main.storyScenes.clear();

        Main.storyScenes.put("Enter cell", new ChoiceClass("You fumble in the darkness. Suddenly the walls are lit up by torches, as if welcoming you. Before you is a room which resembles a lab of unknown purpose. In one corner stands a bloody table with jagged saws strewn upon it. In another corner is a furnace with an alembic on top, liquid lying dormant inside. A prison cell looms in the opposite end of the room.",
                "Investigate bloody table","Investigate furnace","Investigate cell"));
        Main.storyScenes.put("Take jar", new ChoiceClass("You take one of the jars from the table. It's sticky. Ew",
                "Go back", "Extract blood instead", "Go to furnace"));
        Main.storyScenes.put("Extract blood", new ChoiceClass("You take a syringe and insert it into your arm. Your blood quickly fills the vial connected to the syringe. You take it with you",
                "Go back", "Take a jar instead", "Go to furnace"));
        Main.storyScenes.put("Investigate furnace", new ChoiceClass("You take a closer look at the furnace with the alembic. Both are cold and covered in black soot. The liquid inside the alembic is blacker yet. The furnace seems like it would be easy to operate, or at least turn on. A scrawled paper is hung on the wall right behind the furnace. On it is a depiction of a robed figure offering up their own blood to a pit of flames.",
                "Go back","Turn on furnace, then offer [ITEM]","offer [ITEM], then turn on furnace"));
        Main.storyScenes.put("Investigate bloody table", new ChoiceClass("Upon the table lies saw, syringes, and scalpels, red from rust, blood, or both. The edge of the table has an array of jars full of various body parts. A notebook lies on the table. You don't understand the language it's written in, but two symbols are sketched on the page, a flame to the left of a drop.",
                "Go back","Take a jar","Extract some of your blood"));
        Main.storyScenes.put("Furnace enemy creation", new ChoiceClass("The body part writhes as it enters the bubbling liquid, rapidly boiling over and spilling out of the alembic. The liquid seeps on the floor, quickly cooling and turning more solid. It expands from the tar-like pool, taking the shape of a humanoid creature, with many grotesque limbs",
                "","Begin combat",""));
        Main.storyScenes.put("Offer before turning on the furnace", new ChoiceClass("",
                "","Continue",""));
        Main.storyScenes.put("Nothing to offer", new ChoiceClass("You have nothing to offer? Are you dense?",
                "...", "...", "..."));
        Main.storyScenes.put("Investigate cell", new ChoiceClass("You stare into the cell. It is dark. So dark, in fact, that you cannot see where it ends. The walls might as well stretch endlessly beyond the bars.",
                "","Go back",""));
        Main.storyScenes.put("Turn on furnace succesfully", new ChoiceClass("Your blood eagerly mixes with the bubbling liquid. The air around you smells burnt, and you feel your head throbbing. You feel your senses dull to this world, in favor of letting another presence into your mind. Something beckons you to the cell.",
                "","Investigate cell",""));
        Main.storyScenes.put("Investigate cell final", new ChoiceClass("You grasp around the iron bars and gaze into the dark cell. A dreadful feeling overcomes you. You realize that freedom lies on the other side of the bars, somewhere beyond the darkness. You are trapped in this room, no way to return and no way forward, but you were never truly free. The dark emptiness in front of you taunts you with promises of true freedom, just out of reach. From the darkness, a voice that makes no sound wordlessly offers you to partake in this freedom, to be consumed by it.",
                "Accept","Refuse","Cover your ears"));
        Main.storyScenes.put("No escape", new ChoiceClass("You cannot escape it. You have already let it in by mixing your blood with its. It owns your will.",
                "Let it consume you","Let it consume you","Let it consume you"));
        Main.storyScenes.put("End", new ChoiceClass("You are consumed by the darkness, and by transcending your mortal form, you discover true freedom.",
                "", "I am truly free", ""));
        Main.storyScenes.put("Thank you", new ChoiceClass("Thank you for playing our game :) \nBest regards \nASM, Platz and TheCookieLegend",
                "Quit the game", "Quit the program", "Quit the application"));
        Main.storyScenes.put("The blob", new CombatScene("The blob","What the HELL is that!? You can barely move from pure fear. But you have to, if you want to survive.",15, 10, Main.storyScenes.get("Enter cell")));

        Main.setCurrentScene(Main.storyScenes.get("Enter cell"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}

    }
    public void StartRoom(){
        if(Main.getCurrentScene() == Main.storyScenes.get("Enter cell")) {
            if (hasBeenInRoom) {Main.getCurrentScene().setStoryText("Before you is a room which resembles a lab of unknown purpose. In one corner stands a bloody table with jagged saws strewn upon it. In another corner is a furnace with an alembic on top, liquid lying dormant inside. A prison cell looms in the opposite end of the room.");}
            hasBeenInRoom = true;
            Main.setChoiceOne(Main.storyScenes.get("Investigate bloody table"));
            Main.setChoiceTwo(Main.storyScenes.get("Investigate furnace"));
            Main.setChoiceThree(Main.storyScenes.get("Investigate cell"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Investigate furnace")) {
            Main.setChoiceOne(Main.storyScenes.get("Enter cell"));
            Main.getCurrentScene().setChoice2text("Turn on furnace, then offer " + puzzleItem);
            Main.getCurrentScene().setChoice3text("Offer " + puzzleItem + ", then turn on the furnace");
            Main.setChoiceThree(Main.storyScenes.get("Offer before turning on the furnace"));
            if(puzzleItem.equals("jar with body part")) {
                Main.setChoiceTwo(Main.storyScenes.get("Furnace enemy creation"));
            }
            else if (puzzleItem.equals("vial of your own blood")) {
                Main.setChoiceTwo(Main.storyScenes.get("Turn on furnace succesfully"));
            }
            else if (puzzleItem.equals("nothing")) {
                Main.setChoiceTwo(Main.storyScenes.get("Offer before turning on the furnace"));
            }
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Investigate bloody table")) {
            Main.setChoiceOne(Main.storyScenes.get("Enter cell"));
            Main.setChoiceTwo(Main.storyScenes.get("Take jar"));
            Main.setChoiceThree(Main.storyScenes.get("Extract blood"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Take jar")) {
            puzzleItem = "jar with body part";
            Main.setChoiceOne(Main.storyScenes.get("Enter cell"));
            Main.setChoiceTwo(Main.storyScenes.get("Extract blood"));
            Main.setChoiceThree(Main.storyScenes.get("Investigate furnace"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Extract blood")) {
            puzzleItem = "vial of your own blood";
            Main.setChoiceOne(Main.storyScenes.get("Enter cell"));
            Main.setChoiceTwo(Main.storyScenes.get("Take jar"));
            Main.setChoiceThree(Main.storyScenes.get("Investigate furnace"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Furnace enemy creation")) {
            Main.setChoiceOne(Main.storyScenes.get("The blob"));
            Main.setChoiceTwo(Main.storyScenes.get("The blob"));
            Main.setChoiceThree(Main.storyScenes.get("The blob"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("Offer before turning on the furnace")) {
            if(puzzleItem.equals("nothing")) {
                Main.getCurrentScene().setStoryText("You have nothing to offer. What are you trying to do?");
            }
            else {
                Main.getCurrentScene().setStoryText("Before you manage to turn on the furnace, the " + puzzleItem + " sizzles as it is consumed by the dark liquid within the alembic, becoming one with it. It produces no other effect, even as you turn on the furnace, and somehow cools immediately, as you turn it off.");
            }

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
            Main.setChoiceOne(Main.storyScenes.get("End"));
            Main.setChoiceTwo(Main.storyScenes.get("No escape"));
            Main.setChoiceThree(Main.storyScenes.get("No escape"));
        }

        if(Main.getCurrentScene() == Main.storyScenes.get("No escape")) {
            Main.setChoiceOne(Main.storyScenes.get("End"));
            Main.setChoiceTwo(Main.storyScenes.get("End"));
            Main.setChoiceThree(Main.storyScenes.get("End"));
        }

        if (Main.getCurrentScene() == Main.storyScenes.get("The blob")) {
            Main.getCurrentScene().InitiateCombat();
        }

        if (Main.getCurrentScene() == Main.storyScenes.get("End")) {
            Main.setChoiceOne(Main.storyScenes.get("Thank you"));
            Main.setChoiceTwo(Main.storyScenes.get("Thank you"));
            Main.setChoiceThree(Main.storyScenes.get("Thank you"));
        }

        if (Main.getCurrentScene() == Main.storyScenes.get("Thank you")) {
            Main.setChoiceOne(-1);
            Main.setChoiceTwo(-1);
            Main.setChoiceThree(-1);
        }
    }
}
