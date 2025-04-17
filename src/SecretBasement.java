public class SecretBasement implements Room{
    public void PlayRoom(){
        Main.storyScenes.clear();


        Main.setCurrentScene(Main.storyScenes.get("Entering bedroom"));

        if(Main.getCurrentScene() != null){Main.UpdateText();}
    }
    public void StartRoom(){

    }
}
